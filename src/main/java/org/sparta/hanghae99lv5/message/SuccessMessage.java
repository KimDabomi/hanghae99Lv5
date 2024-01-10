package org.sparta.hanghae99lv5.message;

public enum SuccessMessage {
    JOIN_SUCCESS_MESSAGE("회원가입이 완료되었습니다."),
    LOGIN_SUCCESS_MESSAGE("로그인이 완료되었습니다."),
    CREATE_GOODS_SUCCESS_MESSAGE("상품 등록이 완료되었습니다."),
    INSERT_CART_SUCCESS_MESSAGE("상품이 장바구니에 추가되었습니다."),
    UPDATE_CART_SUCCESS_MESSAGE("장바구니가 수정되었습니다."),
    DELETE_CART_ITEM_SUCCESS_MESSAGE("장바구니에서 해당 상품이 삭제되었습니다.");

    private final String successMessage;

    SuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return "[SUCCESS] " + successMessage;
    }
}