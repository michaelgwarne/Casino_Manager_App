package com.michaelwarne.casinomanager;

import java.util.ArrayList;

/**
 * Created by Michael Warne on 06/03/2016.
 */
public class Staff {

    private String firstName;
    private String lastName;
    private String rank;
    private boolean busy;
    public static ArrayList<Staff> staffList = new ArrayList<>();
    public Staff(String firstName, String lastName, String rank, boolean busy){
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.busy = busy;
    }

    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public String getRank() {
        return rank;
    }

    public boolean isBusy() {
        return busy;
    }
}
