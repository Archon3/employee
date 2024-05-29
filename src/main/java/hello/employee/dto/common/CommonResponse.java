package hello.employee.dto.common;

import hello.employee.constant.CommonConstant;

public interface CommonResponse<T> {

    default int getCode() {
        return CommonConstant.SUCCESS_CODE;
    }

    default String getMessage() {
        return CommonConstant.SUCCESS_MESSAGE;
    }

    T getContent();
}
