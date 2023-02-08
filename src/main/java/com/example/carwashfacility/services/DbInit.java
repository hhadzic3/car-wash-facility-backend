package com.example.carwashfacility.services;

import com.example.carwashfacility.models.*;
import com.example.carwashfacility.models.Package;
import com.example.carwashfacility.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final PackageRepository packageRepository;
    private final StepRepository stepRepository;
    private final WashingRepository washingRepository;
    private final PackageStepRepository packageStepRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, LocationRepository locationRepository, PackageRepository packageRepository, WashingRepository washingRepository, PackageStepRepository packageStepRepository, StepRepository stepRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.locationRepository = locationRepository;
        this.packageRepository = packageRepository;
        this.packageStepRepository = packageStepRepository;
        this.stepRepository = stepRepository;
        this.washingRepository = washingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        this.packageStepRepository.deleteAll();
        this.washingRepository.deleteAll();
        this.userRepository.deleteAll();
        this.locationRepository.deleteAll();
        this.stepRepository.deleteAll();
        this.packageRepository.deleteAll();

        User dan = new User(1, "harun@gmail.com", passwordEncoder.encode("password"), true, User.Role.ROLE_USER, 0);
        User aco = new User(3, "aco@gmail.com", passwordEncoder.encode("password"), true, User.Role.ROLE_USER, 0);
        User admin = new User(2,"admin@gmail.com",passwordEncoder.encode("password"),true, User.Role.ROLE_ADMIN,0);
        List<User> users = Arrays.asList(dan,admin,aco);
        this.userRepository.saveAll(users);

        Location location1 = new Location(1, "BiH, Sarajevo, Vranik");
        Location location2 = new Location(2, "BiH, Sarajevo, Hrasno");
        Location location3 = new Location(3, "BiH, Sarajevo, Ilidža, Pejton");
        List<Location> locations = Arrays.asList(location1, location2, location3);
        this.locationRepository.saveAll(locations);

        Step step1 = new Step(1, "Pre-Soak");
        Step step2 = new Step(2, "Wash");
        Step step3 = new Step(3, "Wax");
        Step step4 = new Step(4, "Tire cleaner");
        Step step5 = new Step(5, "Triple Foam wax");
        Step step6 = new Step(6, "Clear coat wax");
        Step step7 = new Step(7, "Spot free rinse");
        Step step8 = new Step(8, "Dry");
        List<Step> steps = Arrays.asList(step1, step2, step3, step4, step5, step6, step7, step8);
        this.stepRepository.saveAll(steps);

        Package package1 = new Package(1, "Basic", 90.0);
        Package package2 = new Package(2, "Pro", 100.0);
        Package package3 = new Package(3, "Top League", 120.0);
        Package package4 = new Package(4, "King treatment", 150.0);
        List<Package> packages = Arrays.asList(package1, package2, package3, package4);
        this.packageRepository.saveAll(packages);

        PackageStep packageStep1 = new PackageStep(1, package1, step1, 1);
        PackageStep packageStep2 = new PackageStep(2, package1, step2, 2);
        PackageStep packageStep3 = new PackageStep(3, package1, step8, 3);
        PackageStep packageStep4 = new PackageStep(4, package2, step2, 1);
        PackageStep packageStep5 = new PackageStep(5, package2, step4, 2);
        PackageStep packageStep6 = new PackageStep(6, package2, step6, 3);
        PackageStep packageStep7 = new PackageStep(7, package3, step1, 1);
        PackageStep packageStep8 = new PackageStep(8, package3, step3, 2);
        PackageStep packageStep9 = new PackageStep(9, package3, step7, 3);
        PackageStep packageStep10 = new PackageStep(10, package4, step2, 1);
        PackageStep packageStep11 = new PackageStep(11, package4, step3, 2);
        PackageStep packageStep12 = new PackageStep(12, package4, step4, 3);
        List<PackageStep> packageSteps = Arrays.asList(packageStep1, packageStep2, packageStep3,
                packageStep4, packageStep5, packageStep6, packageStep7, packageStep8, packageStep9,
                packageStep10, packageStep11, packageStep12);
        packageStepRepository.saveAll(packageSteps);

        List<Washing> washings = Arrays.asList(
                new Washing(1, location1, package2, aco, new Date()),
                new Washing(2, location2, package1, aco, new Date()),
                new Washing(3, location3, package3, aco, new Date())
                );
        washingRepository.saveAll(washings);
        */
    }
}
