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

import java.util.Date;

@Component("registered_flow")
public class registered_Flow extends JavaFlow {
    @Autowired
    TbsUserService tbsUserService;
    @FlowCom(in = "true")
    /**
     * FlowCom属性：
     * id：FlowCom组件的id
     * name：组件的名字
     *
     */
    public String flow_registered(Context ct, PriCache pri, PubCache pub){
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String name = json.getString("name");
        String phone = json.getString("phone");
        String password = json.getString("password1");
        String cardId = json.getString("cardId");
        String identity = json.getString("identity");
        //把前端取的值的封装起来传值给数据库
        TbsUser tbsUser=new TbsUser();
        tbsUser.setUName(name);
        tbsUser.setCarNumber(cardId);
        tbsUser.setLoginPassword(password);
        tbsUser.setIdIdentity(identity);
        tbsUser.setUPhone(phone);
        tbsUser.setRegistrationDate(new Date());
        tbsUser.setLoginDate(new Date());
        //判断手机号是否存在
          int existPhone=tbsUserService.judgePhone(phone);
          if (existPhone==1){
              pri.put("view", JSON.toJSONString(Result.error(CodeMsg.PHONE_EXIST)));
              return "end";
          }
        //手机号不存在insert
        tbsUserService.insertUser(tbsUser);
        //提示注册成功或者
        pri.put("view", JSON.toJSONString(Result.error(CodeMsg.REGISTERED_SUCCEED)));
        return "end";
    }


    //设置登录手势密码
    @FlowCom(in = "true")
    public String flow_setGesture(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String setGesture = json.getString("setGesture");
        String phone = json.getString("phone");

        tbsUserService.setGesture(phone,setGesture);

        return "end";
    }


}
