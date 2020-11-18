//点击登录按钮
function gotoLogin(){
    DATA.nextPage="login"
    forward()
}
//点击首页推荐的产品
function productDetails(){
    if(DATA.pubData==""){
        Window.info("未登录")
        return false;
    }
    DATA.nextPage="productDetails"
    forward()
}
//点击账户总览
function viewWealth(){
    if(DATA.pubData==""){
        Window.info("未登录")
        return false;
    }
    // 
    var url = "demo/clearaccount.tml?flow=clearaccount";
    var params = {};
    params.phone = DATA.pubData;
    var index = "1";
    sendRequest(url, params, index, accountonSuccess, accountonfailed);
    // 
}
// 
function accountonSuccess(dic, index) {
    if(dic.data1==666){
        Window.info("您还没有购买记录")
        return false;
    }
    if(dic != 666){
        log("/////////////////////////////////////////////////////////"+dic+"****")
        DATA.nextPage="viewWealth"
        forward()
    }
}

function accountonfailed(dic, index) {

}
// 

//点击理财
function productRecommendation(){
    if(DATA.pubData==""){
        Window.info("未登录")
        return false;
    }
    DATA.nextPage="productRecommendation"
    forward()
}
//点击存款
function CashInBank(){
    if(DATA.pubData==""){
        Window.info("未登录")
        return false;
    }
    DATA.nextPage="CashInBank"
    forward()
}

//点击支取记录
function moneyRecord(){
    if(DATA.pubData==""){
        Window.info("未登录")
        return false;
    }
    DATA.nextPage="moneyRecord"
    forward()
}
//根据手机号判断当前用户是否登录选择是否显示登录按钮
function init(){
    if(DATA.pubData!=""){
        DATA.abc = "hidden"
        vm.setData()
    }
    if(DATA.pubData==""){
        DATA.value = "hidden"
        vm.setData()
    }
}