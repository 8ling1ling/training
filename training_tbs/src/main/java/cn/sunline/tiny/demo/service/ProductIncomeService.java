package cn.sunline.tiny.demo.service;


import cn.sunline.tiny.demo.entity.ProductIncome;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.ProductIncomeMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("productIncomeService")
public class ProductIncomeService extends BaseService<ProductIncome,Integer> {
	@Autowired
	private ProductIncomeMapper productIncomeMapper;



	public BaseMapper<ProductIncome,Integer> getMapper() {
		return  productIncomeMapper;
	}
	//获取持有数量
	public List<ProductIncome> buyNum(Integer id){
		List<ProductIncome> productIncome = productIncomeMapper.buyNum(id);
		return productIncome;
	}

	public void changeBuyNum(Integer id) {
		productIncomeMapper.changeBuyNum(id);
	}

	public void insertBuyRecord(@Param("num") BigDecimal num,
								@Param("id") Integer pubid,
								@Param("id") Integer id,
	                            @Param("data") Date date) {
		productIncomeMapper.insertBuyRecord(num,pubid,id,date);
	}

	public ProductIncome selectIncomeById(Integer id) {
		ProductIncome productIncome=
				productIncomeMapper.selectIncomeById(id);
		return productIncome;
	}

	public List<String> selectIncomeNumById(Integer id) {
		return productIncomeMapper.selectIncomeNumById(id);
	}

	public void deleteByUid(Integer id) {
		productIncomeMapper.deleteByUid(id);
	}

	public ProductIncome selectIncomeByProId(int a) {
		 ProductIncome productIncome=productIncomeMapper.selectIncomeByProId(a);
		return productIncome;
	}

	public void changeState(int a) {
		 productIncomeMapper.changeState(a);
	}

	public String selectNumByIncomeId(int a) {
		String incomeNum=productIncomeMapper.selectNumByIncomeId(a);
		return incomeNum;
	}

//	public List<Map> selectByIdList(Integer id) {
//		List<Map> maps=productIncomeMapper.selectByIdList(id);
//		return maps;
//	}
}
