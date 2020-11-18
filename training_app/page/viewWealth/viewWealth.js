//点击登录按钮
function gotoLogin(){
    DATA.nextPage="login"
    forward()
}


// 点击支取
function buyDetails(init){
    // if(){
        
    // }
    // DATA.incomeList
    // if(DATA.length<1){
    //     Window.info("您还没有购买理财产品");
    //     return false;
    // }
    DATA.pubincomeId=init;
    vm.setData();
    DATA.nextPage="buyDetails"
    forward()
}
//跳到设置手势密码
function back_index(){
    // DATA.nextPage="back_index"
    // forward()
    var opts = {"url":"../nav.tml", "animate":"slideFromRight", "closePrevious":"true"}
Navigator.present(opts);
}




function  init() {

    //页面加载的时候，根据用户输入的手机号码从后台获取用户的已有的产品金额
    let phone =DATA.pubData3
    var url = "demo/clearaccount.tml?flow=clearaccount";
    var params = {};
    params.phone = phone;
    var index = "1";
    sendRequest(url, params, index, onSuccess, onfailed);
}

function onSuccess(dic, index) {
    DATA.incomeList=dic.data;
    DATA.buyNum=dic.data1
    vm.setData();

    // log(dic.length+"+++++++++++++++++++++++++++++++")

    // let productName=dic[dic.length-1].productId;
    // if(dic[dic.length-1].productId==1){
    //     let productName="余额宝";
    //     DATA.productName=productName;
    //     DATA.buyNum=dic[dic.length-1].buyNum;
    //     DATA.pubNum=dic[dic.length-1].buyNum;
    //     vm.setData();
    // }
    // if(dic[dic.length-1].productId==2){
    //     let productName="支付!!!!!!!!支付宝";
    //     DATA.productName=productName;
    //     DATA.buyNum=dic[dic.length-1].buyNum;
    //     DATA.pubNum=dic[dic.length-1].buyNum;
    //     vm.setData();
    // }
    // if(dic[dic.length-1].productId==3){
    //     let productName="财付通";
    //     DATA.productName=productName;
    //     DATA.buyNum=dic[dic.length-1].buyNum;
    //     DATA.pubNum=dic[dic.length-1].buyNum;
    //     vm.setData();
    // }
    // if(dic[dic.length-1].productId==4){
    //     let productName="吉富通";
    //     DATA.productName=productName;
    //     DATA.buyNum=dic[dic.length-1].buyNum;
    //     DATA.pubNum=dic[dic.length-1].buyNum;
    //     vm.setData();
    // }
    // log(productName+"-------------------------")
   
    // log(DATA.productName);
    // log(DATA.productName)

}

function onfailed(dic, index) {

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