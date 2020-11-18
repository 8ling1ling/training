package cn.sunline.tiny.demo.mapper;

import cn.sunline.tiny.demo.entity.ProductIncome;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface ProductIncomeMapper extends BaseMapper<ProductIncome,Integer> {

    List<ProductIncome> buyNum(Integer id);

    void changeBuyNum(Integer id);
     void  insertBuyRecord(@Param("num") BigDecimal num,
                           @Param("pubid") Integer pubid,
                           @Param("id") Integer id,
                            @Param("date") Date date);


    ProductIncome selectIncomeById(Integer id);

    List<String> selectIncomeNumById(Integer id);

    void deleteByUid(Integer id);

    ProductIncome selectIncomeByProId(int a);

    void changeState(int a);

    String selectNumByIncomeId(int a);

//    List<Map> selectByIdList(Integer id);
}
