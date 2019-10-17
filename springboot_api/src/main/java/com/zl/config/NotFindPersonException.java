package com.zl.config;

/**
 * @ClassName: NotFindPersonException
 * @Description: 未找到person异常
 * @Author: albertzh
 * @Create: 2019-10-17 10:14
 */
public class NotFindPersonException extends RuntimeException {

    public NotFindPersonException() {
        super("找不到此用户");
    }

    public NotFindPersonException(String message) {
        super(message);
    }
}
