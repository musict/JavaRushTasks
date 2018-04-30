package com.javarush.task.task36.task3608.model;


import java.util.ArrayList;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }


    @Override
    public void loadUsers() {
        ArrayList list = new ArrayList();
        list.add(new com.javarush.task.task36.task3608.bean.User("A", 1, 1));
        list.add(new com.javarush.task.task36.task3608.bean.User("B", 2, 2));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
