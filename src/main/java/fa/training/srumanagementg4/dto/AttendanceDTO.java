package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.enums.TypeAttendance;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceDTO {
    private Long id;
    private TypeAttendance type;
    private LocalDate createdDate;
    private LocalTime createTime;
    private LocalTime endTime;
    private String note;
    private Users users;
    private String dayInMonth;

    public AttendanceDTO() {
    }

    public AttendanceDTO(Long id, TypeAttendance type, LocalDate createdDate, LocalTime createTime, LocalTime endTime, String note, Users users) {
        this.id = id;
        this.type = type;
        this.createdDate = createdDate;
        this.note = note;
        this.users = users;
        this.createTime = createTime;
        this.endTime = endTime;
    }

    public AttendanceDTO(Long id, TypeAttendance type, LocalDate createdDate, LocalTime createTime, LocalTime endTime, String note) {
        this.id = id;
        this.type = type;
        this.createdDate = createdDate;
        this.note = note;
        this.createTime = createTime;
        this.endTime = endTime;
    }

    public AttendanceDTO(Long id, LocalTime createTime, LocalTime endTime) {
        this.id = id;
        this.createTime = createTime;
        this.endTime = endTime;
        this.note = note;
    }

    public AttendanceDTO(TypeAttendance type, LocalDate createdDate, LocalTime createTime, LocalTime endTime, String note, Users users) {
        this.type = type;
        this.createdDate = createdDate;
        this.note = note;
        this.users = users;
        this.createTime = createTime;
        this.endTime = endTime;
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

    public String getDayInMonth() {
        return String.valueOf(createdDate.getDayOfMonth());
    }

    public void setDayInMonth(String dayInMonth) {
        this.dayInMonth = dayInMonth;
    }
}
