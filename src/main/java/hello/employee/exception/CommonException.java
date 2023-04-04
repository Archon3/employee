package hello.employee.exception;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.ArrayUtils;

import static java.util.Objects.requireNonNull;

@Getter
@ToString
public class CommonException extends RuntimeException {
    private final ExceptionType type;
    private final Object body;
    private Object[] messageArgs;

    public CommonException(final ExceptionType type,
                           final String message,
                           final Object body,
                           final Throwable cause) {
        this.type = requireNonNull(type);
        this.body = null != body ? body : message;

        initCause(cause);
    }

    public CommonException(final ExceptionType type,
                           final String message,
                           final Throwable cause) {
        this.type = requireNonNull(type);
        this.body = message;

        initCause(cause);
    }

    public CommonException(final ExceptionType type,
                           final String message,
                           final Object[] messageArgs) {
        this.type = requireNonNull(type);
        this.body = message;
        this.messageArgs = messageArgs;
    }

    public static CommonException of(final ExceptionType type) {
        return new CommonException(type, null, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    public static CommonException of(final ExceptionType type,
                                     final Throwable cause) {
        return new CommonException(type, null, cause);
    }

    public static CommonException of(final ExceptionType type,
                                     final Object body,
                                     final Throwable cause) {
        return new CommonException(type, null, body, cause);
    }

    public static CommonException of(final ExceptionType type,
                                     final Object[] messageArgs) {
        return new CommonException(type, null, messageArgs);
    }

    public static CommonException of(final ExceptionType type,
                                     final String message) {
        return new CommonException(type, message, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

}
