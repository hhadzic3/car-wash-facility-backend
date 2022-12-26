package com.example.carwashfacility.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@NoArgsConstructor
public class AuthentificationRequestDto {
    private String email;
    private String password;
}
