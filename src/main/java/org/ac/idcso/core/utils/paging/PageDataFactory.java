package org.ac.idcso.core.utils.paging;


import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageDataFactory {

    private PageDataFactory(){
    }

    public static PageRequest of(PagingData pagingData) {
        if(StringUtils.isEmpty(pagingData.getDefaultSort())){
            return PageRequest.of(pagingData.getPage(), pagingData.getSize());
        }else{
            return PageRequest.of(pagingData.getPage(), pagingData.getSize(), Sort.by(pagingData.getDefaultSort()));
        }
    }



}
