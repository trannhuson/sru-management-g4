package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.TrainingObjective;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ScoreDTO {
    private Long id;
    private Trainee trainee;
    private TrainingObjective trainingObjective;
    private String name;
    @NotNull(message = "Value point is required")
    private float value;

    public ScoreDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public ScoreDTO(Long id, Trainee trainee, TrainingObjective trainingObjective, String name, Float value) {
        this.id = id;
        this.trainee = trainee;
        this.trainingObjective = trainingObjective;
        this.name = name;
        this.value = value;
    }
}
