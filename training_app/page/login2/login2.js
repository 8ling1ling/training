
function testRequest(){
    //$('LoadingView').setProgress("50");


    let phone = DATA.phone; 
    let passcode=DATA.passcode;


    var  url = "demo/login.tml?flow=1";
    var params = {};
    params.phone = phone;
    params.passcode=passcode;
    var index ="1";

    log("sss")
    log(params.passcode);
    log(params.phone);
    sendRequest(url,params,index,onSuccess,onfailed);

    
}

function login2(){
    DATA.nextPage = "login";
    forward();
    // Window.info("功能待开发");
}

function login1(){
    DATA.nextPage = "login";
    log("189252555")
    forward();
}
function getpasscode(){

}
function register(){
    DATA.nextPage = "registered";
    forward();

}

                

function getpasscode(){
    //$('LoadingView').setProgress("50");
    
    var  url = "login.tml?flow=1";
    var params = {};
    params.id = "1";
    sendRequest(url,params,"1",onSuccess,onfailed);
}


function onSuccess(dic,index){

    log("success == "+ dic);
    log("success == "+ JSON.stringify(dic));


    let message=dic.message;
    if(dic.retCode==500102){
        log("kkkkkk")
        Window.info(message);
    }
    if(dic.retCode!=500102){
        DATA.nextPage = "index";
        forward();
    }

}

function onfailed(dic,index){

}


function showSheet(){
    var sheet = new ActionSheet();
    sheet.options = {"buttons":["账号挂失", "原手机号不在使用", "登录遇到问题", "取消"]};
    sheet.click = function(index) {
        alert(index)
        
    };
    sheet.show();
}

countdown1 = $('CountdownButton1');
//验证码点击事件
countdown1.addEventListener('click',function(){
    log("================click1");
    alert("发送验证码");
});
//监听验证码结束事件
countdown1.addEventListener('stop',function(){
    log("================stop");
    alert("倒计时结束:");
});
//验证码倒计时开始方法
//countdown1.countdownButtonStart();

//点击登录按钮
function login(){
    DATA.nextPage="index"
    forward()
}