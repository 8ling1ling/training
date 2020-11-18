//点击登录按钮
function gotoLogin(){
    DATA.nextPage="login"
    forward()
}
//跳到手势密码
function gotoGesture(){
    DATA.nextPage="gesture"
    forward()
}
//跳到设置手势密码
function lossAccount(){

    DATA.nextPage="lossAccount"
    forward()
}


countdown3 = $('CountdownButton3');
//验证码点击事件
countdown3.addEventListener('click', function () {
    log("===============================================================click1");

    let code = "";
    for (let i = 1; i <= 6; i++) {
            let num = Math.floor(Math.random() * 10);
            code += num;
}
log(code+"nnnnnnnnnnnn")
DATA.code=code;
vm.setData();
});





