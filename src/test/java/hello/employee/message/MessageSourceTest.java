package hello.employee.message;

import hello.employee.exception.CommonException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static hello.employee.exception.ExceptionType.UNKNOWN;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        assertThat(ms.getMessage("hello",null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello",null, Locale.KOREA)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello",null, Locale.ENGLISH)).isEqualTo("hello");
    }

    @Test
    void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, Locale.ENGLISH);
        assertThat(message).isEqualTo("hello Spring");
    }

    @Test
    void notFoundMessageCode() {
        String result = ms.getMessage("no_code", null,"기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지");
    }

    @Test
    void errorMessage() {
        assertThat(getMessage("UNKNOWN", Locale.KOREA)).isEqualTo("알 수 없는 오류가 발생했습니다");
        assertThat(getMessage("UNKNOWN", Locale.ENGLISH)).isEqualTo("unknown error occurred");
    }

    @Test
    void error_v1() {
        throw new CommonException(UNKNOWN, getMessage(UNKNOWN.getMessage(), Locale.KOREA), new Throwable());
    }

    @Test
    void error_v2() {
        throw CommonException.of(UNKNOWN, getMessage(UNKNOWN.getMessage(), Locale.ENGLISH));
    }

    private String getMessage(String message, Locale locale) {
        return ms.getMessage(message,null, locale);
    }
}

