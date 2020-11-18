package cn.sunline.tiny.demo.service;

import cn.sunline.tiny.demo.entity.StoredRecord;
import cn.sunline.tiny.demo.mapper.BaseMapper;
import cn.sunline.tiny.demo.mapper.StoredRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("storedRecordService")
public class StoredRecordService extends BaseService<StoredRecord,Integer> {
	@Autowired
	private StoredRecordMapper storedRecordMapper;

	public BaseMapper<StoredRecord,Integer> getMapper() {
		return storedRecordMapper;
	}

	public void insertRecord(StoredRecord record) {
		storedRecordMapper.insertRecord(record);
	}

	public List<String> getRecord( Integer id ) {
		List<String> storedRecord=storedRecordMapper.getRecord(id);
		return storedRecord;
	}


}
