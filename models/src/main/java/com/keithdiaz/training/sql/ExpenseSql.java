package com.keithdiaz.training.sql;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Expense")
public class ExpenseSql {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "amount")
    private float amount;
    
    @Column(name = "createdAt")
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updateAt;

    @PrePersist
    protected void onCreate(){
        createdAt = Instant.now();
        updateAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updateAt = Instant.now();
    }

}
