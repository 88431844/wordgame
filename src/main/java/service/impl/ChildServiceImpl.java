package service.impl;

import dao.ChildInfoMapper;
import dto.ChildInfoDto;
import entity.ChildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ChildService;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildInfoMapper childInfoMapper;


    @Override
    public int haveChild(String childName) {
        return childInfoMapper.haveChild(childName);
    }

    @Override
    public void add(String childName) {
        ChildInfo childInfo = new ChildInfo();
        childInfo.setChildname(childName);
        childInfoMapper.insertSelective(childInfo);
    }

    @Override
    public void del(int id) {
        childInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ChildInfo> list() {
        return childInfoMapper.list();
    }

    @Override
    public void edit(ChildInfoDto childInfoDto) {
        ChildInfo childInfo = new ChildInfo();
        childInfo.setId(childInfoDto.getId());
        childInfo.setChildname(childInfoDto.getChildName());
        childInfoMapper.updateByPrimaryKeySelective(childInfo);
    }

    @Override
    public ChildInfo getChildById(int id) {
        return childInfoMapper.selectByPrimaryKey(id);
    }
}
