package com.michaelwarne.casinomanager;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MachineListFragment extends ListFragment {


    public MachineListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
            Bundle bun = getArguments();
            String s = bun.getString("status");
            ArrayList<Machine> list = new ArrayList<>();

            for (Machine mc : Machine.machineList
                    ) {
                if (mc.getMachineStatus().equalsIgnoreCase(s)) {
                    list.add(mc);
                }
            }

        MachineAdapter adapter = new MachineAdapter(inflater.getContext(), list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container,savedInstanceState);
    }
}
