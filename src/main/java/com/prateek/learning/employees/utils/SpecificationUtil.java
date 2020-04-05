package com.prateek.learning.employees.utils;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SpecificationUtil {

    public static <T> Specification<T> buildAndQuery(@NonNull List<Specification<T>> specifications) {

        specifications.removeIf(Objects::isNull);

        if (specifications.isEmpty()) {
            // always returns true
            return Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.and());
        }

        Iterator<Specification<T>> iterator = specifications.iterator();

        Specification<T> base = Specification.where(iterator.next());
        while (iterator.hasNext()) {
            base = base.and(iterator.next());
        }
        return base;
    }

    public static <T> Specification<T> buildOrQuery(@NonNull List<Specification<T>> specifications) {

        specifications.removeIf(Objects::isNull);

        if (specifications.isEmpty()) {
            // always returns true
            return Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.and());
        }

        Iterator<Specification<T>> iterator = specifications.iterator();

        Specification<T> base = Specification.where(iterator.next());
        while (iterator.hasNext()) {
            base = base.or(iterator.next());
        }
        return base;
    }

}
