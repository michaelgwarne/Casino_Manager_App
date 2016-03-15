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
public class HowToFixFragment extends Fragment {

    TextView textView;
    Bundle bundle;

    public HowToFixFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_how_to_fix, container, false);
        textView = (TextView)view.findViewById(R.id.fix_text);
        bundle = getArguments();
        int type = bundle.getInt("fixName");
        if(type == 1){
            textView.setText(R.string.check_paper_fix);
        }
        if(type == 2){
            textView.setText(R.string.reset_printer_fix);
        }
        if(type == 3){
            textView.setText(R.string.restart_machine_fix);
        }
        return view;
    }

}
