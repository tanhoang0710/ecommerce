package com.dfnltan.ecommerce.common.infrastructure.config.util;

import lombok.experimental.UtilityClass;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@UtilityClass
public class ListUtil {
    public static <T> List<T> union(@Nullable List<T> l1, @Nullable List<T> l2) {
        var result = new ArrayList<T>();
        if (l1 != null && !l1.isEmpty()) {
            result.addAll(l1);
        }
        if (l2 != null && !l2.isEmpty()) {
            result.addAll(l2);
        }
        return result;
    }

    public static <T> void sortList(List<T> items, @NonNull List<Comparator<T>> comparators) {
        if (comparators.isEmpty()) {
            return;
        }

        Comparator<T> compositeComparator = (item1, item2) -> {
            for (Comparator<T> comparator : comparators) {
                int result = comparator.compare(item1, item2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        };

        items.sort(compositeComparator);
    }
}
