package cn.sunline.tiny.flow;

import cn.sunline.tiny.demo.entity.TUser;
import cn.sunline.tiny.demo.service.TUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.core.data.database.TinyJdbcDao;
import cn.sunline.tiny.web.Context;
/*  Context属性：
   channelId:
   transCode:
   flowsn:
   respMsg:
   respCode:
   sessionId:
   PubCache pubDataCache:
   PriCache priDataCache：
   requestURI：
   contextPath：
   requestURL：
   contextPath：
   requestURL:
   bizno:
   sysno:
   HttpServletRequest request:
   HttpServletResponse response:

    */
@Component("userinfo_flow")
public class UserInfoFlow extends JavaFlow {

    private static final Logger log = LoggerFactory.getLogger(UserInfoFlow.class);

    @Autowired
    TUserService tUserService;

    @Autowired
    TinyJdbcDao tinyJdbcDao;

    @FlowCom(in="true", succ="15")
    public String flow_1(Context ct, PriCache pri, PubCache pub) {

        log.debug("pri: {}", pri);
        log.debug("pub: {}", pub);

        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
//        String id = pub.getParam("id");
        String id = json.getString("id");
        log.debug("phone: {}", phone);
        log.debug("id: {}", id);
        TUser user = tUserService.getUserInfo(Long.valueOf(id));


        pub.put("phone", phone);
//        pri.put("view", JSON.toJSONString(tinyJdbcDao.queryList("select * from t_user where id=?", id)));
        pri.put("view", JSON.toJSONString(user));

        return END;
//        return SUCCESS;
    }


    public String flow_2(Context ct, PriCache pri, PubCache pub) {
        log.debug("pri: {}", pri);
        log.debug("pub: {}", pub);

        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        String id = pub.getParam("id");
        log.debug("phone: {}", phone);
        log.debug("id: {}", id);
//        TUser user = tUserService.getUserInfo(Long.valueOf(id));


        pub.put("phone", phone);
        pri.put("view", JSON.toJSONString(tinyJdbcDao.queryList("select * from t_user")));
//        pri.put("view", JSON.toJSONString(user));

        return END;
//        return SUCCESS;
    }

    @FlowCom(name="view")
    public String flow_15(Context ct, PriCache pri, PubCache pub) {
        log.debug("pri: {}", pri);
        return "test";
    }

}
