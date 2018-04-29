package com.example.ninja.elazkar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtherActivity extends Fragment {
    ArrayList<Pray> arrayList = new ArrayList<>();;
    RecyclerView recyclerView ;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public OtherActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v =inflater.inflate(R.layout.fragment_other, container, false);

        String day[]={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};

        TextView theday , theDate;


        theday = v.findViewById(R.id.day);
        theDate = v.findViewById(R.id.date);
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        theday.setText(day[today.weekDay]);
        theDate.setText(today.monthDay + " / "+(today.month+1)+" / "+today.year);

        recyclerView = v.findViewById(R.id.rec);
        String name_arr[]={"أذكار المنزل","أذكار الخلاء","أذكار النوم","أذكار المسجد","أذكار الاستيقاظ","أذكار الطعام والشراب","أذكار الآذان"};
        String header_arr[] = getResources().getStringArray(R.array.header_arr);
        for(int i=0;i<name_arr.length;i++){
            arrayList.add(new Pray(name_arr[i],header_arr[i]));
        }
        adapter = new recyclerPrayAdapter(getActivity(),arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
