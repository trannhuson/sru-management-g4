package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.utils.Constant;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author SonTN9
 *
 */
public class ClassDTO {

    private Long id;
    @NotBlank
    private String name;

    @NotBlank
    private String openDate;

    @Pattern(regexp = Constant.VALID_PLAN_COUNT_REGEX, message = "Plan count must be different from 0")
    private String planCount;

    private int currentCount;

    @NotBlank
    private String endDate;

    private String note;

    @NotBlank
    private String type;

    @NotBlank
    private String status;
    private Set<TrainingObjective> trainingObjectives;
    private Set<Trainee> trainees;
    private String trainer;
    private Set<String> trainerName;

    public ClassDTO() {
    }

    public ClassDTO(Long id, String name, String planCount) {
        this.id = id;
        this.name = name;
        this.planCount = planCount;
    }

    public ClassDTO(Long id, String name, String openDate, String planCount, int currentCount, String endDate, String note,
                    String type, String status, Set<TrainingObjective> trainingObjectives) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.planCount = planCount;
        this.currentCount = currentCount;
        this.endDate = endDate;
        this.note = note;
        this.type = type;
        this.status = status;
        this.trainingObjectives = trainingObjectives;
    }

    public ClassDTO(Long id, String name, String planCount, int currentCount, String note, String type, String status) {
        this.id = id;
        this.name = name;
        this.planCount = planCount;
        this.currentCount = currentCount;
        this.note = note;
        this.type = type;
        this.status = status;
    }

    public ClassDTO(String name, String planCount, int currentCount, String note, String type, String status) {
        this.name = name;
        this.planCount = planCount;
        this.currentCount = currentCount;
        this.note = note;
        this.type = type;
        this.status = status;
    }

    public Set<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    public Set<TrainingObjective> getTrainingObjectives() {
        return trainingObjectives;
    }

    public void setTrainingObjectives(Set<TrainingObjective> trainingObjectives) {
        this.trainingObjectives = trainingObjectives;
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

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPlanCount() {
        return planCount;
    }

    public void setPlanCount(String planCount) {
        this.planCount = planCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrainer() {
        return getTrainerName().stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Set<String> getTrainerName() {
        return trainingObjectives.stream().map(x -> x.getTrainer().getFullName()).collect(Collectors.toSet());
    }

    public void setTrainerName(Set<String> trainerName) {
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", openDate='" + openDate + '\'' +
                ", planCount=" + planCount +
                ", currentCount=" + currentCount +
                ", endDate='" + endDate + '\'' +
                ", note='" + note + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
