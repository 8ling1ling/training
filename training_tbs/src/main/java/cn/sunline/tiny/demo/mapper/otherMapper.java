package cn.sunline.tiny.demo.mapper;

import cn.sunline.tiny.demo.entity.Other;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface otherMapper {

    List<Other> buyNum(Integer uid);

    int selectCount(Integer uid);

    List<Map> selectCode(Integer id);
}
