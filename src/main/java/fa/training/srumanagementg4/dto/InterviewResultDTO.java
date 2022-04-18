package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterviewResultDTO {
    private Long id;
    @NotNull(message = "Level not be null")
    @Min(value = 0, message = "Level must not be less than 0")
    @Max(value = 5, message = "Level must not be more than than 5")
    private int level;
    @NotNull(message = "Commet is required")
    private String comment;
    private Date dateInterview;
    private Trainer trainer;
    private Trainee trainee;
    private TrainingObjective trainingObjective;

    public InterviewResultDTO() {
    }

    public InterviewResultDTO( int level, Trainer trainer, Trainee trainee, TrainingObjective trainingObjective) {
        this.level = level;
        this.trainer = trainer;
        this.trainee = trainee;
        this.trainingObjective = trainingObjective;
    }

    public InterviewResultDTO(Long id, int level, String comment, Date interviewDate, Trainer trainer, Trainee trainee, TrainingObjective trainingObjective) {
        this.id = id;
        this.level = level;
        this.comment = comment;
        this.dateInterview = interviewDate;
        this.trainer = trainer;
        this.trainee = trainee;
        this.trainingObjective = trainingObjective;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public TrainingObjective getTrainingObjective() {
        return trainingObjective;
    }

    public void setTrainingObjective(TrainingObjective trainingObjective) {
        this.trainingObjective = trainingObjective;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateInterview() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateInterview);
    }

    public void setDateInterview(Date dateInterview) {
        this.dateInterview = dateInterview;
    }

    @Override
    public String toString() {
        return "InterviewResultDTO{" +
                "id=" + id +
                ", level=" + level +
                ", trainer=" + trainer +
                ", trainee=" + trainee +
                ", trainingObjective=" + trainingObjective +
                '}';
    }
}
