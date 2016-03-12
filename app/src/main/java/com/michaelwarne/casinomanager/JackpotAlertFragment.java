package com.michaelwarne.casinomanager;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class JackpotAlertFragment extends Fragment {

    private TextView mcName;
    private Button button;
    private Bundle bun;
    public JackpotAlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_jackpot_alert, container, false);
        mcName = (TextView)v.findViewById(R.id.jackpot_mc_name);
        bun = getArguments();
        mcName.setText(bun.getString("name"));

        button = (Button)v.findViewById(R.id.alert_manager);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), R.string.manager_alerted, Toast.LENGTH_SHORT);
                toast.show();

                for (Machine mc: Machine.machineList
                        ) {
                    if(mc.getMachineId().equals(bun.getString("name"))){
                        mc.setMachineStatus("Online");
                        mc.setAlertType("Normal");
                        break;
                    }
                }
                FragmentManager fragManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
                AlertListFragment machineListFragment = new AlertListFragment();
                MachineNumbersFragment machineNumbersFragment = new MachineNumbersFragment();
                fragmentTransaction.replace(R.id.machine_numbers_container, machineNumbersFragment);
                fragmentTransaction.replace(R.id.fragment_container_alerts, machineListFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

}
