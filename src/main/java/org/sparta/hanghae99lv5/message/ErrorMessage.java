package org.sparta.hanghae99lv5.message;

public enum ErrorMessage {
    EXIST_TOKEN_ERROR_MESSAGE("토큰을 찾을 수 없습니다."),
    EXIST_USER_ERROR_MESSAGE("존재하지 않는 사용자입니다."),
    EXIST_GOODS_ERROR_MESSAGE("존재하지 않는 상품입니다."),
    EXIST_CART_ERROR_MESSAGE("존재하지 않는 장바구니입니다."),
    EXIST_CART_ITEM_ERROR_MESSAGE("장바구니에 해당 상품이 존재하지 않습니다."),
    INVALID_JWT_ERROR_MESSAGE("Invalid JWT signature, 유효하지 않는 JWT 서명 입니다."),
    EXPIRED_JWT_ERROR_MESSAGE("Expired JWT token, 만료된 JWT token 입니다."),
    UNSUPPORTED_JWT_ERROR_MESSAGE("Unsupported JWT token, 지원되지 않는 JWT 토큰 입니다."),
    EMPTY_JWT_ERROR_MESSAGE("JWT claims is empty, 잘못된 JWT 토큰 입니다."),
    EMAIL_FORMAT_ERROR_MESSAGE("올바른 이메일 형식이 아닙니다."),
    PASSWORD_VALIDATION_ERROR_MESSAGE("비밀번호는 최소 8자 이상, 15자 이하이며 알파벳 대소문자, 숫자, 특수문자로 구성되어야 합니다."),
    PASSWORD_MISMATCH_ERROR_MESSAGE("로그인에 실패하였습니다."),
    AUTH_EXCEPTION_MESSAGE("관리자만 가능한 기능입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}

