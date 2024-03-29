package com.decagon.OakLandv1be.config.companyConfig;

import com.decagon.OakLandv1be.entities.*;
import com.decagon.OakLandv1be.enums.BaseCurrency;
import com.decagon.OakLandv1be.enums.Gender;
import com.decagon.OakLandv1be.enums.Role;

import com.decagon.OakLandv1be.repositries.AdminRepository;
import com.decagon.OakLandv1be.repositries.PersonRepository;
import com.decagon.OakLandv1be.repositries.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class AdminDetailsService implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final SuperAdminRepository superAdminRepository;
    private final PasswordEncoder passwordEncoder;

    Admin admin = new Admin();

    private final AdminRepository adminRepository;

    private final PersonRepository personRepository;

    @Value("${admin.super.email}")
    private String adminEmail;
    @Value("${admin.currency}")
    private String currency;
    String password = UUID.randomUUID().toString();

    public void initAdmin() {

        Person person = Person.builder()
                .date_of_birth(new Date().toString())
                .email(adminEmail)
                .firstName("super")
                .lastName("Admin")
                .role(Role.ADMIN)
                .gender(Gender.OTHER)
                .isActive(true)
                .password(passwordEncoder.encode(password))
                .verificationStatus(true)
                .build();

        Wallet wallet = Wallet.builder()
                .accountBalance(BigDecimal.ZERO)
                .baseCurrency(BaseCurrency.valueOf(currency))
                .build();
        SuperAdmin superAdmin = SuperAdmin.builder()
                .person(person)
                .wallet(wallet)
                .build();

        SuperAdmin superAdminDB = superAdminRepository.save(superAdmin);
        log.info("#############################################################################");
        log.info("Super Admin Details");

        log.info("Username/Email: \t" + password);
        log.info("Password/Passphrase: \t" + adminEmail);

        log.info("*******************   Wallet Information   *****************");
        log.info(superAdminDB.getWallet().toString());

        log.info("#############################################################################");

    }

    @Override
    public void run(String... args) throws Exception {
        initAdmin();
    }
}

