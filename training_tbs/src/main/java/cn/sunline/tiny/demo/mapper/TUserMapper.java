package cn.sunline.tiny.demo.mapper;
import org.apache.ibatis.annotations.Param;

import cn.sunline.tiny.demo.entity.TUser;

public interface TUserMapper extends BaseMapper<TUser,Long> {

     TUser getUserInfo(@Param("id") Long id);

}