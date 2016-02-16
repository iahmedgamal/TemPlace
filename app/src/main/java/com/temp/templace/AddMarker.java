package com.temp.templace;

/**
 * Created by sheko on 15/02/16.
 */
public class AddMarker {

    String address;
    String days;

    public AddMarker(){


    }


    public AddMarker(String address ,String days){

        this.address=address;
        this.days=days;


    }

    public String getAddress() {
        return address;
    }

    public String getDays() {
        return days;
    }
}
