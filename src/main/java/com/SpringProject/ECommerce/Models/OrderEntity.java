package com.SpringProject.ECommerce.Models;

import com.SpringProject.ECommerce.enums.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="order_info")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderId;  // UUID

    @CreationTimestamp
    Date orderDate;

    String cardUsed;

    int orderTotal;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Customer customer;
}