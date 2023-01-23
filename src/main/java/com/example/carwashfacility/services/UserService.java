package com.example.carwashfacility.services;

import com.example.carwashfacility.dtos.PackageDto;
import com.example.carwashfacility.dtos.UsersWithActivitiesDto;
import com.example.carwashfacility.models.Package;
import com.example.carwashfacility.models.PackageStep;
import com.example.carwashfacility.models.User;
import com.example.carwashfacility.models.Washing;
import com.example.carwashfacility.repositories.UserRepository;
import com.example.carwashfacility.repositories.WashingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WashingRepository washingRepository;
    public void save(User user) {
        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<UsersWithActivitiesDto> findAllUsers() {
        List<User> users = userRepository.findByRole(User.Role.ROLE_USER);
        List<UsersWithActivitiesDto> usersDtos = new ArrayList<UsersWithActivitiesDto>();
        for (User u : users) {
            List<Washing> washings = washingRepository.findByUser(u);
            UsersWithActivitiesDto temp = new UsersWithActivitiesDto(
                    u.getId(),
                    u.getEmail(),
                    u.getNumberOdWashes(),
                    washings
            );
            usersDtos.add(temp);
        }
        return usersDtos;
    }
}
