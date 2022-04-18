package fa.training.srumanagementg4.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserDoesNotExistException extends RestClientException {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserDoesNotExistException(String message) {
        super(String.format("User email does not exist. %s", message));
        logger.error("Unable to to find user with email: {}", message);
    }
}