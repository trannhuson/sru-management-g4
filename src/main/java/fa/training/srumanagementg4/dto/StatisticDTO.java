package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.enums.StatusEnum;

public class StatisticDTO {
    private StatusEnum name;
    private Long amount;

    public StatisticDTO() {
    }

    public StatisticDTO(StatusEnum name, Long amount) {
        this.name = name;
        this.amount = amount;
    }

    public StatusEnum getName() {
        return name;
    }

    public void setName(StatusEnum name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
