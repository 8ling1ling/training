package cn.sunline.tiny.demo.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sunline.tiny.demo.entity.TUser;
import cn.sunline.tiny.demo.mapper.*;
@Service("tUserService")
public class TUserService extends BaseService<TUser,Long> {
	@Autowired
	private TUserMapper tUserMapper;

	public BaseMapper<TUser,Long> getMapper() {
		return tUserMapper;
	}
	public TUser getUserInfo(Long p){
		return tUserMapper.getUserInfo(p);
	}

}