package cn.sunline.tiny.demo.service;


import cn.sunline.tiny.demo.entity.TbsExpend;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.TbsExpendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tbsExpendService")
public class TbsExpendService extends BaseService<TbsExpend,Integer> {
	@Autowired
	private TbsExpendMapper tbsExpendMapper;

	public BaseMapper<TbsExpend,Integer> getMapper() {
		return tbsExpendMapper;
	}

	public void insertNum() {
		tbsExpendMapper.insertNum();

	}
}
