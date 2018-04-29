package com.example.ninja.elazkar;


import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class nightTextFrag extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {
    int index = 0;
    private TextView mor_quotes_tv, mor_price_tv;
    Button button;
    SeekBar seekBar;
    private String[] mor_quotes_arr;
    private String[] mor_price_arr;
    private int[] mor_nums_arr;
    MediaPlayer mediaPlayer;

    public nightTextFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_night_text, container, false);

        BottomNavigationView navigation = (BottomNavigationView) v.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        mor_quotes_tv = v.findViewById(R.id.mor_quotes);
        mor_price_tv = v.findViewById(R.id.mor_price);
        button = v.findViewById(R.id.button);

        mor_quotes_arr = getResources().getStringArray(R.array.even_quotes);
        mor_price_arr = getResources().getStringArray(R.array.even_price);
        mor_nums_arr = getResources().getIntArray(R.array.even_nums);


        mor_quotes_tv.setText(mor_quotes_arr[index]);
        mor_price_tv.setText(mor_price_arr[index]);
        button.setText(mor_nums_arr[index] + "");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                int txtCount = Integer.parseInt(b.getText().toString());
                if (txtCount != 0) {
                    b.setText(txtCount - 1 + "");
                } else {
                    txtCount = 0;
                    b.setText(txtCount + "");
                    next();
                }

            }
        });


        return v;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_prev:
                prev();
                return true;

            case R.id.navigation_gifts:

                return true;
            case R.id.nav_next:
                next();
                return true;
            case R.id.sound:

                myCustomDialog();
                return true;
        }
        return false;
    }


    private void myCustomDialog() {
        ImageView iv1, iv2, iv3, iv4, iv5;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setView(R.layout.snd_lay);
            mediaPlayer = MediaPlayer.create(getActivity(),R.raw.mahr);
            AlertDialog alertDialog = builder.show();

            iv1 = alertDialog.findViewById(R.id.imageView1);
            iv2 = alertDialog.findViewById(R.id.imageView2);
            iv3 = alertDialog.findViewById(R.id.imageView3);
            iv4 = alertDialog.findViewById(R.id.imageView4);
            iv5 = alertDialog.findViewById(R.id.imageView5);
            seekBar = alertDialog.findViewById(R.id.seekBar);
            iv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                }
            });
        }


    }

    private void next() {

        ++index;
        if (index >= mor_quotes_arr.length) {
            index = mor_quotes_arr.length - 1;
        }
        mor_quotes_tv.setText(mor_quotes_arr[index]);
        mor_price_tv.setText(mor_price_arr[index]);
        button.setText(mor_nums_arr[index] + "");
    }

    private void prev() {
        --index;
        if (index <= 0) {
            index = 0;
        }
        mor_quotes_tv.setText(mor_quotes_arr[index]);
        mor_price_tv.setText(mor_price_arr[index]);
        button.setText(mor_nums_arr[index] + "");
    }
}
