package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.TbsAccount;
import cn.sunline.tiny.demo.entity.TbsUser;
import cn.sunline.tiny.demo.service.*;
import cn.sunline.tiny.flow.util.CodeMsg;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component("buysuccess_flow")
public class buysuccess_Flow extends JavaFlow {

    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    TbsAccountService tbsAccountService;
    //根据手机号码查询持有产品信息
    @FlowCom(in = "true")
    public String flow_buysuccess(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        //获取用户手机号
        String phone = json.getString("phone");
        //获取购买金额
        String moneyNum = json.getString("moneynum");
        //获取购买产品id
        String pubId = json.getString("pubid");
        int pubid = Integer.parseInt(pubId);
        //根据手机号获取用户id
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        Integer id = tbsUser.getId();
        //根据用户id先查询账户余额，获取余额后减去购买的金额，更新字段
        TbsAccount tbsAccount = tbsAccountService.selectBalance(id);
        BigDecimal accountBalance = tbsAccount.getAccountBalance();
        //String转换BigDecimal
        BigDecimal num=new BigDecimal(moneyNum);
        //购买的数量，用户id，产品id
        BigDecimal subtract = accountBalance.subtract(num);
        tbsAccountService.updateBalance(id,subtract);
        productIncomeService.insertBuyRecord(num,pubid,id,new Date());
        pri.put("view", JSON.toJSONString(CodeMsg.SUCCESS));
        return "end";
        }
}
