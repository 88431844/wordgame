package service;

import dto.ChildWordDto;
import dto.WordInfoDto;
import dto.WordRoomDto;
import entity.WordInfo;
import entity.WordRoom;
import java.util.List;

public interface WordService {

  int haveWordRoom(String wordRoomName);

  void addWordRoom(String wordRoomName);

  void delWordRoom(int id);

  void editWordRoom(WordRoomDto wordRoomDto);

  List<WordRoom> list();

  int haveWord(WordInfo wordInfo);

  void addWord(WordInfo wordInfo);

  void delWord(int id);

  List<WordInfoDto> listWord();

    void editWord(WordInfo wordInfo);

  WordInfoDto getWordById(int id);

  WordRoom getByWordRoomId(int id);

    int wordRoomHaveWord(int id);

  List<ChildWordDto> listChildWord(Integer childId);
}
