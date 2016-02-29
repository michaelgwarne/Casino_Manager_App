package com.michaelwarne.casinomanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String s;

        for(int i = 101; i < 115; i ++){
            s = String.valueOf(i);
            Machine.machineList.add(new Machine(s ,"Online","s", "m"));
        }
        for(int i = 115; i < 200; i ++){
            s = String.valueOf(i);
            Machine.machineList.add(new Machine(s ,"Alerts","s", "m"));
        }
        for(int i = 130; i < 145; i ++){
            s = String.valueOf(i);
            Machine.machineList.add(new Machine(s ,"Out of Service","s", "m"));
        }



        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.status,
                android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String s = parent.getItemAtPosition(position).toString();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bun = new Bundle();
                bun.putString("status", s);
                MachineListFragment frag0 =  new MachineListFragment();
                frag0.setArguments(bun);
                fragmentTransaction.replace(R.id.fragment_container, frag0);
                fragmentTransaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MachineListFragment frag0 =  new MachineListFragment();
                fragmentTransaction.replace(R.id.fragment_container, frag0);
            }
        });

    }
}
