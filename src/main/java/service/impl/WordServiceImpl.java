package service.impl;

import dao.ChildWordMapper;
import dao.WordInfoMapper;
import dao.WordRoomMapper;
import dto.ChildWordDto;
import dto.WordInfoDto;
import dto.WordRoomDto;
import entity.ChildWord;
import entity.WordInfo;
import entity.WordRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.WordService;

@Service
public class WordServiceImpl implements WordService {

  @Autowired
  private WordRoomMapper wordRoomMapper;
  @Autowired
  private WordInfoMapper wordInfoMapper;
  @Autowired
  private ChildWordMapper childWordMapper;

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
  public List<ChildWordDto> listChildWord(Integer childId) {
    List<ChildWordDto> ret = new ArrayList<>();
    List<WordInfoDto> wordInfoDtoList = wordInfoMapper.listWord();
    //查询登陆儿童汉字信息
    List<ChildWordDto> childWordDtoList = childWordMapper.listChildWord(childId);
    //如果没有登陆，或则儿童没有训练汉字，则加载全部汉字信息
    if (childWordDtoList.size() == 0){
      for (WordInfoDto wordInfoDto : wordInfoDtoList){
        ret.add(convert(wordInfoDto));
      }
    }
    else {
    //拼接 查询到到儿童训练汉字 + 全部汉字去掉训练汉字 组合成新列表
      Map<Integer,Object> childTrainedWordIdMap = new HashMap<>();
      for (ChildWordDto childWordDto :childWordDtoList){
        childTrainedWordIdMap.put(childWordDto.getWordId(),"1");
      }
      for (WordInfoDto wordInfoDto : wordInfoDtoList){
        if (null != childTrainedWordIdMap.get(wordInfoDto.getId())){
          childWordDtoList.add(convert(wordInfoDto));
        }
      }
    }
    return ret;
  }

  @Override
  public void updateChildTrain(int childId, int wordid, boolean b) {
    ChildWord childWord = childWordMapper.selectByChildIdWordId(childId,wordid);
    int rightTimes = 0;
    int errorTimes = 0;
    if (b){
      rightTimes = 1;
    }else {
      errorTimes = 1;
    }
    //说明没有儿童训练记录，进行新增记录操作
    if (null == childWord){
      ChildWord c = new ChildWord();
      c.setChildid(childId);
      c.setWordid(wordid);
      c.setRighttimes(rightTimes);
      c.setErrortimes(errorTimes);
      childWordMapper.insertSelective(c);
    }else {
      //说明已经有儿童训练记录，则进行更新操作
      int newRightTimes = childWord.getRighttimes() == null ? 0 : childWord.getRighttimes() + rightTimes;
      int newErrorTimes = childWord.getErrortimes() == null ? 0 : childWord.getErrortimes() + errorTimes;
      childWord.setRighttimes(newRightTimes);
      childWord.setErrortimes(newErrorTimes);
      childWordMapper.updateByPrimaryKeySelective(childWord);
    }
  }

  @Override
  public List<WordInfoDto> listWord() {
    return wordInfoMapper.listWord();
  }

  private ChildWordDto convert(WordInfoDto wordInfoDto){
    ChildWordDto childWordDto = new ChildWordDto();
    childWordDto.setWordId(wordInfoDto.getId());
    childWordDto.setWordName(wordInfoDto.getWordName());
    childWordDto.setWordRoomId(wordInfoDto.getWordroomid());
    childWordDto.setWordRoomName(wordInfoDto.getWordRoomName());
    return childWordDto;
  }
}
