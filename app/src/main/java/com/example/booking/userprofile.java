package com.example.booking;

public class userprofile {

    public String username;
    public  String email;
    public String address;
    public String password;

    public userprofile(){

    }

    public userprofile(String username, String userEmail, String userAddress, String userPassword) {
        this.username = username;
        this.email = userEmail;
        this.address = userAddress;
        this.password = userPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getUserAddress() {
        return address;
    }

    public void setUserAddress(String userAddress) {
        this.address = userAddress;
    }

    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String userPassword) {
        this.password = userPassword;
    }
}
