package fa.training.srumanagementg4.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "User must have a valid account role")
public class MissingUserRoleException extends RestClientException {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MissingUserRoleException(Long userId, String entity)  {
        super(String.format("User does not have a valid account role.", userId));
        logger.error("User does not have a valid account role.", userId);
        logger.error("GG_ERROR_MISSINGUSERROLE {}", entity);
    }
}
