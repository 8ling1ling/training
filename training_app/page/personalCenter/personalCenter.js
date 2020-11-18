//点击登录按钮
function gotoLogin(){
    DATA.nextPage="login"
    forward()
}
function clear_back(){

      DATA.pubData3 ="";
      DATA. pubcarnum ="";
      DATA. pubrate ="";
      DATA. pubNum ="";
      DATA.pubid ="";
      DATA. month ="";
      DATA.pubmoney ="";
      DATA.nextPage ="";
      vm.setData();
      DATA.nextPage="login"
      forward()
}
function SMSverification(){
    DATA.nextPage="SMSverification"
    forward()
}

function init() {
    let phone =DATA.pubData3
    var  url = "demo/personalcenter.tml?flow=personalcenter";
    var params = {};
    params.phone = phone;
    var index ="1";
    sendRequest(url,params,index,onSuccess,onfailed);
    
}

function onSuccess(dic,index){
  

    if(dic.retCode=="0"){
        DATA.kahao=dic.message;
        DATA.zongzicgan=dic.data1;
        DATA.kezhipei=dic.data;
        vm.setData();
    }
    if(dic.retCode =="1"){
        DATA.kahao=dic.message;
        DATA.zongzicgan=dic.data1;
        DATA.kezhipei=dic.data1;
        vm.setData();
    }
    if(dic.retCode =="2"){
        DATA.kahao=dic.message;
        DATA.zongzicgan=0;
        DATA.kezhipei=0;
        vm.setData();
    }
    

   
}

function onfailed(dic,index){

}