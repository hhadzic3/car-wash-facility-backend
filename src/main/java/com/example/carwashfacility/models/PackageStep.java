package com.example.carwashfacility.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackageStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private Package pack;

    @ManyToOne
    @JoinColumn(name = "step_id", nullable = false)
    private Step step;

    @Column(name = "sequence_number", nullable = false)
    private Integer sequenceNumber;
}
