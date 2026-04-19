package com.example.study.global.common;

import com.example.study.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("요청이 성공적으로 처리되었습니다.", data);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>("요청이 성공적으로 처리되었습니다.", null);
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getMessage(), null);
    }


}
