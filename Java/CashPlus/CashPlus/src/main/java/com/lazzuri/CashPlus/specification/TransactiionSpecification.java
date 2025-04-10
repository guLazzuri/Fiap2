package com.lazzuri.CashPlus.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.lazzuri.CashPlus.controller.TransactionController.TransactionFilter;
import com.lazzuri.CashPlus.model.Transaction;

import jakarta.persistence.criteria.Predicate;

public class TransactiionSpecification {

    public static Specification<Transaction> withFilter(TransactionFilter filter){
            return (root, query, cb) -> {
                List<Predicate> predicates = new ArrayList<>();
                if(filter.description() != null && !filter.description().isBlank()){
                    predicates.add(
                        cb.like(
                            cb.lower(root.get("description")), "%" + filter.description() + "%"
                            )
                        );
                    }

                    if (filter.startDate() != null && filter.endDate() != null){
                        predicates.add(
                            cb.between((root.get("date")), filter.startDate(), filter.endDate())
                        );
                    }

                    if(filter.startDate() != null && filter.endDate() == null){
                        predicates.add(cb.equal(root.get("date"), filter.startDate()));
                    }
                    
                return cb.and(predicates.toArray(new Predicate[0]));
                
            };
        
    }
}
