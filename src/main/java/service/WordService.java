package service;

import dto.WordInfoDto;
import dto.WordRoomDto;
import entity.WordInfo;
import entity.WordRoom;
import java.util.List;

public interface WordService {

  int haveWordRoom(String wordRoomName);

  void addWordRoom(String wordRoomName);

  void delWordRoom(int id);

  void updateWordRoom(WordRoomDto wordRoomDto);

  List<WordRoom> list();

  int haveWord(WordInfo wordInfo);

  void addWord(WordInfo wordInfo);

  void delWord(int id);

  void updateWord(WordInfo wordInfo);

  List<WordInfoDto> listWord();
}
