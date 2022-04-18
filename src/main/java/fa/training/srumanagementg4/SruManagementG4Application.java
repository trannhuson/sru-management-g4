package fa.training.srumanagementg4;
import fa.training.srumanagementg4.entities.Manager;
import fa.training.srumanagementg4.entities.Role;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.enums.Gender;
import fa.training.srumanagementg4.enums.RoleName;
import fa.training.srumanagementg4.repository.ManagerRepository;
import fa.training.srumanagementg4.repository.TrainerRepository;
import fa.training.srumanagementg4.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SruManagementG4Application extends SpringBootServletInitializer{

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(SruManagementG4Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SruManagementG4Application.class);
    }
    @PostConstruct
    public void insertData() {
//        //role
//        Role role1 = new Role(RoleName.ROLE_ADMIN);
//        Role role2 = new Role(RoleName.ROLE_TRAINEE);
//        Role role3 = new Role(RoleName.ROLE_TRAINER);
//        Role role4 = new Role(RoleName.ROLE_DIRECTION);
//        roleRepository.save(role1);
//        roleRepository.save(role2);
//        roleRepository.save(role3);
//        roleRepository.save(role4);
//
//        // manager
//        Manager manager = new Manager();
//        Set<Role> roles = new HashSet<>();
//        Optional<Role> adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
//        roles.add(adminRole.get());
//        manager.setAccount("AnhLV");
//        manager.setPassword(encoder.encode("abc"));
//        manager.setEmail("anhvl@gmail.com");
//        manager.setFacebook("Anh Van");
//        manager.setFullName("Anh Van");
//        manager.setGender(Gender.Male);
//        manager.setRoles(roles);
//        manager.setPhoneNumber("0123456789");
//        managerRepository.save(manager);
//
//        // trainer
//        Trainer trainer = new Trainer();
//        Set<Role> roleList = new HashSet<>();
//        Optional<Role> role = roleRepository.findByName(RoleName.ROLE_TRAINER);
//        roleList.add(role.get());
//        System.out.println("ROLEEEEEEEEEEEEE: " + role.get().getName());
//        trainer.setAccount("KhoeHD");
//        trainer.setPassword(encoder.encode("abc"));
//        trainer.setEmail("khoe@gmail.com");
//        trainer.setFacebook("Ha Dinh Khoe");
//        trainer.setFullName("Ha Dinh Khoe");
//        trainer.setGender(Gender.Male);
//        trainer.setRoles(roleList);
//        trainer.setPhoneNumber("0123456788");
//        trainerRepository.save(trainer);
//
//
//        Trainer trainer2 = new Trainer();
//        trainer2.setAccount("HoaBT2");
//        trainer2.setPassword(encoder.encode("abc"));
//        trainer2.setEmail("hoa@gmail.com");
//        trainer2.setFacebook("Bui Thanh Hoa");
//        trainer2.setFullName("Bui Thanh Hoa");
//        trainer2.setGender(Gender.Male);
//        trainer2.setRoles(roleList);
//        trainer2.setPhoneNumber("01234567899");
//        trainerRepository.save(trainer2);
    }
}
