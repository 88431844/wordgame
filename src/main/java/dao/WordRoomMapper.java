package dao;

import entity.WordRoom;

public interface WordRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WordRoom record);

    int insertSelective(WordRoom record);

    WordRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WordRoom record);

    int updateByPrimaryKey(WordRoom record);
}