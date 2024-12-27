package oniamey.nghiabe.authservice.infrastructure.security.repositories;

import oniamey.nghiabe.authservice.entities.RefreshToken;
import oniamey.nghiabe.authservice.repositories.RefreshRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SecurityRefreshRepository extends RefreshRepository {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    Optional<RefreshToken> findByUserId(Long userId);

//    int deleteByUserId(Long userId);

    @Modifying
    @Transactional
    @Query(
            value = """
                    delete from refresh_token
                    where user_id = :userId
                    """,
            nativeQuery = true
    )
    int deleteByUserId(Long userId);

    @Query(
            value = """
                            SELECT revoked_at
                            FROM refresh_token rt
                            WHERE rt.user_id = :userId
                    """,
            nativeQuery = true
    )
    Long isRevoked(String userId);


    @Query(
            value = """
                    SELECT rt
                    FROM RefreshToken rt
                    WHERE rt.userId = :userId
                    """
    )
    RefreshToken getRefreshTokenByUserId(String userId);

}
