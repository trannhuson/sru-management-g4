package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TrainingObjectiveDTO{
    private Long id;
    private String name;
    private String code;
    private Trainer trainer;
    private Class classClass;
    private Long classId;
    private Class aClass;

    public TrainingObjectiveDTO() {
    }

    public TrainingObjectiveDTO(Long id, String name, String code, Trainer trainer, Class classClass) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.trainer = trainer;
        this.classClass = classClass;
    }

    public TrainingObjectiveDTO(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Class getClassClass() {
        return classClass;
    }

    public void setClassClass(Class classClass) {
        this.classClass = classClass;
    }


    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

}
