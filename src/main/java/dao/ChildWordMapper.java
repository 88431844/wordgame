package dao;

import entity.ChildWord;

public interface ChildWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChildWord record);

    int insertSelective(ChildWord record);

    ChildWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildWord record);

    int updateByPrimaryKey(ChildWord record);
}