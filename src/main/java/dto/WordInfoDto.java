// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package dto;

/**
 * created by zhhgao@mobvoi.com on 2019-04-16
 */
public class WordInfoDto {

  private Integer id;

  private Integer wordroomid;
  private String wordRoomName;

  private String wordname;

  private String sound;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getWordroomid() {
    return wordroomid;
  }

  public void setWordroomid(Integer wordroomid) {
    this.wordroomid = wordroomid;
  }

  public String getWordRoomName() {
    return wordRoomName;
  }

  public void setWordRoomName(String wordRoomName) {
    this.wordRoomName = wordRoomName;
  }

  public String getWordname() {
    return wordname;
  }

  public void setWordname(String wordname) {
    this.wordname = wordname;
  }

  public String getSound() {
    return sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }
}