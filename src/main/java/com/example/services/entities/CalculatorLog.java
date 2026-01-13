package com.example.services.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "calculator_log")
@Getter
@Setter
public class CalculatorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String operation;

    private double number1;
    private double number2;

    private double result;
}
