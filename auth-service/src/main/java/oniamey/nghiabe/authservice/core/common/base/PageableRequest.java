package oniamey.nghiabe.authservice.core.common.base;

import lombok.Getter;
import lombok.Setter;
import oniamey.nghiabe.authservice.infrastructure.constant.model.PaginationConstant;

@Setter
@Getter
public class PageableRequest {

    private int page = PaginationConstant.DEFAULT_PAGE;

    private int size = PaginationConstant.DEFAULT_SIZE;

    private String orderBy = PaginationConstant.DEFAULT_ORDER_BY;

    private String sortBy = PaginationConstant.DEFAULT_SORT_BY;

    private String q = PaginationConstant.DEFAULT_Q;

}
