package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Score;
import fa.training.srumanagementg4.entities.Status;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.OptionalDouble;
import java.util.Set;

/**
 * @author HoangNV37
 */

public class TraineeDTO {

    private Long id;
    @NotNull(message = "Account is required ")
    private String account;
    @NotNull(message = "Email is required")
    private String email;
    private String password;
    private String facebook;
    @NotNull(message = "Full name is required")
    @Length(min = 8, max = 30, message = "Min 8 characters, max 30 characters")
    private String fullName;
    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[0]\\d{2}-?\\d{3}-?\\d{4}$", message = "Phone number must be start with 0 and 9 number")
    private String phoneNumber;
    @NotNull(message = "Factory is required")
    private String faculty;
    @NotNull(message = "Rec interview date department is required")
    private String recInterviewDate;
    @NotNull(message = "Rec interview status date department is required")
    private String recInterviewStatus;
    @NotNull(message = "Branch is required")
    private String branch;
    @NotNull(message = "Parent department is required")
    private String parentDepartment;
    @NotNull(message = "University is required")
    private String university;
    private String image;
    private Class classRoom;
    private Status status;
    private String note;
    private String gender;
    private Set<Score> scores;
    private String rank;
    private boolean active = true;

    public TraineeDTO(Long id, String account, String email, String facebook, String fullName, String phoneNumber, String faculty, String recInterviewDate, String recInterviewStatus, String branch, String parentDepartment, String university, Class classRoom) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.facebook = facebook;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.recInterviewDate = recInterviewDate;
        this.recInterviewStatus = recInterviewStatus;
        this.branch = branch;
        this.parentDepartment = parentDepartment;
        this.university = university;
        this.classRoom = classRoom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getRecInterviewDate() {
        return recInterviewDate;
    }

    public void setRecInterviewDate(String recInterviewDate) {
        this.recInterviewDate = recInterviewDate;
    }

    public String getRecInterviewStatus() {
        return recInterviewStatus;
    }

    public void setRecInterviewStatus(String recInterviewStatus) {
        this.recInterviewStatus = recInterviewStatus;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(String parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Class getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class classRoom) {
        this.classRoom = classRoom;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public String getRank() {
        String result = "";
        if(scores.isEmpty()){
            result = "None";
        }else{
            OptionalDouble avg = scores.stream().mapToDouble(Score::getValue).average();
                if (avg.getAsDouble() >= 9) {
                    result = "A+";
                } else if (avg.getAsDouble() >= 8) {
                    result = "A";
                } else if (avg.getAsDouble() >= 6.5) {
                    result = "B";
                } else if (avg.getAsDouble() >= 5) {
                    result = "C";
                } else {
                    result = "D";
                }
        }
        return result;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public TraineeDTO() {
    }

    public TraineeDTO(Long id, String account, String email, String facebook, String fullName, String phoneNumber, String factory, String recInterviewDate, String recInterviewStatus, String branch, String parentDepartment, String university, String image, Class clazz, Status status, String note) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.facebook = facebook;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.faculty = factory;
        this.recInterviewDate = recInterviewDate;
        this.recInterviewStatus = recInterviewStatus;
        this.branch = branch;
        this.parentDepartment = parentDepartment;
        this.university = university;
        this.image = image;
        this.classRoom = clazz;
        this.status = status;
        this.note = note;
    }

    @Override
    public String toString() {
        return "TraineeDTO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", factory='" + faculty + '\'' +
                ", recInterviewDate=" + recInterviewDate +
                ", recInterviewStatus='" + recInterviewStatus + '\'' +
                ", branch='" + branch + '\'' +
                ", parentDepartment='" + parentDepartment + '\'' +
                ", university='" + university + '\'' +
                ", image='" + image + '\'' +
                ", clazz=" + classRoom +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
