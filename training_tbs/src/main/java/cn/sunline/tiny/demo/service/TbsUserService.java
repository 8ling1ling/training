package cn.sunline.tiny.demo.service;


import cn.sunline.tiny.demo.entity.TbsUser;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.TbsUserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("tbsUserService")
public class TbsUserService extends BaseService<TbsUser,Integer> {
	@Autowired
	private TbsUserMapper tbsUserMapper;

	public BaseMapper<TbsUser,Integer> getMapper() {
		return  tbsUserMapper;
	}


	//验证登录时输入的用户名、密码是否正确
	public TbsUser getUserInfo(@Param("phone") String phone
							   ) {
		TbsUser tbsUser=tbsUserMapper.selectByPhone(phone);
		//如果数据库不存在，则返回值null
		if(tbsUser==null){
			return null;
		}
		tbsUserMapper.setLastLoginTime(tbsUser.getUPhone(),new Date());
		return tbsUser;
	}

	//验证手机号是否存在
	public int judgePhone(String phone) {
		int existPhone = tbsUserMapper.judgePhone(phone);
		return existPhone;
	}

	//添加用户
	public void insertUser(TbsUser tbsUser) {
		tbsUserMapper.insertUser(tbsUser);
	}
	//根据用户的手机号码(身份证信息)查询用户的信息
	public TbsUser SelectUserInfo(String phone) {
		TbsUser tbsUser=tbsUserMapper.selectInfoByPhone(phone);
		return tbsUser;
	}

	//设置手势密码
	public void setGesture(@Param("phone") String phone,
						   @Param("setGesture")String setGesture) {
		tbsUserMapper.setGesture(phone,setGesture);
		System.out.println(phone);
		System.out.println(setGesture);


	}

	//更改用户状态
	public void updataState(@Param("phone") String phone,
							@Param("i")int i) {
		tbsUserMapper.updataState(phone, i);
	}
}
