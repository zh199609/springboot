package com.zl.controller;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: User
 * @Description:
 * @Author: albertzh
 * @Create: 2019-11-18 21:31
 */
public class User {
    private String userName;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", file=" + file.getSize() +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
