package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.service.ProductInformationService;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component("selectproducts_flow")
public class selectproducts_Flow  extends JavaFlow {
    @Autowired
    ProductInformationService productInformationService;
    @FlowCom(in = "true")
    public String flow_selectproducts(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        List <Map> productInfo=
                productInformationService.selectProductInformations();
        //获取产品信息
        pri.put("view", JSON.toJSONString(productInfo));
        return "end";
    }

}
