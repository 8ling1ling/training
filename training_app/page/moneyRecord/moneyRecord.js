function testRequest(){
    DATA.nextPage="index"
    forward()
}

// function  init() {
//     if(DATA.pubData2!=""){
//     let phone =DATA.pubData2
//     var url = "demo/judgepassword.tml?flow=selectcardid";
//     var params = {};
//     params.phone = phone;
//     var index = "1";
//     sendRequest(url, params, index, onSuccess, onfailed);
//     }
// }
// function onSuccess(dic, index) {
//     //到款账户
//     let cardnum =dic.message;
//     log(cardnum);
//     DATA.id=cardnum;
//     log(DATA.id);
//     DATA.money =dic.data;
//     DATA.transaction=dic.data1;
//     log(dic.data1+"000000000000000000000000000000000000000000000");
//     vm.setData();
// }


// function onfailed(dic, index) {

 
//  }

 function init(){

    let phone = DATA.pubData2;
    
    var  url = "demo/recort.tml?flow=recort";
    var params = {};
    params.phone = phone;
    var index ="1";
    sendRequest(url,params,index, testonSuccess,testfailed);
}

function testonSuccess(dic,index){

    DATA.incomecode=dic;
    // //当前时间
    // log("success == "+ dic.data1);
    // //银行卡号
    // log("success == "+ dic.data);
    // //整取金额
    // DATA.id=dic.data1;
    // DATA.money=dic.data;
    vm.setData();
   
}
function testfailed(dic,index){

}
