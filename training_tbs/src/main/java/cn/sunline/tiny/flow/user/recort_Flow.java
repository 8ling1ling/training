package cn.sunline.tiny.flow.user;

import cn.sunline.tiny.core.FlowCom;
import cn.sunline.tiny.core.JavaFlow;
import cn.sunline.tiny.core.PriCache;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.demo.entity.Other;
import cn.sunline.tiny.demo.entity.StoredRecord;
import cn.sunline.tiny.demo.entity.TbsAccount;
import cn.sunline.tiny.demo.entity.TbsUser;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("recort_flow")
public class recort_Flow extends JavaFlow {


    @Autowired
    TbsUserService tbsUserService;
    @Autowired
    StoredRecordService storeRecordService;
    @Autowired
    TbsAccountService tbsAccountService;
    @Autowired
    ProductIncomeService productIncomeService;
    @Autowired
    otherService  otherService;
    @FlowCom(in = "true")
    public String flow_recort(Context ct, PriCache pri, PubCache pub) {
        JSONObject json = (JSONObject) pri.get("jsonsObj");
        String phone = json.getString("phone");
        //根据手机号码查询用户的充值记录
        //先获取用户的id
        TbsUser tbsUser = tbsUserService.SelectUserInfo(phone);
        //获取当前用户的卡号
        String carNumber = tbsUser.getCarNumber();
        String substring = carNumber.substring(carNumber.length() - 4);
        Integer id = tbsUser.getId();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date =new Date();
        String str = format.format(date);
        //根据id查支取记录
//        List<Map> selectByIdList = productIncomeService.selectByIdList(id);
        List<Map> other= otherService.selectCode(id);
//        List<String> storedRecord =storeRecordService.getRecord(id);
//        if (storedRecord.size()!=0){
//            String s = storedRecord.get(storedRecord.size() - 1);
//            //银行卡后4位
//            String carNumber = tbsUser.getCarNumber();
//            String substring = carNumber.substring(carNumber.length() - 4);
//            UtilPage utilPage= new  UtilPage();
//            utilPage.setData(s);
//            utilPage.setData1(substring);
//            pri.put("view", JSON.toJSONString(utilPage));
//            return "end";
//        }

//        pri.put("view", JSON.toJSONString(CodeMsg.NO_RESULT));
        pri.put("view", JSON.toJSONString(other));
        return "end";
    }
}
