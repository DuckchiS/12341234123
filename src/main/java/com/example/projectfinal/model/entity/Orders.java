package com.example.projectfinal.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders", schema = "order_schema")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Order_State;
    private int Order_Quantity;

    @ManyToOne
    private Item item;

    @Temporal(TemporalType.DATE)
    private Date date;
}
