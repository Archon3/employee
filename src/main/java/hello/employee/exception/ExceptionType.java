package hello.employee.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ExceptionType {

    DATA_NOT_FOUND(200001, OK, "DATA_NOT_FOUND"),

    /* 400 BAD_REQUEST : 잘못된 요청 */
    UNKNOWN(400001, BAD_REQUEST, "UNKNOWN"),
    URI_NOT_FOUND(400002, BAD_REQUEST, "URI_NOT_FOUND"),
    URI_TOO_LONG(400003, BAD_REQUEST, "URI_TOO_LONG"),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */

    /* 403 FORBIDDEN : 콘텐츠에 접근할 권리를 가지고 있지 않음 */

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */

    /* 408 REQUEST_TIMEOUT */

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(409001, CONFLICT, "DUPLICATE_RESOURCE"),

    ;

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    ExceptionType(int errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
