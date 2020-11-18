package cn.sunline.tiny.demo.mapper;

import cn.sunline.tiny.demo.entity.StoredRecord;
import com.sun.prism.impl.Disposer;

import java.util.List;
import java.util.Map;

public interface StoredRecordMapper extends BaseMapper<StoredRecord,Integer> {

    void insertRecord(StoredRecord record);

    List<String> getRecord(Integer id);


}
