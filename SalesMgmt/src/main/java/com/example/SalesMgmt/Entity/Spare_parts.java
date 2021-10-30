package com.example.SalesMgmt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.awt.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Spare_parts")

public class Spare_parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parts_name")
    private String parts_name;

    @OneToOne
    @JoinColumn(name = "spare_parts_type_id_fk")
    private Spare_parts_type spare_parts_type;

    @Column(name = "parts_description")
    private String parts_description;

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
