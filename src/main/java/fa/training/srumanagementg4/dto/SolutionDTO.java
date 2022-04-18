package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.Issue;
import org.hibernate.validator.constraints.NotBlank;

public class SolutionDTO {

    private Long id;
    @NotBlank
    private String nameSolution;
    private Issue issue;
    private String idIssue;

    private String createdDate;

    public SolutionDTO() {
    }

    public SolutionDTO(Long id, String nameSolution, Issue issue) {
        this.id = id;
        this.nameSolution = nameSolution;
        this.issue = issue;
    }

    public SolutionDTO(String nameSolution, Issue issue, String createdDate) {
        this.nameSolution = nameSolution;
        this.issue = issue;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSolution() {
        return nameSolution;
    }

    public void setNameSolution(String nameSolution) {
        this.nameSolution = nameSolution;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getIdIssue() {
        return idIssue;
    }

    public void setIdIssue(String idIssue) {
        this.idIssue = idIssue;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
