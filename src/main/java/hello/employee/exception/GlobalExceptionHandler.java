package hello.employee.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> handle(CommonException e, Locale locale) {
        ExceptionType type = e.getType();
        log.error("handleCommonException throw CommonException : {}", type.toString());

        CommonExceptionResponse response = CommonExceptionResponse.builder()
                .status(type.getHttpStatus().value())
                .error(type.getHttpStatus().name())
                .code(type.name())
                .message(messageSource.getMessage(type.getMessage(), null, locale))
                .build();

        return ResponseEntity
                .status(type.getHttpStatus())
                .body(response);
    }
}
