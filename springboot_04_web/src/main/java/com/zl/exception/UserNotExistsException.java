package com.zl.exception;

public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException() {
        super("用户不存在！");
    }
}
