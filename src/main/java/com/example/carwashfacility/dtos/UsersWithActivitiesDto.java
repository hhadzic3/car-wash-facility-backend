package com.example.carwashfacility.dtos;

import com.example.carwashfacility.models.Washing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersWithActivitiesDto {
    private long id;
    private String email;
    private Integer numberOdWashes;
    private List<Washing> activities;
}

