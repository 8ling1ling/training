package cn.sunline.tiny.demo.service;

import cn.sunline.tiny.demo.entity.ProductInformation;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.ProductInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("productInformationService")
public class ProductInformationService extends BaseService<ProductInformation,Integer> {
	@Autowired
	private ProductInformationMapper productInformationMapper;

	public BaseMapper<ProductInformation,Integer> getMapper() {
		return productInformationMapper;
	}

	//获取产品名称
	public ProductInformation getProName(Integer productId) {
		ProductInformation ProductInformation=
				productInformationMapper.getProName(productId);
		return ProductInformation;
	}

	public List<Map> selectProductInformations() {
		List<Map>  productInfor=
				productInformationMapper.selectProductInformations();
		return productInfor;
	}

	public ProductInformation selectByUid(Integer productId) {
		 ProductInformation productInformation
		=productInformationMapper.selectByUid(productId);
		return productInformation;
	}
}
