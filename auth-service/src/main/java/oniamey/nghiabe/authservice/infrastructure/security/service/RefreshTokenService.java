package oniamey.nghiabe.authservice.infrastructure.security.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import oniamey.nghiabe.authservice.entities.RefreshToken;
import oniamey.nghiabe.authservice.infrastructure.security.oath2.user.UserPrincipal;
import oniamey.nghiabe.authservice.infrastructure.security.repositories.SecurityRefreshRepository;
import oniamey.nghiabe.authservice.utils.DateTimeUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    // 6 hours
    private final long REFRESH_EXPIRED_TIME = 6 * 60 * 60 * 1000;

    private final SecurityRefreshRepository refreshRepository;

    public Optional<RefreshToken> findByToken(String refreshToken) {
        return refreshRepository.findByRefreshToken(refreshToken);
    }

    public RefreshToken createRefreshToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Optional<RefreshToken> optionalRefreshToken = refreshRepository.findByUserId(userPrincipal.getId());

        if (optionalRefreshToken.isPresent()) {
            return getRefreshToken(optionalRefreshToken);
        }

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userPrincipal.getId());
        refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken = refreshRepository.save(refreshToken);
        return refreshToken;
    }

    private RefreshToken getRefreshToken(Optional<RefreshToken> optionalRefreshToken) {
        RefreshToken refreshToken = optionalRefreshToken.get();
        if (refreshToken.getRevokedAt() != null) {
            refreshToken.setRevokedAt(null);
            refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
            refreshToken.setRefreshToken(UUID.randomUUID().toString());
            return refreshRepository.save(optionalRefreshToken.get());
        }
        refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshRepository.save(refreshToken);
    }

    public RefreshToken createRefreshToken(Long userId) {
        Optional<RefreshToken> optionalRefreshToken = refreshRepository.findByUserId(userId);
        if (optionalRefreshToken.isPresent()) {
            return getRefreshToken(optionalRefreshToken);
        }

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setExpiredAt(REFRESH_EXPIRED_TIME);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken = refreshRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiredAt() < DateTimeUtil.convertDateToTimeStampSecond(new Date())) {
            refreshRepository.delete(token);
            return null;
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
        return refreshRepository.deleteByUserId(userId);
    }

}
