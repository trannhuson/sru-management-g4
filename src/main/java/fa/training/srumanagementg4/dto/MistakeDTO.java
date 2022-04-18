package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Trainee;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MistakeDTO {
    private Long id;
    @NotNull
    private String name;
    private String description;
    private String noteMistake;
    private Trainee trainee;
    private Date createdDate;

    public MistakeDTO() {
    }

    public MistakeDTO(Long id, String name, String description, String note, Trainee trainee, Date createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.noteMistake = note;
        this.trainee = trainee;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoteMistake() {
        return noteMistake;
    }

    public void setNoteMistake(String note) {
        this.noteMistake = note;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public String getCreatedDate() {
        return  new SimpleDateFormat("yyyy-MM-dd").format(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
