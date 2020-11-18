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
        vm.setData();
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