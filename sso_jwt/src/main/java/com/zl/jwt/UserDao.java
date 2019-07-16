package com.zl.jwt;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    public static final Map<String, String> users = new HashMap();

    static {
        for (int i = 0; i < 10; i++) {
            users.put("admin" + i, "password" + i);
        }
    }

    // 是否可登录
    public static boolean isLogin(String username, String password) {
        if (null == username || username.trim().length() == 0) {
            return false;
        }
        String obj = users.get(username);
        if (null == obj || !obj.equals(password)) {
            return false;
        }
        return true;
    }

}
