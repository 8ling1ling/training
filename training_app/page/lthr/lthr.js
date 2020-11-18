function testRequest(){
    // let phone = DATA.pubData2;
    let phone = DATA.phone;
    var  url = "demo/setstate.tml?flow=setstate";
    var params = {};
    params.phone = phone;
    var index ="1";
    sendRequest(url,params,index, testonSuccess,testfailed);
}
function testonSuccess(dic,index){
    if(dic.retCode==0){
        Window.info("账户已挂失，请先解除挂失");
        return false;
    }
}
function testfailed(dic,index){

}

countdown3 = $('CountdownButton3');
//验证码点击事件
countdown3.addEventListener('click', function () {

    let code = "";
    for (let i = 1; i <= 6; i++) {
            let num = Math.floor(Math.random() * 10);
            code += num;
}
log(code+"nnnnnnnnnnnn")
DATA.code=code;
vm.setData();
    alert("发送验证码");
});

//点击登录按钮
function login() {
    DATA.nextPage = "index"
    forward()
}


function register() {
    DATA.nextPage = "login";
    forward();
}

function showSheet() {
    var sheet = new ActionSheet();
    sheet.options = { "buttons": ["解除挂失", "原手机号不在使用", "登录遇到问题", "取消"] };
    sheet.click = function (index) {
        Window.info(index)
        if (index==0) {
            DATA.nextPage="SMSverification2";
            forward()
        }
    };
    sheet.show();
}