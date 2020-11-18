package cn.sunline.tiny.demo.mapper;

import cn.sunline.tiny.demo.entity.TbsUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface TbsUserMapper extends BaseMapper<TbsUser,Integer> {

    //查询用户是否存在
    //未登录状态
//    TbsUser selectByPhone(@Param("phone") String phone,
//                          @Param("password")String password);
    TbsUser selectByPhone(@Param("phone") String phone);
    //根据用户的手机号码查询用户的信息
    //登录状态，代码冗余，可以放在session中直接读取
    TbsUser selectInfoByPhone(String phone);


    //更改用户最后一次登录时间
    void setLastLoginTime(@Param("phone") String phone,
                          @Param("lastLoginTime") Date lastLoginTime);
    //查询手机号码是否存在
    int judgePhone(String phone);
    //插入用户
    void insertUser(TbsUser tbsUser);

    //设置手势密码
    void setGesture(@Param("phone") String phone,
                    @Param("setGesture")String setGesture);

    void updataState(@Param("phone") String phone,
                     @Param("i")int i);
}
