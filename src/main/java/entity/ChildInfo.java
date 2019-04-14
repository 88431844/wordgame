package entity;

public class ChildInfo {
    private Integer id;

    private String childname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname == null ? null : childname.trim();
    }
}