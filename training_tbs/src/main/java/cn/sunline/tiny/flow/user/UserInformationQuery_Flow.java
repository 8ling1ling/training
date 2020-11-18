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
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component("userinformationquery_flow")
public class UserInformationQuery_Flow extends JavaFlow {
    @Autowired
    TbsUserService tbsUserService;
    @FlowCom(in = "true")
    public String flow_UserInformationQuery(Context ct, PriCache pri, PubCache pub){
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        System.out.println(phone);
        //查询信息并判断用户是否实名认证
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        System.out.println(tbsUser.toString());
        String idCard=tbsUser.getIdIdentity();
        String  realName=tbsUser.getUName();
       // 秘钥http://localhost:8088/demo/userinformationquery.tml?flow=UserInformationQuery
        String appkey="10d3e666cf9b7136d20b99a255388e0";
        //第三方接口地址
        String url=
                "https://way.jd.com/youhuoBeijing/test?cardNo="+idCard+"&realName="+realName+"&appkey="+appkey+"";

        RestTemplate restTemplate=new RestTemplate();
        Map params=new HashMap();
        params.put("idCard",idCard);
        params.put("realName",realName);
        Map map=restTemplate.getForObject(url, Map.class,params);
        System.out.println(map);
        Map map2= (Map) map.get("result");
        Map map3= (Map) map2.get("result");

        restTemplate.getForObject(url, Map.class,params);
        System.out.println("-----------------------"+map3.get("reason"));

        if(map3.get("reason").equals("成功")){
            pri.put("view", JSON.toJSONString(Result.success(tbsUser)));
            return "end";
        }
            pri.put("view", JSON.toJSONString(Result.error(CodeMsg.REAL_NAME)));
            return "end";
    }



    /**
     * {
     *     "code": "10000",
     *     "charge": false,
     *     "remain": 1305,
     *     "msg": "查询成功",
     *     "result": {
     *         "error_code": 0,
     *         "reason": "成功",
     *         "result": {
     *             "realname": "林存金",
     *             "idcard": "3410927199807128010",
     *             "isok": true
     *                  }
     *                }
     * }
     * */

}
