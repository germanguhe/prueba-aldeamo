package com.aldeamo.bar.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "arrays")
public class ArraysModel {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "input_array")
    private String inputArray;
}
