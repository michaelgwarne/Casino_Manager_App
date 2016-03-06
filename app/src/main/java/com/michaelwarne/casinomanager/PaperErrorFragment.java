package com.michaelwarne.casinomanager;


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
public class PaperErrorFragment extends Fragment {
    TextView refillPaper;
    Button refillYes;
    Button refillNo;
    Button refillQuestion;
    Button checkYes;
    Button checkNo;
    Button checkQuestion;
    Button resetYes;
    Button resetNo;
    Button resetQuestion;
    Button restartYes;
    Button restartNo;
    Button restartQuestion;
    Button report;
    TextView mcId;

    public PaperErrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: onClick code
        View view = inflater.inflate(R.layout.fragment_error_paper, container, false);
        refillPaper = (TextView)view.findViewById(R.id.refill_paper);
        refillYes = (Button)view.findViewById(R.id.refill_paper_yes);
        refillNo = (Button)view.findViewById(R.id.refill_paper_no);
        refillQuestion = (Button)view.findViewById(R.id.refill_paper_question);
        checkYes = (Button)view.findViewById(R.id.check_paper_yes);
        checkNo = (Button)view.findViewById(R.id.check_paper_no);
        checkQuestion = (Button)view.findViewById(R.id.check_paper_question);
        resetYes = (Button)view.findViewById(R.id.reset_printer_yes);
        resetNo = (Button)view.findViewById(R.id.reset_printer_no);
        resetQuestion = (Button)view.findViewById(R.id.reset_printer_question);
        restartYes = (Button)view.findViewById(R.id.restart_button_yes);
        restartNo = (Button)view.findViewById(R.id.restart_button_no);
        restartQuestion = (Button)view.findViewById(R.id.restart_button_question);
        Bundle bun = getArguments();
        mcId = (TextView)view.findViewById(R.id.machineId_paper_out);
        mcId.setText(bun.getString("name"));

        refillYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        refillNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refillYes.setEnabled(false);
                refillNo.setEnabled(false);
                refillQuestion.setEnabled(false);
                refillPaper.setEnabled(false);
            }
        });

        refillQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        checkYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        checkNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        checkQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        resetYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        resetNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        resetQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        restartYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        restartNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        restartQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }



}
