package com.example.warszterp.setup;

import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.Authorities;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.AuthoritiesRepository;
import com.example.warszterp.model.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestDataCreator implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;


    public TestDataCreator(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createTestUsers();
    }

    private void createTestUsers() {

        createTestUser("client@client.eu", "client0", "pass", "Ivy", "Walker", true, "545545545", "Kliencka", "44", "Warszawa", "01-401", "ROLE_CLIENT");
        createTestUser("mechanic@mech.eu", "mechanic0", "pass", "Lucius", "Hunt", true, "658658658", "Warsztatowa", "11", "Kraków", "33-401", "ROLE_EMPLOYEE" );
        createTestUser("admin@ad.eu", "admin0", "pass", "Noah", "Percy", true, "987654321", "Adminska", "22", "Wrocław", "51-401", "ROLE_ADMIN");

    }

    private void createTestUser(
            String email,
            String username,
            String password,
            String firstName,
            String surname,
            boolean enabled,
            String phoneNumber,
            String street,
            String houseNumber,
            String city,
            String postCode,
            String role) {

        userRepository.findByUsername(username).ifPresentOrElse(
                user -> log.debug("użytkownik istnieje już w bazie"),
                () -> {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(passwordEncoder.encode(password));
                    user.setEmail(email);
                    user.setFirstName(firstName);
                    user.setSurname(surname);
                    user.setEnabled(enabled);
                    user.setPhoneNumber(phoneNumber);
                    Address address = new Address();
                    address.setStreet(street);
                    address.setPostCode(postCode);
                    address.setHouseNumber(houseNumber);
                    address.setCity(city);
                    user.setAddress(address);
                    userRepository.save(user);

                    Authorities auth = new Authorities();
                    auth.setAuthority(role);
                    auth.setUsername(username);
                    authoritiesRepository.save(auth);
                    log.debug("User " + username + " saved");
                });
    }
}
