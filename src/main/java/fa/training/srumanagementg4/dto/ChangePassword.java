package fa.training.srumanagementg4.dto;

public class ChangePassword {

    private String passwordOld;
    private String passwordNew;
    private String rePasswordNew;

    public ChangePassword() {
    }

    public ChangePassword(String passwordOld, String passwordNew, String rePasswordNew) {
        this.passwordOld = passwordOld;
        this.passwordNew = passwordNew;
        this.rePasswordNew = rePasswordNew;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getRePasswordNew() {
        return rePasswordNew;
    }

    public void setRePasswordNew(String rePasswordNew) {
        this.rePasswordNew = rePasswordNew;
    }
}
