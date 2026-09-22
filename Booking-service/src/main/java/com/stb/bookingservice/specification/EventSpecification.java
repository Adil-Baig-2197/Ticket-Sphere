package com.stb.bookingservice.specification;

import com.stb.bookingservice.entity.Event;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class EventSpecification {
    public static Specification<Event> getEventSpecification(Instant time) {
        return new  Specification<Event>() {
            @Override
            public @Nullable Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.lessThanOrEqualTo(root.get("start_time"),time));
                return criteriaBuilder.or(list.toArray(new Predicate[0]));
            }
        };
    }
}
