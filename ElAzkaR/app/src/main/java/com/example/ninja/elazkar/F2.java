package com.example.ninja.elazkar;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class F2 extends Fragment {
    private PendingIntent pendingIntent;
    Switch aSwitch;
    private View v;
    Spinner spinner;
    int interval = 0;

    public F2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v =  inflater.inflate(R.layout.fragment_f2, container, false);

      aSwitch = v.findViewById(R.id.switch1);
        spinner = v.findViewById(R.id.spinner1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              if (b==true){
                  interval = 60 * 60 * 1000;
                  //Start Service
                  start(interval);
                  Intent alarmIntent = new Intent(getActivity(), AlarmReceiver.class);
                  pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, 0);
              }else{
                  //Stop Service
                  cancel();
              }
          }
      });
        String arrayStr[]={"1 hour","6 hour","12 hour","18 hour","24 hour"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,arrayStr);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String index = (String) adapterView.getItemAtPosition(i);
                switch (index){

                    case "1 hour":interval=60*60*1000;start(interval);break;
                    case "6 hour":interval=60*60*1000;start(interval);break;
                    case "12 hour":interval=60*60*1000;start(interval);break;
                    case "18 hour":interval=60*60*1000;start(interval);break;
                    case "24 hour":interval=60*60*1000;start(interval);break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
      return v;
    }

//    public void setUpToast() {
//        //Creating the LayoutInflater instance
//        //Creating the LayoutInflater instance
//        LayoutInflater li = getLayoutInflater();
//        //Getting the View object as defined in the customtoast.xml file
//        View layout = li.inflate(R.layout.custom_row,
//                (ViewGroup)getActivity().findViewById(R.id.cust));
//        TextView tv = layout.findViewById(R.id.tvcust);
//        String arr[] = getResources().getStringArray(R.array.mor_quotes);
//        Random r = new Random();
//        int num = r.nextInt(arr.length-1);
//        //Creating the Toast object
//        tv.setText(arr[num]);
//        Toast toast = new Toast(getActivity());
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toast.setView(layout);//setting the view of custom toast layout
//
//        toast.show();
////        Toast.makeText(getActivity(),"ok",Toast.LENGTH_SHORT).show();
//    }
    public void start(int interval) {
        AlarmManager manager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
    }

    public void cancel() {
        AlarmManager manager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);

    }

}
