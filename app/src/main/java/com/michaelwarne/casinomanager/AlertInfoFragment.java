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


/**
 * A simple {@link Fragment} subclass.
 */
public class AlertInfoFragment extends Fragment {

   private TextView mcId;
   private TextView mcError;
   private Button takeButton;
   private String name;
    public AlertInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert_info, container, false);
        mcId = (TextView)view.findViewById(R.id.alert_info_id);
        mcError = (TextView)view.findViewById(R.id.alert_info_error);
        final Bundle bun = getArguments();
        name = bun.getString("name");
        mcId.setText(name);
        for (Machine mc: Machine.machineList
             ) {
            if(mc.getMachineId().equalsIgnoreCase(name)){
                mcError.setText(mc.getAlertType());
                break;
            }
        }
        takeButton = (Button)view.findViewById(R.id.alert_info_button);
        takeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(bun.get("alert").equals("Out of paper")) {
                        PaperErrorFragment paperErrorFragment = new PaperErrorFragment();
                        paperErrorFragment.setArguments(bundle);
                        fragmentTransaction.replace(R.id.fragment_container2, paperErrorFragment);
                }else{
                    JackpotAlertFragment jackpotAlertFragment = new JackpotAlertFragment();
                    jackpotAlertFragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.fragment_container2, jackpotAlertFragment);
                }

         //       fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
