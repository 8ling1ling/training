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
function lossAccount(){

    DATA.nextPage="login"
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





