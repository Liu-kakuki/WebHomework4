package com.example.homework4.data;
import java.io.Serializable;

public class AddData implements Serializable {
    private String username;
    private String tel;
    private String email;
    private String addr;
    private String qq;


    public AddData(String username, String tel, String email, String addr, String qq) {
        this.username = username;
        this.tel = tel;
        this.email = email;
        this.addr = addr;
        this.qq = qq;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
