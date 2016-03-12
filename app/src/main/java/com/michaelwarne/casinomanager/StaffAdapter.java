package com.michaelwarne.casinomanager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michael Warne on 06/03/2016.
 */
public class StaffAdapter extends ArrayAdapter<Staff> {

    public StaffAdapter(Context context, ArrayList<Staff> staffs){
        super(context, 0, staffs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Staff staff = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_staff_list, parent,false);
        TextView firstName = (TextView)convertView.findViewById(R.id.first_name);
        TextView lastName = (TextView)convertView.findViewById(R.id.last_name);
        TextView rank = (TextView)convertView.findViewById(R.id.rank);
        TextView isBusy = (TextView)convertView.findViewById(R.id.staff_list_is_busy);
        firstName.setText(staff.getFirstName());
        lastName.setText(staff.getLastName());
        rank.setText(staff.getRank());
        if(staff.isBusy()){
            isBusy.setText("Busy");
         //   isBusy.setBackgroundColor(Color.RED);
        }else{
            isBusy.setText("Available");
        //    isBusy.setBackgroundColor(Color.GREEN);
        }
        return convertView;
    }
}
