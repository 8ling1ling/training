package cn.sunline.tiny.demo.service;
        import org.springframework.stereotype.Service;
        import org.springframework.beans.factory.annotation.Autowired;
        import cn.sunline.tiny.demo.entity.TestDb;
        import cn.sunline.tiny.demo.mapper.*;
@Service("testDbService")
public class TestDbService extends BaseService<TestDb,Integer> {
    @Autowired
    private TestDbMapper testDbMapper;

    public BaseMapper<TestDb,Integer> getMapper() {
        return testDbMapper;
    }
}
