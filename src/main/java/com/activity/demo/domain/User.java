package com.activity.demo.domain;

public class User {
    private long id;
    private  String userId;
    private  String userName;
    private  String passWord;
    private  String phone;
    private  String email;
    private  String address;
    /**
     * 盐 加密密码用
     */

    private String salt;
    public User(){

    }

    public User(long id, String userId, String userName, String passWord, String phone, String email, String address,String salt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.salt = salt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
