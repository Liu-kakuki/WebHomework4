function login() {
    const name = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    if (name == 'kakuki' && password == '12345678') {
        alert('用户名和密码正确，登录成功！');
        return true;
    } else {
        alert('用户名或密码错误，登录失败！');
        return false;
    }
}