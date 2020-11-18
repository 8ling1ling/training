package cn.sunline.tiny.demo.mapper;


import cn.sunline.tiny.demo.entity.ProductInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductInformationMapper extends BaseMapper<ProductInformation,Integer> {


    //获取用户购买的产品name
    ProductInformation getProName(Integer productId);

    //获取产品列表
    List<Map> selectProductInformations();

    ProductInformation selectByUid(Integer productId);
}
