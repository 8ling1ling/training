
function testRequest(){
    //$('LoadingView').setProgress("50");

    let name = DATA.name;
    let phone = DATA.phone; 
    let password1=DATA.password1;
    let password2=DATA.password2;
    let identity=DATA.identity;

    if(name||phone||password1||password2||identity==""){
        Window.info("输入的信息不能为空哦！");
        log(name); 
         log(phone); 
          log(password1); 
           log(password2);  
           log(identity);
        return false
    }


    //正则表达式判断用户输入手机号的格式是否正确  
      let reg=/^1[3-9]\d{9}$/
    if(!reg.test(phone)){
        Window.info("请输入正确的手机号！");1
        return false
      }


      //前端判断
      //判断用户输入的两次密码是否一致
      if(password1!=password2){
        Window.info("确认密码和登录密码不一致！！");
      }
      
       //查找的正则 ，用于验证字符串中是否有数字
        let reg1=/\d/
       //查找的正则，用于验证字符串中是否有字母
        let reg2=/[a-zA-Z]/
       //进入if表示字符串中没有数字或字母
       if(!reg1.test(password1)||!reg2.test(password1)){
        Window.info("密码必须包含数字和字母");
        return false;
       }
    
      //访问数据库
       //判断用户输入的手机号是否已经注册过
      
    var  url = "demo/registered.tml?flow=registered";
    var params = {};
    params.name = name;
    params.phone = phone;
    params.password1 = phopassword1;
    params.identity = identity;
    var index ="1";
    sendRequest(url,params,index,onSuccess,onfailed);
    
}

function getpasscode(){
    //$('LoadingView').setProgress("50");
    
    var  url = "login.tml?flow=1";
    var params = {};
    params.id = "1";
    sendRequest(url,params,"1",onSuccess,onfailed);
}


function onSuccess(dic,index){



    log("success == "+ dic);
    log("success == "+ JSON.stringify(dic));

    let message=dic.message;
    if(dic.retCode==599999){
        log("kkkkkk")
        Window.info(message);
    }
    if(dic.retCode!=599999){
        DATA.nextPage = "index";
        Window.info(message);
        forward();
    }

}

function onfailed(dic,index){

}


function showSheet(){
    var sheet = new ActionSheet();
    sheet.options = {"buttons":["账号挂失", "原手机号不在使用", "登录遇到问题", "取消"]};
    sheet.click = function(index) {
        alert(index)
        
    };
    sheet.show();
}

countdown3 = $('CountdownButton3');
//验证码点击事件
countdown3.addEventListener('click', function () {
    log("===============================================================click1");

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
//监听验证码结束事件
countdown1.addEventListener('stop',function(){
    log("================stop");
    alert("倒计时结束:");
});
//验证码倒计时开始方法
//countdown1.countdownButtonStart();

//点击登录按钮
function productDetails(){
    DATA.nextPage="productDetails"
    forward()
}