package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Solution;
import org.hibernate.validator.constraints.NotBlank;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class IssueDTO {

    private Long id;
    @NotBlank
    private String name;
    private String createdDate;
    private Class classIssue;
    private Set<Solution> solutions;
    private String size;
    public IssueDTO() {
    }

    public IssueDTO(Long id, String name, String createdDate, Class classIssue) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.classIssue = classIssue;
    }

    public IssueDTO(String name, String createdDate, Class classIssue) {
        this.name = name;
        this.createdDate = createdDate;
        this.classIssue = classIssue;
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

    public String getSize() {
        return String.valueOf(solutions.size() + 1);
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreatedDate() {
       return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Class getClassIssue() {
        return classIssue;
    }

    public void setClassIssue(Class classIssue) {
        this.classIssue = classIssue;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(Set<Solution> solutions) {
        this.solutions = solutions;
    }

    @Override
    public String toString() {
        return "IssueDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", classIssue=" + classIssue +
                '}';
    }
}
