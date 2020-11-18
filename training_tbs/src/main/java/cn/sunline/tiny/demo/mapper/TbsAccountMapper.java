package cn.sunline.tiny.demo.mapper;


import cn.sunline.tiny.demo.entity.TbsAccount;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface TbsAccountMapper extends BaseMapper<TbsAccount,Integer> {

    void updateBalance(@Param("uid") Integer uid,
                       @Param("add") BigDecimal add);

    TbsAccount selectBalance(Integer id);
}
