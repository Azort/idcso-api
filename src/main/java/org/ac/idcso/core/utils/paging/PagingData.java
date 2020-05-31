package org.ac.idcso.core.utils.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ac.idcso.core.constants.CommonConstants;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingData {

    /**
     * Current page number, starts at 1.
     */
    @Min(value = CommonConstants.MINIMUM_PAGE_NUMBER)
    private int page = CommonConstants.DEFAULT_PAGE_NUMBER;

    /**
     * Number maximum of items by page.
     */
    @Min(value = CommonConstants.MINIMUM_PAGE_SIZE)
    private int size = CommonConstants.DEFAULT_PAGE_SIZE;

    private String defaultSort;

}
