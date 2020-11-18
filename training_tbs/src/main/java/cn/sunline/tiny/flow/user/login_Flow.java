package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.TbsUser;
import cn.sunline.tiny.demo.service.TbsUserService;
import cn.sunline.tiny.flow.util.CodeMsg;
import cn.sunline.tiny.flow.util.Result;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//
@Component("login_flow")
public class login_Flow extends JavaFlow {
    //
    @Autowired
    TbsUserService tbsUserService;

    //登录验证
      @FlowCom(in = "true")
      public String flow_login(Context ct, PriCache pri, PubCache pub) {
          JSONObject json = (JSONObject) pri.get("jsonsObj");
          String phone = json.getString("phone");
          int code = Integer.parseInt(json.getString("code"));
          Integer passcode = Integer.valueOf(pub.getParam("code"));
          //验证码错误
          if (code!= passcode){
              pri.put("view",JSON.toJSONString(Result.error(CodeMsg.CODE_ERROR)));
              return "end";
          }
          //验证码正确
          if (code== passcode){
              //未注册
              TbsUser tbsUser = tbsUserService.getUserInfo(phone);
              if (tbsUser == null) {
                  pri.put("view", JSON.toJSONString(Result.error(CodeMsg.USER_NOT_EXSIST)));
                  System.out.println(passcode);
                  return "end";
              }
              //已经注册
              pri.put("view", JSON.toJSONString(Result.error(CodeMsg.SUCCESS)));
              return "end";
          }
          return "end";
      }
      //生成6位随机数模拟短信验证码
      public static int getPassCode(){
//          Passcode passcode=new Passcode();
          int passcodeNum=(int)((Math.random()*9+1)*100000);
          return passcodeNum;
      }
    @FlowCom(in = "true")
    public String flow_getCode(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String code=String.valueOf(login_Flow.getPassCode());
        System.out.println(code);
        pri.put("view", code);
        pub.put("code",code);
        return "end";
    }
}
