package service;

import com.alibaba.fastjson.JSON;
import dao.MuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private MuserMapper muserMapper;

    @Override
    public void testMysql() {
        System.out.println("---- TestServiceImpl testMysql");
                System.out.println("---- TestServiceImpl testMysql: " + JSON.toJSONString(muserMapper.selectByPrimaryKey(1)));
    }
}
