package com.example.study.global.common;

import com.example.study.global.error.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("요청이 성공적으로 처리되었습니다.", data);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>("요청이 성공적으로 처리되었습니다.", null);
    }

    // GlobalExceptionHandler에서 ApiResponse<Void>로 명시되어 있으니  ApiResponse<Void> 반환
    public static ApiResponse<Void> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getMessage(), null);
    }
}
