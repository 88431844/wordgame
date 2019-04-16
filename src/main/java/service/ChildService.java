package service;

import dto.ChildInfoDto;
import entity.ChildInfo;

import java.util.List;

public interface ChildService {
    int haveChild(String childName);

    void add(String childName);

    void del(int id);

    List<ChildInfo> list();

    void edit(ChildInfoDto childInfoDto);

    ChildInfo getChildById(int id);
}
