package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.ProductIncome;
import cn.sunline.tiny.demo.entity.ProductInformation;
import cn.sunline.tiny.demo.service.ProductIncomeService;
import cn.sunline.tiny.demo.service.ProductInformationService;
import cn.sunline.tiny.demo.service.otherService;
import cn.sunline.tiny.flow.util.UtilPage;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("buydetails_flow")
public class buydetails_Flow  extends JavaFlow {
    @Autowired
    otherService otherService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    ProductInformationService productInformationService;
    @FlowCom(in = "true")
    public String flow_buydetails(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        //获取收益详情
        String incomeId = json.getString("incomeId");
        int a = Integer.parseInt(incomeId);
        //获取存储的时间
        ProductIncome productIncome=
                productIncomeService.selectIncomeByProId(a);
        Date incomeDate = productIncome.getIncomeDate();

        //获取购买的数量
        BigDecimal buyNum = productIncome.getBuyNum();
        int num=buyNum.intValue();
        //根据产品id获取产品的周期
        Integer productId = productIncome.getProductId();
        System.out.println(productId);
        System.out.println(productId);
        ProductInformation productInformation =
                productInformationService.selectByUid(productId);
        Integer productCycle = productInformation.getProductCycle();
        //获取当前产品的利率
        String productRate = productInformation.getProductRate();
        UtilPage utilPage=new UtilPage();
        utilPage.setRetCode(productCycle);
        utilPage.setData(num);
        utilPage.setData1(incomeDate);
        utilPage.setMessage(productRate);
        pri.put("view", JSON.toJSONString(utilPage));

        return "end";
    }

}