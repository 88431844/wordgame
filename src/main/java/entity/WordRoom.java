package entity;

public class WordRoom {
    private Integer id;

    private String wordroomname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordroomname() {
        return wordroomname;
    }

    public void setWordroomname(String wordroomname) {
        this.wordroomname = wordroomname == null ? null : wordroomname.trim();
    }
}