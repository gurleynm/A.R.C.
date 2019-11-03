package com.android.arc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("UserTokenID")
    @Expose
    private String userTokenID;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("Token")
    @Expose
    private String token;

    public String get$id() {
        return $id;
    }

    public void setid(String $id) {
        this.$id = $id;
    }

    public String getUserTokenID() {
        return userTokenID;
    }

    public void setUserTokenID(String userTokenID) {
        this.userTokenID = userTokenID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}