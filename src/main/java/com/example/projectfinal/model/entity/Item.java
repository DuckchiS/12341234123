package com.example.projectfinal.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item", schema = "items_schema")
public class Item {
    @Id
    private int ID;
    private String Item_Name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    List<Orders> orders = new ArrayList<>();

    private int price;

    private int Quantity;;
}
