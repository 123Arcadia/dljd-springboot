package org.zcw1.dao;

public interface BookDao {
    public void update();
    public int select();

    String findName(int id);
    String findName(int id, String name);
}
