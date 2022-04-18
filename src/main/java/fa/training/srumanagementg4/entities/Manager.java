package fa.training.srumanagementg4.entities;

import fa.training.srumanagementg4.enums.Gender;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manager")
public class Manager extends Users {

    public Manager() {

    }

    public Manager(Long id, String account, String password, String fullName, Gender gender, String email, String phoneNumber, String facebook, Set<Attendance> attendances, Set<Role> roles) {
        super(id, account, password, fullName, gender, email, phoneNumber, facebook, attendances, roles);
    }

}
