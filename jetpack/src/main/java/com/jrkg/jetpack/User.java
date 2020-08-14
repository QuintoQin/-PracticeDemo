package com.jrkg.jetpack;

import androidx.databinding.BaseObservable;

public class User extends BaseObservable {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.user);
    }
}
