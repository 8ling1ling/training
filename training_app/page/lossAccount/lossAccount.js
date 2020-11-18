//点击登录按钮
function gotoLogin(){
    DATA.nextPage="login"
    forward()
}
//跳到手势密码
function lossResult(){
    DATA.nextPage="lossResult"
    forward()
}
//跳到设置手势密码
function buyProduct(){
    DATA.nextPage="buyProduct"
    forward()
}

function init(){
    let phone = DATA.pubData2;
    //从表中查询
    var  url = "demo/judgepassword.tml?flow=selectcardid";
    var params = {};
    params.phone = phone;
    var index ="1";
    sendRequest(url,params,index, testonSuccess,testfailed);
}

function testonSuccess(dic,index){
    log("success == "+ dic.message);
    DATA. cardMoney=dic.data;
    DATA.cardId=dic.message;
    vm.setData();
   
}
function testfailed(dic,index){

}