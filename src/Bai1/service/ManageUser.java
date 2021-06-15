package Bai1.service;

import Bai1.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageUser implements Manage<User>, WorkWithFile<User> {
    List<User> userList = new ArrayList<>();

    @Override
    public void display() {
        for (User user:userList){
            System.out.println(user);
        }
    }

    @Override
    public void add(User e) {
        userList.add(e);
    }

    @Override
    public void delete(int index) {
        userList.remove(index);
    }

    @Override
    public void edit(int index, User e) {
        for (User user:userList){
            if(userList.indexOf(user)==index){
                user.setGroup(e.getGroup());
                user.setName(e.getName());
                user.setGender(e.isGender());
                user.setDob(e.getDob());
                user.setAddress(e.getAddress());
                user.setEmail(e.getEmail());
            }
        }

    }

    public int checkIndex(String number){
        for (User user:userList){
            if (user.getNumber().equals(number)){
                return userList.indexOf(user);
            }
        }
        return -1;
    }

    @Override
    public List<User> search(String str) {
        List<User> list = new ArrayList<>();
        for (User user:userList){
            if(user.getName().equals(str)){
                list.add(user);
            }
        }
        return list;
    }

    public User searchByNumber (String number){
        for (User user:userList){
            if(user.getNumber().equals(number)){
                return user;
            }
        }
        return null;
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public void writeToFileCSV(String path, List<User> list) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (User user: list) {
            bufferedWriter.write(user.getGroup()+","+ user.getName()+"," + user.isGender()+ "," + user.getDob()+ "," +user.getNumber()+","+user.getAddress()+","+user.getEmail()+ "\n");
        }
        bufferedWriter.close();
        fileWriter.close();

    }

    @Override
    public List<User> readFileCSV(String path) throws IOException {
        List<User> list = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            String group = arr[0];
            String name = arr[1];
            boolean gender = Boolean.parseBoolean(arr[2]);
            String dob = arr[3];
            String number = arr[4];
            String address = arr[5];
            String email = arr[6];
            list.add(new User(group,name,gender,dob,number,address,email));
        }
        return list;
    }
}
