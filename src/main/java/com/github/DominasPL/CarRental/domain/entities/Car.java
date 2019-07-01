package com.github.DominasPL.CarRental.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String Brand;


}
