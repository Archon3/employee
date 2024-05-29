package hello.employee.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hello.employee.constant.CommonConstant;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerResponse<T> implements CommonResponse {

    @JsonIgnore
    private String errMsg;

    @Builder.Default
    private int code = CommonConstant.SUCCESS_CODE;
    private T content;

    public static <T> ServerResponse<T> of(final @NotNull T content) {
        return (ServerResponse<T>) ServerResponse.builder().content(content).build();
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        if (CommonConstant.SUCCESS_CODE != this.code
                && StringUtils.isNotBlank(this.errMsg)) {
            return "[" + this.code + "] " + this.errMsg;
        }
        return null;
    }

    @Override
    public T getContent() {
        return content;
    }
}
