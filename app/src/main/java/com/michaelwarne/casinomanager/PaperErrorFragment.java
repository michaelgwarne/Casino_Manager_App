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
public class PaperErrorFragment extends Fragment {

    TextView mcId;

    public PaperErrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bun = getArguments();
        View view = inflater.inflate(R.layout.fragment_error_paper, container, false);
        mcId = (TextView)view.findViewById(R.id.machineId_paper_out);
        mcId.setText(bun.getString("name"));

        // Inflate the layout for this fragment
        return view;
    }

}
