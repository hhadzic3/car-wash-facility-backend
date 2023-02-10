package com.example.carwashfacility.services;

import com.example.carwashfacility.dtos.CreateWashingDto;
import com.example.carwashfacility.models.Location;
import com.example.carwashfacility.models.Package;
import com.example.carwashfacility.models.User;
import com.example.carwashfacility.models.Washing;
import com.example.carwashfacility.repositories.LocationRepository;
import com.example.carwashfacility.repositories.PackageRepository;
import com.example.carwashfacility.repositories.UserRepository;
import com.example.carwashfacility.repositories.WashingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class WashingService {

    @Autowired
    WashingRepository washingRepository;

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    private LocationRepository locationRepository;

    public Washing save(CreateWashingDto washingDto) {

        Optional<User> optionalUser = userRepository.findById(washingDto.getUser());
        User user = optionalUser.orElseThrow();

        Optional<Location> optionalLocation = locationRepository.findById(washingDto.getLocation());
        Location location = optionalLocation.orElseThrow();

        Optional<Package> optionalPackage = packageRepository.findById(washingDto.getPack());
        Package pack = optionalPackage.orElseThrow();
        if (user.getNumberOdWashes()+1 == 10)
            user.setNumberOdWashes(0);
        else user.setNumberOdWashes(user.getNumberOdWashes()+1);
        userRepository.save(user);

        return washingRepository
                .save(Washing.builder()
                        .user(user)
                        .location(location)
                        .pack(pack)
                        .time(new Date())
                        .build());
    }
}
