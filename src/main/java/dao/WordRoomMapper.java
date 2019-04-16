package dao;

import entity.WordRoom;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WordRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WordRoom record);

    int insertSelective(WordRoom record);

    WordRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WordRoom record);

    int updateByPrimaryKey(WordRoom record);

  int haveWordRoom(@Param("wordRoomName") String wordRoomName);

    List<WordRoom> list();
}