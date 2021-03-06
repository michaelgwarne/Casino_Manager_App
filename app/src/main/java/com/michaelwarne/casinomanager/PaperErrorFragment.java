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
public class PaperErrorFragment extends Fragment {
    private TextView refillPaper;
    private Button refillYes;
    private Button refillNo;
    private Button refillQuestion;
    private TextView checkPaper;
    private Button checkYes;
    private Button checkNo;
    private Button checkQuestion;
    private TextView resetPrinter;
    private Button resetYes;
    private Button resetNo;
    private Button resetQuestion;
    private TextView restartMachine;
    private Button restartYes;
    private Button restartNo;
    private Button restartQuestion;
    Button report;
    private TextView mcId;
    private Bundle bun;
    private Bundle bunAway;

    public PaperErrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_error_paper, container, false);
        refillPaper = (TextView)view.findViewById(R.id.refill_paper);
        refillYes = (Button)view.findViewById(R.id.refill_paper_yes);
        refillNo = (Button)view.findViewById(R.id.refill_paper_no);
        refillQuestion = (Button)view.findViewById(R.id.refill_paper_question);
        checkPaper = (TextView)view.findViewById(R.id.check_paper);
        checkYes = (Button)view.findViewById(R.id.check_paper_yes);
        checkNo = (Button)view.findViewById(R.id.check_paper_no);
        checkQuestion = (Button)view.findViewById(R.id.check_paper_question);
        resetPrinter = (TextView)view.findViewById(R.id.reset_printer);
        resetYes = (Button)view.findViewById(R.id.reset_printer_yes);
        resetNo = (Button)view.findViewById(R.id.reset_printer_no);
        resetQuestion = (Button)view.findViewById(R.id.reset_printer_question);
        restartMachine = (TextView)view.findViewById(R.id.restart_machine);
        restartYes = (Button)view.findViewById(R.id.restart_button_yes);
        restartNo = (Button)view.findViewById(R.id.restart_button_no);
        restartQuestion = (Button)view.findViewById(R.id.restart_button_question);
        bun = getArguments();
        mcId = (TextView)view.findViewById(R.id.machineId_paper_out);
        mcId.setText(bun.getString("name"));



        refillYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReport(v);
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
                showHelp(1);

            }
        });

        checkYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReport(v);
            }
        });

        checkNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkYes.setEnabled(false);
                checkNo.setEnabled(false);
                checkQuestion.setEnabled(false);
                checkPaper.setEnabled(false);

            }
        });

        checkQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp(1);
            }
        });

        resetYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReport(v);
            }
        });

        resetNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNo.setEnabled(false);
                resetYes.setEnabled(false);
                resetQuestion.setEnabled(false);
                resetPrinter.setEnabled(false);
            }
        });
        resetQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp(2);

            }
        });

        restartYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReport(v);
            }
        });

        restartNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartNo.setEnabled(false);
                restartYes.setEnabled(false);
                restartQuestion.setEnabled(false);
                restartMachine.setEnabled(false);
            }
        });

        restartQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp(3);

            }
        });
        return view;
    }

    public void showHelp(int question){
        FragmentManager fragManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        bunAway = new Bundle();
        bunAway.putInt("fixName", question);
        HowToFixFragment howToFixFragment = new HowToFixFragment();
        howToFixFragment.setArguments(bunAway);
        fragmentTransaction.replace(R.id.fragment_container2, howToFixFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void saveReport(View v){
        Toast toast = Toast.makeText(v.getContext(), R.string.report_saved, Toast.LENGTH_SHORT);
        toast.show();
        for (Machine mc: Machine.machineList
             ) {
            if(mc.getMachineId().equals(bun.getString("name"))){
                mc.setMachineStatus("Online");
            }
        }
        FragmentManager fragManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        AlertListFragment machineListFragment = new AlertListFragment();
        MachineNumbersFragment machineNumbersFragment = new MachineNumbersFragment();
        StaffListFragment staffListFragment = new StaffListFragment();
        fragmentTransaction.replace(R.id.fragment_container2, staffListFragment);
        fragmentTransaction.replace(R.id.machine_numbers_container, machineNumbersFragment);
        fragmentTransaction.replace(R.id.fragment_container_alerts, machineListFragment);
        fragmentTransaction.commit();

    }

}
