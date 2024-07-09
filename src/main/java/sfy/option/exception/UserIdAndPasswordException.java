package sfy.option.exception;

public class UserIdAndPasswordException extends RuntimeException {
    public UserIdAndPasswordException(String mgs) {
        super(mgs);
    }

    public UserIdAndPasswordException() {
        super("계정 권한이 유효하지 않습니다.\n다시 로그인을 해주세요.");
    }
}
