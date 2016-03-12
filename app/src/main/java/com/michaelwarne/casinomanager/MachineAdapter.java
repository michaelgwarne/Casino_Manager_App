package com.michaelwarne.casinomanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michael Warne on 28/02/2016.
 */
public class MachineAdapter extends ArrayAdapter<Machine> {

    public MachineAdapter(Context context, ArrayList<Machine> machines){
        super(context, 0, machines);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Machine machine = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_machine_list, parent,false);
        TextView t1 = (TextView)convertView.findViewById(R.id.machine_id);
        TextView t2 = (TextView)convertView.findViewById(R.id.machine_status);
        t1.setText(machine.getMachineId());
        t2.setText(machine.getAlertType());

        return convertView;
    }
}
