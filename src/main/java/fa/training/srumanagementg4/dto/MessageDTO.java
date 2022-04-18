package fa.training.srumanagementg4.dto;

public class MessageDTO {
    private String code;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
