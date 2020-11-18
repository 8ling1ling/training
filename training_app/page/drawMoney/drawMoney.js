function viewWealth(){

    var url = "demo/having.tml?flow=chiyouxiangqing";
    var params = {};
    params.pubincomeId=DATA.pubincomeId;
    var index = "1";

    sendRequest(url, params, index, onSuccess1, onfailed);
}

function onSuccess1(dic, index) {
    //用户表提取成功之后，把购买的记录标准修改为1，同时把支取的金额加到账户里面
    let message =dic.message;
    let retCode =dic.retCode;
    if(retCode == 59995){
        Window.info(message)
        DATA.nextPage="index"
        forward()
    }
}
function onfailed(dic, index) {
 
 }

 function init(){
    let phone = DATA.pubData2;
    //从表中查询
    var  url = "demo/judgepassword.tml?flow=selectcardid";
    var params = {};
    params.phone = phone;
    params.pubincomeId=DATA.pubincomeId;
    var index ="1";
    sendRequest(url,params,index, testonSuccess,testfailed);
}

function testonSuccess(dic,index){

    //当前时间
    log("success == "+ dic.data1);
    //银行卡号
    log("success == "+ dic.message);
    log("success == "+ dic.message);
    //整取金额
    DATA.money=dic.data;
    DATA.id=dic.message;
    DATA.transaction=dic.data1;
    vm.setData();
   
}
function testfailed(dic,index){

}
