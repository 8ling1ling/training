var gestureLock = {};
function init() {
    gestureLock = $('GestureLock');
    // 返回手势密码 0-8 组合的字符串
    gestureLock.setupEncode("aes","asdadasdasdghjkl","12345678");//加密方式及密钥
    gestureLock.setupDecode("aes","asdadasdasdghjkl","12345678");//解密方式及密钥
    gestureLock.addEventListener('finish',function(password){
        log("结束")
        log(password)
        DATA.password = password;
        if(DATA.temp==""){
            DATA.temp=DATA.password;
        }else{
            if(DATA.temp != DATA.password){
                DATA.temp="";
                vm.setData();
            Window.info("两次手势不一致");
            }else{
                let phone =DATA.pubData2;
                var url = "demo/registered.tml?flow=setGesture";
                var params = {};
                params.setGesture=password;
                params.phone=phone;
                var index = "1";
                log(phone+"phonephonephonephonephonephonephonephonephone");
                log(password+"passwordpasswordpasswordpasswordpassword");
                DATA.nextPage="index";
               forward();
                sendRequest(url, params, index, onSuccess, onfailed);
            }
        }

    });
    gestureLock.addEventListener('begin',function(){
        log("开始绘制");
    });
}

function clean() {
    // 清除手势连线
    gestureLock.setParam('clean','');
}

function setValue() {
    // 设置数值到手势密码中，如果使用加密传输，这里传输的是加密的数据，需要提前通知解密方式
    gestureLock.setParam('value','12587');
}

function skip(){
    DATA.nextPage = "index";
    forward();
}


function onSuccess(dic,index){
    DATA.nextPage="index";
      forward();
}
function onfailed(dic,index){
    DATA.nextPage="index";
      forward();
}