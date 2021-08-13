package com.exposit.model.entity;

import com.exposit.model.api.OrderStatusModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "statuses")
public class OrderStatusEntity extends BaseEntity implements OrderStatusModel {

        @Column(name = "name")
        String name;

        @Override
        public String toString() {
            return "OrderStatusDb{"
                    + "name='" + name + '\''
                    + '}';
        }
    }
