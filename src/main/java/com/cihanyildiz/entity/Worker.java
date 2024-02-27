package com.cihanyildiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Long salary;
    private String branch;
}
