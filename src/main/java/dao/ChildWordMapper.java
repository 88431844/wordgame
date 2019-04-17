package dao;

import dto.ChildWordDto;
import entity.ChildWord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChildWord record);

    int insertSelective(ChildWord record);

    ChildWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildWord record);

    int updateByPrimaryKey(ChildWord record);

    List<ChildWordDto> listChildWord(@Param("childId") Integer childId);
}