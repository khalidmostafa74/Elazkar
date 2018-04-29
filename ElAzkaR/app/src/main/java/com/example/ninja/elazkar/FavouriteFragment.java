package com.example.ninja.elazkar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {
    ArrayList<String> arrayList = new ArrayList<>();
    TextView tv ;
    String str="";
    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_favourite, container, false);
        tv = v.findViewById(R.id.favtxt);
        String strtext = getArguments().getString("item");
        arrayList.add(strtext);
        for (int i=0;i<arrayList.size();i++){
            str += arrayList.get(i);
        }
        tv.setText(str);

        return v;
    }
    public static FavouriteFragment getInstance(String item){
        FavouriteFragment fav = new FavouriteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("item",item);
        fav.setArguments(bundle);
        return fav;
    }


}
