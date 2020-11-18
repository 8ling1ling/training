

function productDetails(inid){
        DATA.pubid=inid;
        vm.setData();
        DATA.nextPage="productDetails";
        forward()

    // if(inid==1){
    //     DATA.pubid=inid();
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
    // if(inid==2){
    //     DATA.pubid="2";
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
    // if(inid==3){
    //     DATA.pubid="3";
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
    // if(inid==4){
    //     DATA.pubid="4";
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
    // if(inid==5){
    //     DATA.pubid="5";
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
    // if(inid==6){
    //     DATA.pubid="6";
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
    // if(inid==7){
    //     DATA.pubid="7";
    //     vm.setData();
    //     DATA.nextPage="productDetails";
    //     forward()
    // }
}

// function productDetails1(){
   
// }

// function productDetails2(){
   
// }


//进入页面加载产品信息
function  init() {
//获取后台的产品数据传给前段
        var url = "demo/selectproducts.tml?flow=selectproducts";
        var params = {};
        var index = "1";
        sendRequest(url, params, index, onSuccess, onfailed);
   
}

function onSuccess(dic, index) {
    // let productintro =dic.message;
    // let productintro ;
    // let productintro1 =dic[1].product_name;
    // let productintro2 =dic[2].product_name;
    DATA.dataList=dic;
    // DATA.productintro1=productintro1;
    // DATA.productintro2=productintro2;
    vm.setData();
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