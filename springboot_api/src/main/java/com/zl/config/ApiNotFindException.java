package com.zl.config;


/**
 * @ClassName: ApiNotFindException
 * @Description:
 * @Author: albertzh
 * @Create: 2019-10-17 11:13
 */
public class ApiNotFindException extends ApiException {

    public ApiNotFindException(String message) {
        super(ApiHttpCode.NotFindErrorCode, message);
    }
}
