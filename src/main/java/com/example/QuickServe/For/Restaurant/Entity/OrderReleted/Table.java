package com.example.QuickServe.For.Restaurant.Entity.OrderReleted;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tableNumber;

    private Boolean active = true;

    //connect to the Orders (One table Have many orders) that's why we are used OneToMany mapping In Table
    @OneToMany(mappedBy = "tableRestaurant")
    private List<Orders> orders;
}
