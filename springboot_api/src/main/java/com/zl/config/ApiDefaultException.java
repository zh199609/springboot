package com.zl.config;

/**
 * @ClassName: ApiDefaultException
 * @Description: default
 * @Author: albertzh
 * @Create: 2019-10-16 15:12
 */
public class ApiDefaultException extends ApiException {
    public ApiDefaultException(String message) {
        super(null, message, null, null);
    }
}
