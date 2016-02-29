package com.michaelwarne.casinomanager;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MachineDetailFragment extends Fragment {



    private TextView online;
    private TextView oos;
    private TextView alerts;
    private TextView mcName;
    private TextView mcType;
    private TextView mcMake;
    private Integer noOfOnline = 0;
    private Integer noOfAlerts = 0;
    private Integer noOfOos = 0;

    public MachineDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_machine_detail, container, false);
        // Inflate the layout for this fragment
        online = (TextView) v.findViewById(R.id.online_text);
        alerts = (TextView)v.findViewById(R.id.alerts_text);
        oos = (TextView) v.findViewById(R.id.oos_text);
        mcName = (TextView)v.findViewById(R.id.machine_name);
        mcType = (TextView)v.findViewById(R.id.machine_type);
        mcMake = (TextView)v.findViewById(R.id.machine_make);
        Bundle bun = new Bundle();
        bun = getArguments();
        for (Machine mc: Machine.machineList
             ) {
            if(mc.getMachineStatus().equalsIgnoreCase("online")) noOfOnline++;
            if(mc.getMachineStatus().equalsIgnoreCase("alerts")) noOfAlerts++;
            if(mc.getMachineStatus().equalsIgnoreCase("out of service")) noOfOos++;
        }
        online.setText(noOfOnline.toString());
        alerts.setText(noOfAlerts.toString());
        oos.setText(noOfOos.toString());
        mcName.setText(bun.getString("name"));
        mcType.setText(bun.getString("type"));
        mcMake.setText(bun.getString("make"));
        return v;
    }

}
