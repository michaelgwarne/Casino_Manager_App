package com.michaelwarne.casinomanager;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertListFragment extends ListFragment {


    public AlertListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            ArrayList<Machine> list = new ArrayList<>();

            for (Machine mc : Machine.machineList
                    ) {
                if (mc.getMachineStatus().equalsIgnoreCase("alerts")) {
                    list.add(mc);
                }
            }

        MachineAdapter adapter = new MachineAdapter(inflater.getContext(), list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container,savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Machine mc = (Machine)getListView().getItemAtPosition(position);
        Bundle bun = new Bundle();
        bun.putString("name", mc.getMachineId());
        bun.putString("type", mc.getMachineType());
        bun.putString("make", mc.getMachineMake());
        bun.putString("state", mc.getMachineStatus());
        PaperErrorFragment paperErrorFragment = new PaperErrorFragment();
        paperErrorFragment.setArguments(bun);
        fragmentTransaction.replace(R.id.fragment_container2, paperErrorFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
