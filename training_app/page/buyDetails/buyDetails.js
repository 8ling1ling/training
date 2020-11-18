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
function inputPassword(){
    DATA.nextPage="inputPassword"
    forward()
}



function  init() {
    var url = "demo/buydetails.tml?flow=buydetails";
    var params = {};
    params.incomeId =DATA.pubincomeId;
    var index = "1";
    sendRequest(url, params, index, onSuccess, onfailed);
}

function onSuccess(dic, index) {
    let BuyNum1=dic.data;
    DATA.retCode=dic.message;
    let BuyNum2=((BuyNum1*0.0531)/12)*(DATA.retCode+0);

     DATA.BuyNum=BuyNum2+BuyNum1;


     let data=dic.data1;
     let datee = new Date(data)
     let dateee =datee.Format ("yyyy-MM-dd");
     DATA.date1=dateee;
     
     DATA.date2=dic.message;
     vm.setData();

    // 
    // let productName=dic[dic.length-1].productId;
    // if(dic[dic.length-1].productId==1){
    //     let retCode=6;
    //     let Buysum=dic[dic.length-1].buyNum;
    //     let BuyNum=((Buysum*0.0531)/12)*retCode;
    //     // let data= dic[dic.length-1].incomeDate;
    //     let datee = new Date(data)
    //      let dateee =datee.Format ("yyyy-MM-dd");
    //     DATA.BuyNum=BuyNum+Buysum;
    //     DATA.date1=dateee
    //     DATA.date2=dateee
    //     DATA.retCode=retCode
    //     vm.setData();
    // }

    // if(dic[dic.length-1].productId==2){
    //     let retCode=8;
    //     let Buysum=dic[dic.length-1].buyNum;
    //     let BuyNum=((Buysum*0.0459)/12)*retCode;
    //     let data= dic[dic.length-1].incomeDate;
    //     let datee = new Date(data)
    //      let dateee =datee.Format ("yyyy-MM-dd");
    //     DATA.BuyNum=BuyNum+Buysum;
    //     DATA.date1=dateee
    //     DATA.date2=dateee
    //     DATA.retCode=retCode
    //     vm.setData();
    // }

    // if(dic[dic.length-1].productId==3){
    //     let retCode=36;
    //     let Buysum=dic[dic.length-1].buyNum;
    //     let BuyNum=((Buysum*0.0324)/12)*retCode;
    //     let data= dic[dic.length-1].incomeDate;
    //     let datee = new Date(data)
    //      let dateee =datee.Format ("yyyy-MM-dd");
    //     DATA.BuyNum=BuyNum+Buysum;
    //     DATA.date1=dateee
    //     DATA.date2=dateee
    //     DATA.retCode=retCode
    //     vm.setData();
    // }

    // if(dic[dic.length-1].productId==1){
    //     let retCode=12;
    //     let Buysum=dic[dic.length-1].buyNum;
    //     let BuyNum=((Buysum*0.038)/12)*retCode;
    //     let data= dic[dic.length-1].incomeDate;
    //     let datee = new Date(data)
    //      let dateee =datee.Format ("yyyy-MM-dd");
    //     DATA.BuyNum=BuyNum+Buysum;
    //     DATA.date1=dateee
    //     DATA.date2=dateee
    //     DATA.retCode=retCode
    //     vm.setData();
    // }
   
    //   let arr= dic.data;
    //   let retCode=dic.retCode;
    //     //  存入日期
    //    let date1=arr[0];
    //    //支取数量
       
    //    //  到期日期
    //    let date2=arr[2];
       
    //    let date = new Date(date1)
    //   let i =date.Format ("yyyy-MM-dd");

    //   let datee = new Date(date2)
    //   let ii =datee.Format ("yyyy-MM-dd");
    //   DATA.date1=i;
    //   DATA.retCode=retCode;
    //   DATA.date2=ii;
    //   DATA.pubmoney=BuyNum;
    //   vm.setData();


}
function onfailed(dic, index) {

 
 }


 Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份 
            "d+": this.getDate(), //日 
            "H+": this.getHours(), //小时 
            "m+": this.getMinutes(), //分 
            "s+": this.getSeconds(), //秒 
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
            "S": this.getMilliseconds() //毫秒 
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }


