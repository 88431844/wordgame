package entity;

public class ChildWord {
    private Integer id;

    private Integer wordid;

    private Integer childid;

    private Integer righttimes;

    private Integer errortimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }

    public Integer getChildid() {
        return childid;
    }

    public void setChildid(Integer childid) {
        this.childid = childid;
    }

    public Integer getRighttimes() {
        return righttimes;
    }

    public void setRighttimes(Integer righttimes) {
        this.righttimes = righttimes;
    }

    public Integer getErrortimes() {
        return errortimes;
    }

    public void setErrortimes(Integer errortimes) {
        this.errortimes = errortimes;
    }
}