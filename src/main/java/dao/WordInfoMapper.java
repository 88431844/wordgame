package dao;

import dto.WordInfoDto;
import entity.WordInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WordInfo record);

    int insertSelective(WordInfo record);

    WordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WordInfo record);

    int updateByPrimaryKey(WordInfo record);

    int haveWord(WordInfo wordInfo);

    List<WordInfoDto> listWord();

    WordInfoDto getWordById(@Param("id") int id);
}