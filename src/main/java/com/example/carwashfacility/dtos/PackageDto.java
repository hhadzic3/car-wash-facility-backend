package com.example.carwashfacility.dtos;

import com.example.carwashfacility.models.PackageStep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PackageDto {
    private long id;
    private String name;
    private Double cost;
    private List<PackageStep> packageStep;
}
