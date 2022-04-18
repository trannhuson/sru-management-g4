package fa.training.srumanagementg4.dto;

public class MonthAndYearDTO {
    private long month;
    private long year;

    public MonthAndYearDTO() {
    }

    public MonthAndYearDTO(long month, long year) {
        this.month = month;
        this.year = year;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
