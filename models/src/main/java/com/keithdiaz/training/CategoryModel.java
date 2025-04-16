package com.keithdiaz.training;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "categories")
public class CategoryModel {
    
    @Id
    private String id;
    private String title;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedBy
    private Instant updatedAt;
    
}
