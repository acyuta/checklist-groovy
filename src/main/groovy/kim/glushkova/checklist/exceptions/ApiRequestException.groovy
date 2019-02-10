package kim.glushkova.checklist.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 *
 */
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
class ApiRequestException extends RuntimeException {
    ApiRequestException(String message) {
        super(message)
    }
}
