package com.michaelwarne.casinomanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack();
        }
            else{
                finish();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            setupMachines();

            Staff.staffList.add(new Staff("Dave", "Davidsson", "Floor Staff", false));
            Staff.staffList.add(new Staff("Bob", "Bobsson", "Floor Staff", true));
            Staff.staffList.add(new Staff("Sven", "Svensson", "Floor Manager", false));
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AlertListFragment machineListFragment = new AlertListFragment();
        OosListFragment oosListFragment = new OosListFragment();
        StaffListFragment staffListFragment = new StaffListFragment();
        MachineNumbersFragment machineNumbersFragment = new MachineNumbersFragment();
        fragmentTransaction.replace(R.id.machine_numbers_container, machineNumbersFragment);
        fragmentTransaction.replace(R.id.fragment_container_out_of_service, oosListFragment);
        fragmentTransaction.replace(R.id.fragment_container_alerts, machineListFragment);
        fragmentTransaction.replace(R.id.fragment_container2, staffListFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        setContentView(R.layout.activity_main);


    }

    private void setupMachines(){
        String s;
        for(int i = 1; i < 312; i ++){
            s = String.valueOf(i);
            Machine.machineList.add(new Machine(s ,"Online","s", "m", "Normal"));
        }
        Machine.machineList.get(7).setMachineStatus("Alerts");
        Machine.machineList.get(7).setAlertType("Out of paper");
        Machine.machineList.get(59).setMachineStatus("Alerts");
        Machine.machineList.get(59).setAlertType("Out of paper");
        Machine.machineList.get(145).setMachineStatus("Alerts");
        Machine.machineList.get(145).setAlertType("Jackpot");
        Machine.machineList.get(156).setMachineStatus("Alerts");
        Machine.machineList.get(156).setAlertType("Out of paper");
        Machine.machineList.get(174).setMachineStatus("Alerts");
        Machine.machineList.get(174).setAlertType("Jackpot");
        Machine.machineList.get(193).setMachineStatus("Alerts");
        Machine.machineList.get(193).setAlertType("Out of paper");
        Machine.machineList.get(210).setMachineStatus("Alerts");
        Machine.machineList.get(210).setAlertType("Guest help request");
        Machine.machineList.get(2).setMachineStatus("Out of Service");
        Machine.machineList.get(2).setAlertType("Offline");
        Machine.machineList.get(131).setMachineStatus("Out of Service");
        Machine.machineList.get(131).setAlertType("Offline");
        Machine.machineList.get(301).setMachineStatus("Out of Service");
        Machine.machineList.get(301).setAlertType("Offline");

    }
}
