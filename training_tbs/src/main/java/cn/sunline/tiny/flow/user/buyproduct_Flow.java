package cn.sunline.tiny.flow.user;


import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.ProductIncome;
import cn.sunline.tiny.demo.entity.TbsAccount;
import cn.sunline.tiny.demo.entity.TbsUser;
import cn.sunline.tiny.demo.service.ProductIncomeService;
import cn.sunline.tiny.demo.service.ProductInformationService;
import cn.sunline.tiny.demo.service.TbsAccountService;
import cn.sunline.tiny.demo.service.TbsUserService;
import cn.sunline.tiny.flow.util.UtilPage;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("buyproduct_flow")
public class buyproduct_Flow extends JavaFlow {

    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    TbsAccountService tbsAccountService;
    @Autowired
    ProductInformationService productInformationService;
    //根据手机号码查询持有产品信息
    @FlowCom(in = "true")
    public String flow_zhiNengCunKuan(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        //根据用户的手机号获取用户的账号及余额
        String phone = json.getString("phone");
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        //获取用户的账号
        String carNumber = tbsUser.getCarNumber();
        String substring = carNumber.substring(carNumber.length() - 4);
        //获取用户id
        Integer id = tbsUser.getId();
        //根据用户id获取账号余额
        TbsAccount tbsAccount = tbsAccountService.selectBalance(id);
        if (tbsAccount!=null) {
            BigDecimal accountBalance = tbsAccount.getAccountBalance();
            UtilPage utilPage=new UtilPage();
            utilPage.setData(accountBalance);
            utilPage.setData1(substring);
            pri.put("view", JSON.toJSONString(utilPage));
            return "end";
        }
        UtilPage utilPage=new UtilPage();
        utilPage.setData(0);
        utilPage.setData1(substring);
        pri.put("view", JSON.toJSONString(utilPage));
        return  "end";
//        ProductIncome productIncome=productIncomeService.buyNum(id);
//        //持有金额
//        BigDecimal buyNum = productIncome.getBuyNum();
//        //产品id
//        Integer productId = productIncome.getProductId();
//        //获取产品信息
//        ProductInformation productInformation=
//                productInformationService.getProName(productId);
//        //产品名称
//        String productName = productInformation.getProductName();

//        pri.put("view", JSON.toJSONString(Result.error(CodeMsg.CODE_ERROR)));

    }
}
