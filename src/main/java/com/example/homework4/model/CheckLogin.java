package com.example.homework4.model;

import com.example.homework4.data.LoginData;

public class CheckLogin {
    public static boolean Check(LoginData login) {
        if ("kakuki".equals(login.getUsername()) && "12345678".equals(login.getPassword()))
            return true;
        else
            return false;
    }
}