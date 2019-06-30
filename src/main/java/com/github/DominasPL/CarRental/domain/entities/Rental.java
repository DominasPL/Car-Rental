package com.github.DominasPL.CarRental.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hireDate;

    @Column(nullable = false)
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hirePlace_id")
    private Place hirePlace;

    @ManyToOne
    @JoinColumn(name = "returnPlace_id")
    private Place returnPlace;

}
