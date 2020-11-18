
//跳转页面
function buyProduct(){
    DATA.nextPage="buyProduct"
    forward()
}


function init() {
    //获取后台的产品数据传给前段
            var url = "demo/selectproducts.tml?flow=selectproducts";
            var params = {};
            var index = "1";
            sendRequest(url, params, index, onSuccess, onfailed);
       
    }
    
    function onSuccess(dic, index) {
        // 不同的产品信息不同
        // if(DATA.pubid=="1"){
        //     DATA.data=dic[0].product_name;
        //     DATA.product_rate=dic[0].product_rate;
        //     DATA.product_cycle=dic[0].product_cycle;
        //     //产品利率
        //     DATA.pubrate=dic[0].product_rate;
        //     // DATA.pubcycle=dic[0].product_cycle;
        //     DATA.information=dic[0].information;
        //     vm.setData();
        // }
        // if(DATA.pubid=="2"){
        //     DATA.data=dic[1].product_name;
        //     DATA.product_rate=dic[1].product_rate;
        //     DATA.product_cycle=dic[1].product_cycle;
        //     // DATA.pubcycle=dic[0].product_cycle;
        //     //产品利率
        //     DATA.pubrate=dic[0].product_rate;
        //     DATA.information=dic[1].information;
        //     vm.setData();
        // }
        // if(DATA.pubid=="3"){
            // DATA.data=dic[2].product_name;
            // DATA.product_rate=dic[2].product_rate;
            // DATA.product_cycle=dic[2].product_cycle;
            // DATA.pubrate=dic[0].product_rate;
            // // DATA.pubcycle=dic[0].product_cycle;
            // //产品利率
            // DATA.information=dic[2].information;
            // vm.setData();
        // }
        //点击不同id获取到的信息展现给用户
        // let productintro =dic[0].product_name;
        // let productintro1 =dic[1].product_name;
        // let productintro2 =dic[2].product_name;
        // DATA.productintro=productintro;
        // DATA.productintro1=productintro1;
        // DATA.productintro2=productintro2;
        // vm.setData();
        for(let i=0;i<dic.length;i++){
            if(dic[i].id==DATA.pubid){
                DATA.data=dic[i].product_name;
                DATA.product_rate=dic[i].product_rate;
                DATA.product_cycle=dic[i].product_cycle;
                DATA.pubrate=dic[i].product_rate;
                DATA.information=dic[i].information;
                vm.setData();
            }
        }
        
        // DATA.data=dic[DATA.pubid-0].product_name;
        // DATA.product_rate=dic[DATA.pubid].product_rate;
        // DATA.product_cycle=dic[DATA.pubid].product_cycle;
        // DATA.pubrate=dic[DATA.pubid].product_rate;
        // DATA.pubcycle=dic[0].product_cycle;
        //产品利率
        // DATA.information=dic[2].information;
        // vm.setData();
    }
    
    
    function onfailed(dic, index) {
    
     
     }