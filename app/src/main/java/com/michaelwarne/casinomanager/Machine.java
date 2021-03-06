package com.michaelwarne.casinomanager;

import java.util.ArrayList;


/**
 * Created by Michael Warne on 28/02/2016.
 */
public class Machine {

    private String machineId;
    private String machineStatus;
    private String machineType;
    private String machineMake;
    private String alertType;
    public static ArrayList<Machine> machineList = new ArrayList<>();

    public Machine(String id, String status, String type, String make, String alertType){
        this.machineId = id;
        this.machineStatus = status;
        this.machineType = type;
        this.machineMake = make;
        this.alertType = alertType;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMachineMake() {
        return machineMake;
    }

    public void setMachineMake(String machineMake) {
        this.machineMake = machineMake;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
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
