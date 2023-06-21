package org.example.entity;

import lombok.*;
import org.example.base.entity.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product extends BaseEntity<Long> {
    private String categoryName;
    private String typeName;
    private int availability;
    private long price;
}
