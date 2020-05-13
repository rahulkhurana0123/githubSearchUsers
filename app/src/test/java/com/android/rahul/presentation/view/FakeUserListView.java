package com.android.rahul.presentation.view;

import java.util.ArrayList;

import com.android.rahul.domain.interactor.UserModel;

/**
 * Created by rahul khurana on 13.05.2020.
 */

public class FakeUserListView implements UserListView {

    public ArrayList<UserModel> getUsers() {
        return users;
    }

    private ArrayList<UserModel> users;

    @Override
    public void init() {
        System.out.println("Init view");
        users = new ArrayList<>();
    }

    @Override
    public void notifyUsersAdded(int offset, int count) {

    }

    @Override
    public void clearList() {
        users.clear();
        System.out.println("List cleared");
    }

    @Override
    public void showLoadingError() {
        System.out.println("Loading Error");
    }

    @Override
    public void showParseError() {
        System.out.println("Parse Error");
    }

    @Override
    public void showUnexpectedError() {
        System.out.println("Unexpected Error");
    }

    @Override
    public void closeView() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void notifyUserChanged(int i) {

    }
}
