package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.TbsAccount;
import cn.sunline.tiny.demo.entity.TbsUser;
import cn.sunline.tiny.demo.service.ProductIncomeService;
import cn.sunline.tiny.demo.service.ProductInformationService;
import cn.sunline.tiny.demo.service.TbsAccountService;
import cn.sunline.tiny.demo.service.TbsUserService;
import cn.sunline.tiny.flow.util.CodeMsg;
import cn.sunline.tiny.flow.util.UtilPage;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component("personalcenter_flow")
public class personalcenter_Flow  extends JavaFlow{
    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    TbsAccountService tbsAccountService;
    @Autowired
    ProductIncomeService productIncomeService;
    @FlowCom(in = "true")
    public String flow_personalcenter(Context ct, PriCache pri, PubCache pub) {
        //获取手机号
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        System.out.println("00000000000000000000000000000000"+json);
        String phone = json.getString("phone");
        if (!("".equals(phone))){
            System.out.println("1111111111111111111111111111111111111111111");

            //根据手机号码获取用户id、卡号
            TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
            Integer id = tbsUser.getId();
            String carNumber = tbsUser.getCarNumber();
            //根据id查询用户的Balance
            TbsAccount tbsAccount = tbsAccountService.selectBalance(id);
            UtilPage utilPage=new UtilPage();
            if(tbsAccount!=null){
                BigDecimal accountBalance = tbsAccount.getAccountBalance();
                //根据id查询用户购买的理财
                List<String> strings = productIncomeService.selectIncomeNumById(id);
                if(strings != null && strings.size() >= 1){
                    String buyNum = strings.get(strings.size() - 1);
                    BigDecimal bn=new BigDecimal(buyNum);
                    //表示有购买记录
                    utilPage.setRetCode(0);
                    //总资产
                    BigDecimal add = accountBalance.add(bn);
                    //卡号
                    utilPage.setMessage(carNumber);
                    //总资产
                    utilPage.setData1(add);
                    //可支配余额
                    utilPage.setData(accountBalance);
                    pri.put("view", JSON.toJSONString(utilPage));
                    return "end";
                }
                //如果用户没有购买理财,总资产=可支配余额
                utilPage.setMessage(carNumber);
                utilPage.setData1(accountBalance);
                utilPage.setRetCode(1);
                //如果用户全部购买力理财，那么
                pri.put("view", JSON.toJSONString(utilPage));
                return "end";
            }
            //新用户
            utilPage.setRetCode(2);
            utilPage.setMessage(carNumber);
            pri.put("view", JSON.toJSONString(utilPage));
            return "end";
        }
      return "end";
    }
}
