const form = document.getElementById('form');
const username = document.getElementById('username');
const tel = document.getElementById('tel');
const email = document.getElementById('email');
const address = document.getElementById('address');
const qq = document.getElementById('qq');

form.addEventListener('submit', e => {
    if (checkAllInputs() == false) {
        e.preventDefault();
    }
});

function checkAllInputs() {
    const usernameValue = username.value.trim();
    const telValue = tel.value.trim();
    const emailValue = email.value.trim();
    const addressValue = address.value.trim();
    const qqValue = qq.value.trim();

    if (usernameValue === '') {
        setErrorFor(username, '用户名不能为空');
        return false;
    } else {
        setSuccessFor(username);
    }

    if (telValue === '') {
        setErrorFor(tel, '电话不能为空');
        return false;
    } else {
        setSuccessFor(tel);
    }

    if (emailValue === '') {
        setErrorFor(email, '邮箱不能为空');
        return false;
    } else if (!isEmail(emailValue)) {
        setErrorFor(email, '邮箱格式不正常');
        return false;
    } else {
        setSuccessFor(email);
    }

    if (addressValue === '') {
        setErrorFor(address, '地址不能为空');
        return false;
    } else {
        setSuccessFor(address);
    }

    if (qqValue === '') {
        setErrorFor(qq, 'qq号不能为空');
        return false;
    } else {
        setSuccessFor(qq);
    }
    return true;
}

function checkInputs(id) {
    const input = document.getElementById(id)
    const tempValue = input.value.trim();

    if (id == "username") {
        if (tempValue === '') {
            setErrorFor(input, '用户名不能为空');
        } else {
            setSuccessFor(input);
        }
    }
    if (id == "tel") {
        if (tempValue === '') {
            setErrorFor(input, '电话不能为空');
        } else {
            setSuccessFor(input);
        }
    }
    if (id == "email") {
        if (tempValue === '') {
            setErrorFor(input, '邮箱不能为空');
        } else if (!isEmail(tempValue)) {
            setErrorFor(input, '邮箱格式不正常');
        } else {
            setSuccessFor(input);
        }
    }
    if (id == "address") {
        if (tempValue === '') {
            setErrorFor(input, '地址不能为空');
        } else {
            setSuccessFor(input);
        }
    }
    if (id == "qq") {
        if (tempValue === '') {
            setErrorFor(input, 'qq号不能为空');
        } else {
            setSuccessFor(input);
        }
    }
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-control error';
    small.innerText = message;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}