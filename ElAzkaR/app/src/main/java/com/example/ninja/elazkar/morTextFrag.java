package com.example.ninja.elazkar;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class morTextFrag extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener{
    int index = 0 ;
    private TextView mor_quotes_tv , mor_price_tv;
    Button button;
    SeekBar seekBar;
    private String[] mor_quotes_arr;
    private String[] mor_price_arr;
    ArrayList<String>fav_list;
    private int[] mor_nums_arr;
    MediaPlayer mediaPlayer;
    private Handler mSeekbarUpdateHandler;
    private Runnable mUpdateSeekbar;

    public morTextFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mediaPlayer = MediaPlayer.create(getActivity(),R.raw.mahr);

        mSeekbarUpdateHandler = new Handler();
        mUpdateSeekbar = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                mSeekbarUpdateHandler.postDelayed(this, 50);
            }
        };
        View v= inflater.inflate(R.layout.fragment_mor_text, container, false);

        BottomNavigationView navigation = (BottomNavigationView) v.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        mor_quotes_tv = v.findViewById(R.id.mor_quotes);
        mor_price_tv = v.findViewById(R.id.mor_price);

        button = v.findViewById(R.id.button);

        mor_quotes_arr = getResources().getStringArray(R.array.mor_quotes);
        mor_price_arr = getResources().getStringArray(R.array.mor_price);
        mor_nums_arr=getResources().getIntArray(R.array.mor_nums);
        fav_list = new ArrayList<>();

        mor_quotes_tv.setText(mor_quotes_arr[index]);
        mor_price_tv.setText(mor_price_arr[index]);
        button.setText(mor_nums_arr[index]+"");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                int txtCount = Integer.parseInt(b.getText().toString());
                if (txtCount!=0){
                    b.setText(txtCount-1+"");
                }else{
                    txtCount=0;
                    b.setText(txtCount+"");
                    next();
                }

            }
        });



        return v;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_prev:prev();return true;

            case R.id.navigation_gifts:
                        favList();
                return true;
            case R.id.nav_next:next();return true;
            case R.id.sound:

                myCustomDialog();return true;
        }
        return false;
    }

    private void favList() {

        String fav_str = mor_quotes_tv.getText().toString();
        if (fav_list.contains(fav_str)){
            Toast.makeText(getActivity(),"already exist in favourite list",Toast.LENGTH_SHORT).show();
        }else {
            fav_list.add(fav_str);
            MainActivity mainActivity =(MainActivity) getActivity();
            mainActivity.selecteditem(fav_str);
        }



    }


    private void myCustomDialog() {
        ImageView iv1,iv2,iv3,iv4,iv5;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setView(R.layout.snd_lay);
            AlertDialog alertDialog = builder.show();
            iv1=alertDialog.findViewById(R.id.imageView1);
            iv2=alertDialog.findViewById(R.id.imageView2);
            iv3=alertDialog.findViewById(R.id.imageView3);
            iv4=alertDialog.findViewById(R.id.imageView4);
            iv5=alertDialog.findViewById(R.id.imageView5);
            seekBar = alertDialog.findViewById(R.id.seekBar);
            seekBar.setMax(mediaPlayer.getDuration());
            iv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar, 0);
                }
            });
            iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mediaPlayer.stop();
                    mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);

                }
            });

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if (b)
                        mediaPlayer.seekTo(i);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });




    }
    }



    private void next() {

        ++index;
        if (index>=mor_quotes_arr.length){
            index=mor_quotes_arr.length-1;
        }
        mor_quotes_tv.setText(mor_quotes_arr[index]);
        mor_price_tv.setText(mor_price_arr[index]);
        button.setText(mor_nums_arr[index]+"");
    }

    private void prev() {
        --index;
        if (index<=0){
            index=0;
        }
        mor_quotes_tv.setText(mor_quotes_arr[index]);
        mor_price_tv.setText(mor_price_arr[index]);
        button.setText(mor_nums_arr[index]+"");
    }
    public interface Callback{
        public void selecteditem(String mylist);
    }

    }
