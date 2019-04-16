package entity;

public class WordInfo {
    private Integer id;

    private Integer wordroomid;

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

    public String getWordname() {
        return wordname;
    }

    public void setWordname(String wordname) {
        this.wordname = wordname == null ? null : wordname.trim();
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound == null ? null : sound.trim();
    }
}