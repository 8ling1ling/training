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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("judgepassword_flow")
public class judgepassword_Flow extends JavaFlow {
    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    ProductInformationService productInformationService;
    @Autowired
    TbsAccountService tbsAccountService;
    //支取密码验证
    @FlowCom(in = "true")
    public String flow_judgepassword(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        TbsUser userInfo = tbsUserService.getUserInfo(phone);
        String loginPassword = userInfo.getLoginPassword();
        pri.put("view", JSON.toJSONString(loginPassword));
        return "end";
    }


    //查询支取账户和余额
    @FlowCom(in = "true")
    public String flow_selectcardid(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        String incomeId = json.getString("pubincomeId");
        int a = Integer.parseInt(incomeId);
        //获取当前主键为a的金额
        String incomenum=productIncomeService.selectNumByIncomeId(a);
        //获取用户id
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        //根据用户id获取银行卡号
        String carNumber = tbsUser.getCarNumber();
        String substring = carNumber.substring(carNumber.length() - 4);

        //根据用户id获取账户余额
        TbsAccount tbsAccount = tbsAccountService.selectBalance(tbsUser.getId());
        UtilPage util =new UtilPage();
        if (tbsAccount!=null){
            BigDecimal accountBalance = tbsAccount.getAccountBalance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date =new Date();
            String str = format.format(date);
            util.setMessage(substring);
            util.setData1(str);
            util.setData(incomenum);
//            util.setData(accountBalance);
            pri.put("view", JSON.toJSONString(util));
            return "end";
        }
        util.setMessage(substring);
        pri.put("view", JSON.toJSONString(util));
        return  "end";
    }
}
