// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package dto;

/**
 * created by zhhgao@mobvoi.com on 2019-04-16
 */
public class WordRoomDto {

  private int id;
  private String wordRoomName;
  private String oldName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getWordRoomName() {
    return wordRoomName;
  }

  public void setWordRoomName(String wordRoomName) {
    this.wordRoomName = wordRoomName;
  }

  public String getOldName() {
    return oldName;
  }

  public void setOldName(String oldName) {
    this.oldName = oldName;
  }
}