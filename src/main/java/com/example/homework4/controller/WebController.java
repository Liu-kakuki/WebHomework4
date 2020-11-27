package com.example.homework4.controller;

import com.example.homework4.data.AddData;
import com.example.homework4.data.LoginData;
import com.example.homework4.data.TableData;
import com.example.homework4.model.CheckLogin;
import com.example.homework4.model.TableAlters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(LoginData login, Model model, HttpServletRequest request) {
        model.addAttribute("login", login);
        if (CheckLogin.Check(login)) {
            request.getSession().setAttribute("login", "ok");
            return "redirect:/format";
        }
        else
            return "login";
    }

    @GetMapping("/format")
    public String showFormat(HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if (flag != null) {
            HttpSession session = request.getSession();
            if (session.getAttribute("table") == null) {
                TableData table = new TableData();
                session.setAttribute("table", table);
            }
            return "format";
        } else
            return "redirect:/login";
    }

    @RequestMapping("/add")
    public String add(AddData add, Model model) {
        model.addAttribute("add", add);
        return "add";
    }

    @PostMapping("/alter")
    public String showAlter(HttpServletRequest request, @ModelAttribute(value = "row") Integer row, LoginData m, Model model) {
        TableData t = (TableData) request.getSession().getAttribute("table");
        AddData info = t.getTabledata().elementAt(row);
        model.addAttribute("add", info);
        return "alter";
    }

    // 直接访问修改联系人 --- 直接弹回去
    @GetMapping("/alter")
    public String redirectAlter() {
        return "redirect:/format";
    }

    // 直接访问判断联系人修改 直接重定向回去
    @GetMapping("/checkalter")
    public String redirectCheckAlter() {
        return "redirect:/format";
    }

    // 修改联系人信息 （因为名字不能修改 所以一定可以修改成功）
    @PostMapping("/checkalter")
    public String checkAlter(AddData add, HttpServletRequest request) {
        TableData t = (TableData) request.getSession().getAttribute("table");
        TableAlters.alterElem(t, add);
        return "redirect:/format";
    }

    // 删除联系人，不需要返回view 直接使用model 进行处理 如果是直接请求，必然是逻辑错误 直接跳转回去
    @GetMapping("/del")
    public String redirectDel() {
        return "redirect:/format";
    }

    // 删除联系人
    @PostMapping("del")    // ModelAttribute 可以理解成随请求一起发过来的参数Param
    public String DeleteContact(@ModelAttribute(value = "row") Integer row, HttpServletRequest request) {
        TableData t = (TableData) request.getSession().getAttribute("table");
        TableAlters.deleteElem(t, row);
        return "redirect:/format";
    }

    // 处理添加的URL 如果不是通过post请求的说明是手动请求的，将跳转回去，否则进行处理
    @GetMapping("/checkadd")
    public String redirectAdd() {
        return "add";
    }

    // 处理添加的URL 如果是通过POST提交的，则进行处理
    @PostMapping("/checkadd")
    public String checkAdd(AddData add, HttpServletRequest request, Model model) {
        TableData t = (TableData) request.getSession().getAttribute("table");
        boolean is_valid = TableAlters.checkValidAdd(t, add);
        if (true == is_valid) {
            t.getTabledata().addElement(add);
            return "redirect:/format";
        } else {
            add.setUsername("");
            return add(add, model);
        }
    }

}
