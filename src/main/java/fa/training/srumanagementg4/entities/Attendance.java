package fa.training.srumanagementg4.entities;

import fa.training.srumanagementg4.enums.TypeAttendance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeAttendance type;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "create_time")
    private LocalTime createTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Users users;

    public Attendance() {
    }

    public Attendance(Long id, TypeAttendance type, LocalDate createdDate, String note, Users users) {
        this.id = id;
        this.type = type;
        this.createdDate = createdDate;
        this.note = note;
        this.users = users;
    }

    public Attendance(Long id, TypeAttendance type, LocalDate createdDate, LocalTime createTime, LocalTime endTime, String note, Users users) {
        this.id = id;
        this.type = type;
        this.createdDate = createdDate;
        this.createTime = createTime;
        this.endTime = endTime;
        this.note = note;
        this.users = users;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeAttendance getType() {
        return type;
    }

    public void setType(TypeAttendance type) {
        this.type = type;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
