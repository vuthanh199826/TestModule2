package Bai1.service;

import java.util.List;

public interface Manage <T>{
    void display();
    void add(T e);
    void delete(int index);
    void edit(int index, T e);
    List<T> search(String str);


}
