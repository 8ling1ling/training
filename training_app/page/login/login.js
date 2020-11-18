
countdown3 = $('CountdownButton3');
//验证码点击事件
countdown3.addEventListener('click', function () {
      if(DATA.phone==""){
        Window.info("请先输入手机号码")
        countdown3.countdownButtonStart();
        return false;
    }
    var url = "demo/login.tml?flow=getCode";
    var params = {};
    var index = "1";
    sendRequest(url, params, index, CodeSuccess, onfailed);
 });
countdown3.addEventListener('stop', function () {
    log("================stop");
    alert("倒计时结束:");
});


//把从后台获取的值赋值给前段
function CodeSuccess(dic, index) {
    DATA.code=dic;
    vm.setData();
}
// 点击登录按钮之后的事件
function testRequest() {
    // 得到用户输入的手机号码
    let phone = DATA.phone;
    // DATA.pubData2=phone;
    //把用户输入的值放到全局作用域中
    DATA.pubData2=phone;
    // 得到用户输入的验证码
    let code = DATA.code;
    log("code=========="+code);
    log("code=========="+phone);
    vm.setData();
    if(phone==""){
        Window.info("请输入手机号")
        return false;
    }
    if(code==""){
        Window.info("请输入验证码")
        return false;
    }
    // 携带手机号码、验证码请求接口
    var url = "demo/login.tml?flow=login";
    var params = {};
    params.phone = phone;
    params.code = code;
    var index = "1";
    sendRequest(url, params, index, onSuccess, onfailed);
}

function login2() {
    DATA.nextPage = "login2";
    forward();
}

function login1() {
    DATA.nextPage = "login";
    forward();
}
function getpasscode() {

}

// ==

// function testRequest(){


//     let phone = DATA.phone;
    
//     var  url = "demo/setstate.tml?flow=setstate";
//     var params = {};
//     params.phone = phone;
//     var index ="1";
//     sendRequest(url,params,index, testonSuccess,testfailed);
// }


// function testonSuccess(dic,index){

//     log("success == "+ dic.retCode);
//     log("success == "+ dic.message);
//     if(dic.retCode==0){
//         Window.info("账户已挂失，请先解除挂失");
//         return false;
//     }


//     DATA.nextPage = "login";
//     forward();
// }
// function testfailed(dic,index){

// }
// ===
function register() {
    DATA.nextPage = "registered";
    forward();
}
//用户点击获取验证码之后，服务器传给前段的值
function getpasscode() {
    var url = "login.tml?flow=login";
    var params = {};
    params.id = "1";
    sendRequest(url, params, "1", onSuccess, onfailed);
}
function onSuccess(dic, index) {
    log("success == " + dic);
    log("success == " + JSON.stringify(dic));
 
    if (dic.retCode == 59996) {
        log("验证码错误")
        Window.info(dic.message);
        return false;
    }

    if (dic.retCode == 500102) {
        log("kkkkkk")
        // 用户不存在，先注册
        log(dic.message)
        Window.info(dic.message);
        return false;
    }

    if (dic.retCode == 59995) {
        DATA.nextPage = "index";
        forward();
    }
}


function onfailed(dic, index) {

}
function showSheet() {
    var sheet = new ActionSheet();
    sheet.options = { "buttons": ["账号挂失", "原手机号不在使用", "登录遇到问题", "取消"] };
    sheet.click = function (index) {
        Window.info(index)
    };
    sheet.show();
}
