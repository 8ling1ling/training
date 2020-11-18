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

function testRequest(){

    let phone = DATA.pubData2;
    
    var  url = "demo/setstate.tml?flow=setstate";
    var params = {};
    params.phone = phone;
    var index ="1";
    sendRequest(url,params,index, testonSuccess,testfailed);
}


function testonSuccess(dic,index){

    log("success == "+ dic.retCode);
    log("success == "+ dic.message);
    if(dic.retCode==1){
        Window.info(dic.message);
        // DATA.pubData2="";
        DATA.nextPage="lthr"
        forward()
    }
}
function testfailed(dic,index){

}