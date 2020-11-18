package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.*;
import cn.sunline.tiny.demo.service.*;
import cn.sunline.tiny.flow.util.UtilPage;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Jsp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("clearaccount_flow")
public class clearaccount_Flow extends JavaFlow {
    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    TbsAccountService tbsAccountService;
    @Autowired
    ProductInformationService productInformationService;
    @Autowired
    otherService otherService;
    @FlowCom(in ="true")
    public String flow_clearaccount(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        //用户支取之后，把用户持有的产品取出
        //根据手机号码获取用户的id
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        Integer uid = tbsUser.getId();
        List <Other>  productIncome=otherService.buyNum(uid);
        UtilPage utilPage=new UtilPage();
        if(productIncome.size()!=0){
            int count=otherService.selectCount(uid);
//        utilPage.setData(productName);
//        utilPage.setData1(buyNum1);
            utilPage.setData(productIncome);
            utilPage.setData1(count);
            pri.put("view",JSON.toJSONString(utilPage));
            return "end";
        }
//        JSONObject object = toJSON();
//        object.put("list",productIncome);
        //获取用户购买的金额
//        BigDecimal buyNum1 = productIncome.getBuyNum();
        //根据用户购买记录的产品id获取产品名称
//        Integer productId = productIncome.getProductId();
//        ProductInformation proName =
//                productInformationService.getProName(productId);
//        String productName = proName.getProductName();
        utilPage.setData1(666);
        utilPage.setData("您还没有购买记录");
        pri.put("view",JSON.toJSONString(utilPage));

        return "end";
    }
}

