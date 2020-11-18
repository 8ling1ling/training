package cn.sunline.tiny.demo.service;

import cn.sunline.tiny.demo.entity.TbsVersion;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.TbsVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tbsVersionService")
public class TbsVersionService extends BaseService<TbsVersion,Integer> {
	@Autowired
	private TbsVersionMapper tbsVersionMapper;

	public BaseMapper<TbsVersion,Integer> getMapper() {
		return tbsVersionMapper;
	}
}
