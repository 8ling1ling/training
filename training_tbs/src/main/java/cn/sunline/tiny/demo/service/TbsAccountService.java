package cn.sunline.tiny.demo.service;


import cn.sunline.tiny.demo.entity.TbsAccount;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.TbsAccountMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("tbsAccountService")
public class TbsAccountService extends BaseService<TbsAccount,Integer> {

	@Autowired
	 TbsAccountMapper tbsAccountMapper;

    public BaseMapper<TbsAccount,Integer> getMapper() {
		return tbsAccountMapper;
	}

	public void updateBalance(@Param("uid") Integer uid,
							  @Param("add")BigDecimal add) {
		tbsAccountMapper.updateBalance(uid,add);
	}

	public  TbsAccount selectBalance(Integer id) {
		TbsAccount tbsAccount=tbsAccountMapper.selectBalance(id);
		return tbsAccount;
	}

}
