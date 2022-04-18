package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainer;

public class ClassTrainerDTO {

    private Class aClass;

    private Trainer trainer;

    public ClassTrainerDTO(Class aClass, Trainer trainer) {
        this.aClass = aClass;
        this.trainer = trainer;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
