

function viewWealth(){

    //插入用户购买记录,减少用户账户余额
     var url = "demo/buysuccess.tml?flow=buysuccess";
    let phone =DATA.pubData2;
    let pubid =DATA.pubid;
    let moneynum=DATA.moneynum;
    var params = {};
    params.pubid=pubid;
    params.phone = phone;
    params.moneynum = moneynum;
    var index = "1";
    sendRequest(url, params, index, onSuccess, onfailed);
    
}

function onSuccess(dic, index) {
    if(dic.retCode==59995){
        Window.info("操作成功")
     DATA.nextPage="viewWealth"
         forward()
    }else{
        Window.info("操作失败")
    }
}
function onfailed(dic, index) {

 
 }














function init() {

    log("monthmonthmonthmonthmonthmonthmonth"+DATA.month)
    if(DATA.month=="1"){
        //上一个页面的到期日
        DATA.overtime="2021-02-16"
         //上一个页面的存储的期限
        DATA.buymonth="3";
        //上一个页面的利率
        DATA.rate=DATA.pubrate;
        //上一个页面的卡号
         DATA.carnum=DATA.pubcarnum;
         //上一个页面输入的金额
         DATA.moneynum=DATA.pubmoney;
        vm.setData();
    }
    if(DATA.month=="2"){
        DATA.overtime="2021-11-16"
        DATA.buymonth="12";
        DATA.rate=DATA.pubrate;
        DATA.carnum=DATA.pubcarnum;
        DATA.moneynum=DATA.pubmoney;
        vm.setData();
    }
    if(DATA.month=="3"){
        DATA.overtime="2023-11-16"
        DATA.buymonth="36";
        DATA.rate=DATA.pubrate;
        DATA.carnum=DATA.pubcarnum;
        DATA.moneynum=DATA.pubmoney;
        vm.setData();
    }
   
}


//只能推荐
// function init() {
//     log("Hello World");
//     //网络请求回来的数据源
//     $('AIRecommend').setAIRecommend("数据源");
// }
// //点击相对的cell返回跳转路径
// $('AIRecommend').addEventListener("schemeEvent",function(scheme){
// 	log(scheme);
// })

// $('AIRecommend').addEventListener("recommendMore",function(){
// 	log('recommendMore');
// })

// $('AIRecommend').addEventListener("recommendSetting",function(){
// 	log('recommendSetting');
// })
// var select1 = $("select")
// (function(){
//     var select = $("select")
// 	select.addEventListener("focus", function(){
// 		alert("获取焦点");
// 	})
// 	select.focus();
// })();

// select1.addEventListener("select", function(value, position){
// 	alert("value:" + value + " position:" + position);
// });


