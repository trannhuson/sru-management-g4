package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.enums.Gender;

public class TrainerDTO {
    private Long id;

    private String account;

    private String password;

    private String fullName;

    private Gender gender;

    private String email;

    private String phoneNumber;

    private String facebook;
    private boolean active = true;
    public TrainerDTO(Long id, String account, String password, String fullName, Gender gender, String email, String phoneNumber, String facebook) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.facebook = facebook;
    }
    public TrainerDTO(Long id, String account, String password, String fullName, String email, String phoneNumber) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public TrainerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "TrainerDTO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
