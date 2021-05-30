package com.example.dukandar;

import android.widget.EditText;

public class UserHelperClass {
    String Name, Mobno, Address, uniquekey;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String mobno, String address, String uniquekey) {
        Name = name;
        Mobno = mobno;
        Address = address;
        this.uniquekey = uniquekey;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobno() {
        return Mobno;
    }

    public void setMobno(String mobno) {
        Mobno = mobno;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }
}