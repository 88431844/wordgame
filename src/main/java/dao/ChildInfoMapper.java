package dao;

import entity.ChildInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChildInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChildInfo record);

    int insertSelective(ChildInfo record);

    ChildInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildInfo record);

    int updateByPrimaryKey(ChildInfo record);

    ChildInfo getChildByName(@Param("childName") String childName);

    int haveChild(@Param("childName") String childName);

    List<ChildInfo> list();
}