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

function drawMoney1(){
    
}

function drawMoney() {
    let password1 = DATA.password;
    let password2 = DATA.password2;

   
    if(password1==""){
        Window.info("密码不能为空")
    }
    if(password2==""){
        Window.info("密码不能为空")
    }

    if(password1!=password2){
        Window.info("密码不一致")
    }
    let phone=DATA.pubData2
    vm.setData();
    var url = "demo/judgepassword.tml?flow=judgepassword";
    var params = {};
    // 根据手机号码获得用户密码
    params.phone = phone;
    var index = "1";
    sendRequest(url, params, index, onSuccess, onfailed);
}
function onSuccess(dic, index) {
    let password1 = DATA.password;
    if (dic!=password1) {
        Window.info("密码错误");
        return false;
    }
    if (dic== password1) {
        Window.info("输入成功")
        DATA.nextPage="drawMoney"
        forward()
    }
}


function onfailed(dic, index) {

    if (dic.retCode == 59996) {
        log("验证码错误")
        Window.info(dic.message);
        return false;
    }
}