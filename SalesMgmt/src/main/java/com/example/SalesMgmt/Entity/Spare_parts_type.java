package com.example.SalesMgmt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spare_parts_type")

public class Spare_parts_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parts_type_name")
    private String parts_type_name;

    @Column(name = "parts_type_description")
    private String parts_type_description;

    @Column(name = "is_active")
    private int is_active;

    @Column(name = "is_deleted")
    private int is_deleted;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp created_at;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private Timestamp modified_at;



}
