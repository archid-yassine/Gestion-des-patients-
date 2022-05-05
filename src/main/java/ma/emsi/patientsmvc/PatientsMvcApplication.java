package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import ma.emsi.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "hassan", new Date(), false, 145));
            patientRepository.save(new Patient(null, "Mohamed", new Date(), true, 115));
            patientRepository.save(new Patient(null, "yassmine", new Date(), true, 155));
            patientRepository.save(new Patient(null, "hanae", new Date(), false, 177));

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }

   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("mohamed", "1234", "1234");
            securityService.saveNewUser("yassine", "1234", "1234");
            securityService.saveNewUser("hassan", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("mohamed", "USER");
            securityService.addRoleToUser("mohamed", "ADMIN");
            securityService.addRoleToUser("yassine", "USER");
            securityService.addRoleToUser("hassan", "USER");

        };
    }
}