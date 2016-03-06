package com.michaelwarne.casinomanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;


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
        String s;

        for(int i = 115; i < 120; i ++){
            s = String.valueOf(i);
            Machine.machineList.add(new Machine(s ,"Alerts","s", "m"));
        }
        for(int i = 130; i < 145; i ++){
            s = String.valueOf(i);
            Machine.machineList.add(new Machine(s ,"Out of Service","s", "m"));
        }

        Staff.staffList.add(new Staff("Jessica", "Björnstad","Peon", true));
        Staff.staffList.add(new Staff("Poopy", "Poophead","Manager", false));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AlertListFragment machineListFragment = new AlertListFragment();
        OosListFragment oosListFragment = new OosListFragment();
        StaffListFragment staffListFragment = new StaffListFragment();
        fragmentTransaction.replace(R.id.fragment_container_out_of_service, oosListFragment);
        fragmentTransaction.replace(R.id.fragment_container_alerts, machineListFragment);
        fragmentTransaction.replace(R.id.fragment_container2, staffListFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        setContentView(R.layout.activity_main);


    }
}
