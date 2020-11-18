
function buySucceeded(){
    if(DATA.money==""){
        Window.info("请输入金额")
        return false;
    }


    if(DATA.money>DATA.data){
        Window.info("余额不足")
        return false;
    }
    DATA.pubmoney=DATA.money
    DATA.pubcarnum=DATA.data1;
    vm.setData();
    DATA.nextPage="buySucceeded"
    forward()
}



function init() {
    
    var url = "demo/buyproduct.tml?flow=zhiNengCunKuan";
    let phone =DATA.pubData2
    // let pubid=DATA.pubid;
    var params = {};
    // params.pubid=pubid;
    params.phone = phone;
    var index = "1";
    sendRequest(url, params, index, onSuccess, onfailed);
}

function onSuccess(dic, index) {
    DATA.data=dic.data;
    DATA.data1=dic.data1;
    vm.setData();
}


function onfailed(dic, index) {

 
 }



	var select = $("select")
	select.addEventListener("focus", function(){
		alert("获取焦点");
	})
	select.focus();


select.addEventListener("select", function(value, position){

    if(value==1){
        DATA.month="1";
        DATA.expire="2020-02-16";
         vm.setData();
    }
    if(value==2){
        DATA.month="2";
        DATA.expire="2021-11-16";
         vm.setData();
    }
    if(value==3){
        DATA.month="3";
        DATA.expire="2023-02-16";
         vm.setData();
    }
    

});


