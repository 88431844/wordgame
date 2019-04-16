package service.impl;

import dao.WordInfoMapper;
import dao.WordRoomMapper;
import dto.WordInfoDto;
import dto.WordRoomDto;
import entity.WordInfo;
import entity.WordRoom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.WordService;

@Service
public class WordServiceImpl implements WordService {

  @Autowired
  private WordRoomMapper wordRoomMapper;
  @Autowired
  private WordInfoMapper wordInfoMapper;

  @Override
  public int haveWordRoom(String wordRoomName) {
    return wordRoomMapper.haveWordRoom(wordRoomName);
  }

  @Override
  public void addWordRoom(String wordRoomName) {
    WordRoom wordRoom = new WordRoom();
    wordRoom.setWordroomname(wordRoomName);
    wordRoomMapper.insertSelective(wordRoom);
  }

  @Override
  public void delWordRoom(int id) {
    wordRoomMapper.deleteByPrimaryKey(id);
  }

  @Override
  public void editWordRoom(WordRoomDto wordRoomDto) {
    WordRoom wordRoom = new WordRoom();
    wordRoom.setId(wordRoomDto.getId());
    wordRoom.setWordroomname(wordRoomDto.getWordRoomName());
    wordRoomMapper.updateByPrimaryKeySelective(wordRoom);
  }

  @Override
  public List<WordRoom> list() {
    return wordRoomMapper.list();
  }

  @Override
  public int haveWord(WordInfo wordInfo) {
    return wordInfoMapper.haveWord(wordInfo);
  }

  @Override
  public void addWord(WordInfo wordInfo) {
    wordInfoMapper.insertSelective(wordInfo);
  }

  @Override
  public void delWord(int id) {
    wordInfoMapper.deleteByPrimaryKey(id);
  }

  @Override
  public void editWord(WordInfo wordInfo) {
    wordInfoMapper.updateByPrimaryKeySelective(wordInfo);
  }

  @Override
  public WordInfoDto getWordById(int id) {
    return wordInfoMapper.getWordById(id);
  }

  @Override
  public WordRoom getByWordRoomId(int id) {
    return wordRoomMapper.selectByPrimaryKey(id);
  }

  @Override
  public int wordRoomHaveWord(int id) {
    return wordRoomMapper.wordRoomHaveWord(id);
  }

  @Override
  public List<WordInfoDto> listWord() {
    return wordInfoMapper.listWord();
  }

}
