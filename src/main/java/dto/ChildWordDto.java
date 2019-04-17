
package dto;

public class ChildWordDto {

  private int id;

  private int childId;

  private int wordId;
  private String wordName;

  private int wordRoomId;
  private String wordRoomName;

  private int rightTimes;

  private int errorTimes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getChildId() {
    return childId;
  }

  public void setChildId(int childId) {
    this.childId = childId;
  }

  public int getWordId() {
    return wordId;
  }

  public void setWordId(int wordId) {
    this.wordId = wordId;
  }

  public String getWordName() {
    return wordName;
  }

  public void setWordName(String wordName) {
    this.wordName = wordName;
  }

  public int getWordRoomId() {
    return wordRoomId;
  }

  public void setWordRoomId(int wordRoomId) {
    this.wordRoomId = wordRoomId;
  }

  public String getWordRoomName() {
    return wordRoomName;
  }

  public void setWordRoomName(String wordRoomName) {
    this.wordRoomName = wordRoomName;
  }

  public int getRightTimes() {
    return rightTimes;
  }

  public void setRightTimes(int rightTimes) {
    this.rightTimes = rightTimes;
  }

  public int getErrorTimes() {
    return errorTimes;
  }

  public void setErrorTimes(int errorTimes) {
    this.errorTimes = errorTimes;
  }
}