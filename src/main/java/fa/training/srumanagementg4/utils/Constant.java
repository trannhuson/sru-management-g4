package fa.training.srumanagementg4.utils;

import java.util.Random;

public class Constant {

    public static final String CREATE_CLASS_FAIL = "Create class fail!";
    public static final String CREATE_CLASS_SUCCESS = "Create class successfully!";
    public static final String UPDATE_CLASS_SUCCESS = "Update class successfully!";
    public static final String DELETE_CLASS_SUCCESS = "Class deleted successfully!";
    public static final String CREATE_ISSUE_FAIL = "Create issue fail!";
    public static final String CREATE_ISSUE_SUCCESS = "Create issue successfully!";
    public static final String DELETE_ISSUE_SUCCESS = "Delete issue successfully!";
    public static final String CREATE_SOLUTION_FAIL = "Create solution fail!";
    public static final String CREATE_SOLUTION_SUCCESS = "Create solution success!";
    public static final String UPDATE_SOLUTION_SUCCESS = "Update solution success!";
    public static final String DELETE_SOLUTION_SUCCESS = "Delete solution success!";
    public static final String CREATE_SCORE_SUCCESS = "Create score success!";
    public static final String UPDATE_SCORE_SUCCESS = "Update score success!";
    public static final String ADD_TRAINEE_TO_CLASS_SUCCESS = "Add trainee success!";
    public static final String REMOVE_TRAINEE_FROM_CLASS = "Remove trainee success!";
    public static final String CREATE_SUBJECT_SUCCESS = "Create training objective success";
    public static final String DELETE_SUBJECT_SUCCESS = "Delete training objective success";
    public static final String UPDATE_SUBJECT_SUCCESS = "Updatetraining objective success";
    public static final String VALID_PLAN_COUNT_REGEX = "^[0-9]*$";
    public static final String VALID_RATE = "^[1-5]$";
    public static final String ADD_TRAINEE_SUCCESS = "Create trainee success";
    public static final String ADD_TRAINEE_FAIL = "Create trainee fail";
    public static final String CREATE_INTERVIEW_SUCCESS = "Create interview success";
    public static final String UPDATE_INTERVIEW_SUCCESS = "Update interview success";
    public static final String UPDATE_TRAINEE_SUCCESS = "Update trainee success";
    public static final String DELETE_TRAINEE_SUCCESS = "Delete trainee success";
    public static final String CREATE_MISTAKE_SUCCESS = "Create mistake success";
    public static final String UPDATE_MISTAKE_SUCCESS = "Update mistake success";
    public static final String DELETE_MISTAKE_SUCCESS = "Delete mistake success";
    public static final String UPDATE_TRAINEE_FAIL = "Update trainee fail";
    public static final String ACCOUNT_EXISTS = "Account or email is existed";
    public static final String CREATE_FEEDBACK_FAIL = "Create feedback fail!";
    public static final String CREATE_FEEDBACK_SUCCESS = "Create feedback successfully!";
    public static final String ROOT_UPLOAD_FILE="\\src\\main\\webapp\\resources\\upload\\image\\";
    public static final String FIND_COMMENT_BY_TRAINEE = "SELECT c FROM Comment c WHERE c.trainee.id = ?1 ORDER BY c.id DESC";
    public static final String FIND_ALL_USER_BY_ACCOUNT_OR_EMAIL = "SELECT t FROM Users  t WHERE t.account = ?1 OR t.email = ?2";
    public static final String NAME_CLASS_EXIST = "Class name already exists!";
    public static final String NAME_YEAR_REGEX = "\\w+\\(\\d{4,}\\)";
    public static final String REGEX_ID = "\\d+";

    public static final String TIME_STANDARD = "08:30";
    public static final String TIME_OUT_STANDARD = "17:30";
    public static final String MY_EMAIL = "son.trannhu.dev@gmail.com";
    public static final String MY_PASSWORD = "Son0962548471";
    public static final String CHANGE_PASSWORD_SUCCESS = "<h1>Your password has just been changed, please check your login information again!</h1>";
    public static final String EMAIL_NOT_EXIST = "Email does not exist!";
    public static final String LOGIN_FAIL = "Incorrect account or password!";
    public static final String LOGIN_GOOGLE_FAIL = "The email does not exist in the system!";
    public static String MESSAGE_LOGIN = "";
    public static String issueId = "";
    public static String classId = "";
    public static String ACCESS_TOKEN = "";
    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
