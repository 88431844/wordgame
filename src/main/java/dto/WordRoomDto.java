
package dto;

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