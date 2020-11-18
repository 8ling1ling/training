package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.*;
import cn.sunline.tiny.demo.service.*;
import cn.sunline.tiny.flow.util.CodeMsg;
import cn.sunline.tiny.flow.util.Result;
import cn.sunline.tiny.flow.util.UtilPage;
import cn.sunline.tiny.web.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("having_flow")
public class having_Flow extends JavaFlow {

    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    ProductInformationService productInformationService;
    @Autowired
    StoredRecordService recordService;
    @Autowired
    TbsAccountService tbsAccountService;
    //根据手机号码查询持有产品信息
    @FlowCom(in = "true")
    public String flow_chiyouxiangqing(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        //获取收益详情
        String incomeId = json.getString("pubincomeId");
        int a = Integer.parseInt(incomeId);
        //获取到用户的这条购买记录，把这个记录的状态改为1

        productIncomeService.changeState(a);
        //把这个购买记录的值加入到总账户中
        ProductIncome productIncome =
                productIncomeService.selectIncomeByProId(a);
        //先根据id获取账号值
        Integer uid = productIncome.getUid();
        TbsAccount tbsAccount = tbsAccountService.selectBalance(uid);
        BigDecimal accountBalance = tbsAccount.getAccountBalance();
        //相加
        BigDecimal buyNum = productIncome.getBuyNum();
        BigDecimal add = accountBalance.add(buyNum);
        //更新账户余额
        tbsAccountService.updateBalance(uid,add);
//        String phone = json.getString("phone");
        //获取用户id
//        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
//        Integer id = tbsUser.getId();
        //根据用户id获取购买产品信息
//        List<String> buyNum1   = productIncomeService.selectIncomeNumById(id);
//        if(buyNum1 != null && buyNum1.size() >= 1){
//            String buyNum = buyNum1.get(buyNum1.size() - 1);
//            BigDecimal bn=new BigDecimal(buyNum);
            //BigDecimal buyNum = productIncome.getBuyNum();
            //用户支取完理财产品之后，把理财记录删掉
//            productIncomeService.deleteByUid(id);
            //把用户支取的记录存进用户存钱表record
//            StoredRecord record=new StoredRecord();
//            record.setUId(id);
//            record.setStoreMoney(bn);
//            record.setStoreTime(new Date());
//            record.setTime(new Date());
//            recordService.insertRecord(record);
            //用户把理财产品支取后,增加用户账户的余额
            //先查询用户原本的金额，然和取出的金额相加
//            TbsAccount tbsAccount = tbsAccountService.selectBalance(id);
//            BigDecimal accountBalance = tbsAccount.getAccountBalance();
//            BigDecimal add = accountBalance.add(bn);
//            tbsAccountService.updateBalance(id,add);
//            pri.put("view", JSON.toJSONString(CodeMsg.SUCCESS));
//            return "end";
//        }
        pri.put("view", JSON.toJSONString(CodeMsg.SUCCESS));
        return "end";




//        ProductIncome productIncome=productIncomeService.buyNum(id);
        //持有金额
//        BigDecimal buyNum = productIncome.getBuyNum();
        //产品id
//        Integer productId = productIncome.getProductId();
//        System.out.println("产品id=="+productId);
//        System.out.println("产品购买数量=="+buyNum);
//        System.out.println("产品购买日期=="+productIncome.getIncomeDate());
//        String strn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productIncome.getIncomeDate().getTime());
//        System.out.println(strn);
        //获取产品信息
//        ProductInformation productInformation=
//                productInformationService.getProName(productId);
        //获取产品周期
//        Integer productCycle = productInformation.getProductCycle();
        //产品存入时间
//        Date incomeDate = productIncome.getIncomeDate();
        //计算到期的时间
        //创建日历对象
//        Calendar calendar=Calendar.getInstance();
         //在当前时间的日历对象的基础上进行加法计算
        //Calendar.MONTH 表示月
        //cycle 表示加的具体数据
        //在日历对象的基础上+投资周期的月数

//        calendar.add(Calendar.MONTH,productCycle);
//        Date time = calendar.getTime();
        //传给前端数据
//        UtilPage utilPage=new UtilPage();
        //存储期限
//        utilPage.setRetCode(productCycle);
//      List list=new ArrayList();
        //存入日期
//        list.add(incomeDate);
//        System.out.println(incomeDate);
        //持有数量
//        list.add(buyNum);
        //到期日
//        list.add(time);
//        utilPage.setData(list);
//        pri.put("view", JSON.toJSONString(utilPage));

    }


}

