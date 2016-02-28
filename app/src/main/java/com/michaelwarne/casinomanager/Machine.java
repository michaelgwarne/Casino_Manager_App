package com.michaelwarne.casinomanager;

import java.util.ArrayList;


/**
 * Created by Michael Warne on 28/02/2016.
 */
public class Machine {

    private String machineId;
    private String machineStatus;
    public static ArrayList<Machine> machineList = new ArrayList<>();

    public Machine(String id, String status){
        this.machineId = id;
        this.machineStatus = status;

    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }
}
