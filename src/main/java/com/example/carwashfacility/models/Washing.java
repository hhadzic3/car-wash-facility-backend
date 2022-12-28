package com.example.carwashfacility.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Washing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "location_id", nullable = false)
    private long locationId;

    @Column(name = "package_id", nullable = false)
    private long packageId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "time", nullable = false)
    private Date time;
}
