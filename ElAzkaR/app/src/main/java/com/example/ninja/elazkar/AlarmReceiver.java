package com.example.ninja.elazkar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by ninja on 22/02/2018.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String arr[] = context.getResources().getStringArray(R.array.mor_quotes);
        Random r = new Random();
        int num = r.nextInt(arr.length-1);

        View layout = LayoutInflater.from(context).inflate(R.layout.custom_row, null);
        TextView text = (TextView) layout.findViewById(R.id.tvcust);
        text.setText(arr[num]);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
//        Toast.makeText(context,arr[num],Toast.LENGTH_SHORT).show();
    }

}
