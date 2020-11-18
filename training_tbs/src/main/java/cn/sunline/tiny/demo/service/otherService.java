package cn.sunline.tiny.demo.service;

import cn.sunline.tiny.demo.entity.Other;
import cn.sunline.tiny.demo.mapper.otherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("otherService")
public class otherService {

    @Autowired
    otherMapper otherMapper;
    public List<Other> buyNum(Integer uid) {
        List<Other>  other= otherMapper.buyNum(uid);
        return other;
    }

    public int selectCount(Integer uid) {
        int count=otherMapper.selectCount(uid);
        return count;
    }

    public List<Map> selectCode(Integer id) {
        List<Map> other=otherMapper.selectCode(id);
        return other;
    }
}
