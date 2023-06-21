package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Cart extends BaseEntity<Long> {
    private Long userID;
    private int totalItems;
    private long paycheck;
}
