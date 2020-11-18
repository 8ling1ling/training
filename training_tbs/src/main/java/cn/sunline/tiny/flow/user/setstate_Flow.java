package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.TbsUser;
import cn.sunline.tiny.demo.service.TbsUserService;
import cn.sunline.tiny.flow.util.UtilPage;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("setstate_flow")
public class setstate_Flow extends JavaFlow {

    @Autowired
    TbsUserService tbsUserService;

    @FlowCom(in = "true")
    public String flow_setstate(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        //先获取用户的状态，当跳转到此页面时，更改用户的状态
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        Integer userState = tbsUser.getUserState();
        UtilPage utilPage =new UtilPage();
        //如果用户是挂失，则把0改为1
        if(userState==0){
            int i =1;
            tbsUserService.updataState(phone,i);
            utilPage.setRetCode(1);
            utilPage.setMessage("挂失成功");
            pri.put("view", JSON.toJSONString(utilPage));
            return "end";
        }
        //如果用户是解失，则把1改为0
        int i =0;
        tbsUserService.updataState(phone,i);
        //用户点击挂失后,更改用户的账号状态
        utilPage.setRetCode(0);
        utilPage.setMessage("解失成功");
        pri.put("view", JSON.toJSONString(utilPage));
        return "end";
    }
}
