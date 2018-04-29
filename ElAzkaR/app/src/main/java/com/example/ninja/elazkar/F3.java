package com.example.ninja.elazkar;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class F3 extends Fragment {

    TextView txtmorclock, morclck;
    private TimePicker picker1;
    private int hour , min;
    TextView txtevenclock, evenclck;
    private TimePicker picker2;
    private int hour2 , min2;
    public F3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_f3, container, false);
        txtmorclock = v.findViewById(R.id.txtmorclck);
        morclck=v.findViewById(R.id.morclck);
        txtevenclock = v.findViewById(R.id.txtevenclck);
        evenclck=v.findViewById(R.id.evenclck);
        morclck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMorClokDialog();
            }
        });
        evenclck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEvenClokDialog();
            }
        });

        return v;
    }

    private void showEvenClokDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("ضبط وقت التذكير المسائى");
        builder.setView(R.layout.evenclockdialog);

        builder.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                hour2 = picker2.getCurrentHour();
                min2 = picker2.getCurrentMinute();
                AlarmEvenTime(hour,min);
                String AM_PM2 ;
                if(hour2 < 12) {
                    AM_PM2 = "AM";
                } else {
                    hour2 = hour2-12;
                    AM_PM2 = "PM";
                }
                evenclck.setText(hour2+":"+min2+" "+AM_PM2);
            }
        });
        builder.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog2 = builder.show();
        picker2 = alertDialog2.findViewById(R.id.timePicker2);
    }

    private void showMorClokDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("ضبط وقت التذكير الصباحى");
        builder.setView(R.layout.morclockdialog);

        builder.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                hour = picker1.getCurrentHour();
                min = picker1.getCurrentMinute();
                AlarmMorningTime(hour,min);
                String AM_PM ;
                if(hour < 12) {
                    AM_PM = "AM";
                } else {
                    hour = hour-12;
                    AM_PM = "PM";
                }
                morclck.setText(hour+":"+min+" "+AM_PM);
            }
        });
        builder.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.show();
        picker1 = alertDialog.findViewById(R.id.timePicker1);
    }
    //Testing data Modified Morning Alaram
    public void AlarmMorningTime(int currentHour , int currentMin){
        long trigger = (currentHour * currentMin * 1000);
        Intent intent = new Intent(getActivity(),AlarmActivity.class);
        PendingIntent pin = PendingIntent.getActivity(getActivity(),101,intent,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager mngr = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        mngr.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+trigger,trigger,pin);
    }
    public void AlarmEvenTime(int currentHour , int currentMin){
        long trigger = (currentHour * currentMin * 1000);
        Intent intent = new Intent(getActivity(),AlarmActivity.class);
        PendingIntent pin = PendingIntent.getActivity(getActivity(),102,intent,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager mngr = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        mngr.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+trigger,trigger,pin);
    }

}
