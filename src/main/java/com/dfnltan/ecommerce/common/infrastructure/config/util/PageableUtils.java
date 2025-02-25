package com.dfnltan.ecommerce.common.infrastructure.config.util;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface PageableUtils {
    int MAX_ITEMS_PER_PAGE = 1000;

    static Pageable of(int page, int size) {
        return PageRequest.of(page, Math.min(size, MAX_ITEMS_PER_PAGE));
    }

    static Pageable of(int page, int size, Sort sort) {
        return PageRequest.of(page, Math.min(size, MAX_ITEMS_PER_PAGE), sort);
    }

    static <T> Page<T> convertListToPage(List<T> list, Pageable pageable, Integer total) {
        List<T> listPage = extractPageContent(list, pageable);
        return new PageImpl<>(listPage, pageable, ObjectUtils.firstNonNull(total, list.size()));
    }

    static <T> List<T> extractPageContent(List<T> items, Pageable pageable) {
        if (pageable.getPageSize() <= 0) {
            throw new IllegalArgumentException("Page size must be greater than 0");
        }

        int totalItems = items.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageable.getPageSize());

        if (pageable.getPageNumber() < 0 || pageable.getPageSize() >= totalPages) {
            return Collections.emptyList();
        }

        int start = pageable.getPageNumber() * pageable.getPageSize();

        return items.stream()
                .skip(start)
                .limit(pageable.getPageSize())
                .collect(Collectors.toList());
    }

    static <T> boolean hasItemsInPage(List<T> items, int page, int size) {
        if (items == null || size <= 0 || page < 0) {
            return false;
        }

        int fromIndex = page * size;
        return fromIndex < items.size();
    }
}
