package com.example.ninja.elazkar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , morTextFrag.Callback{

    String stritem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new OtherActivity()).commit();
//        startAM();


//        setUpMorningAlarm();
//        final Button findMagicBtn = (Button) findViewById(R.id.but2);
//        findMagicBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_right, 0);
//        findMagicBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LinearLayout findMagicLl = (LinearLayout) findViewById(R.id.lin);
//                if (findMagicLl.getVisibility() == View.VISIBLE) {
//                    ScaleAnimation animation = new ScaleAnimation(1f, 1f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
//                    animation.setDuration(180);
//                    animation.setFillAfter(true);
//                    findMagicLl.startAnimation(animation);
//                    findMagicLl.setVisibility(View.GONE);
//                    findMagicBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_right, 0);
//                } else {
//                    ScaleAnimation animation = new ScaleAnimation(1f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
//                    animation.setDuration(180);
//                    animation.setFillAfter(true);
//                    findMagicLl.startAnimation(animation);
//                    findMagicLl.setVisibility(View.VISIBLE);
//                    findMagicBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_down, 0);
//                }
//            }
//        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


//    private void setUpMorningAlarm() {
//        // Set the alarm to start at 5:30 a.m.
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTimeInMillis(System.currentTimeMillis());
////        calendar.set(Calendar.HOUR_OF_DAY, 5);
////        calendar.set(Calendar.MINUTE, 30);
////        AlarmManager alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
////        Intent intent = new Intent(MainActivity.this,AlarmActivity.class);
////        PendingIntent alarmIntent = PendingIntent.getActivity(MainActivity.this,101,intent,PendingIntent.FLAG_UPDATE_CURRENT);
////
////// setRepeating() lets you specify a precise custom interval--in this case,
////// 20 minutes.
////        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
////                1000 * 60 * 20, alarmIntent);
////        Calendar cal = Calendar.getInstance();
////        cal.add(Calendar.SECOND, 5);
////
////        //Create a new PendingIntent and add it to the AlarmManager
////        Intent intent = new Intent(this, AlarmActivity.class);
////        PendingIntent pendingIntent = PendingIntent.getActivity(this,
////                12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
////        AlarmManager am =
////                (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
////        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
////                pendingIntent);
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fm = getSupportFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fm.beginTransaction().replace(R.id.container,new morTextFrag()).commit();
        } else if (id == R.id.nav_gallery) {
            fm.beginTransaction().replace(R.id.container,new nightTextFrag()).commit();
        } else if (id == R.id.nav_slideshow) {
            fm.beginTransaction().replace(R.id.container,new OtherActivity()).commit();

        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Azkar");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Azkar App link");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.nav_send) {
            Intent i = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_about) {
            aboutDialog();
        }else if (id==R.id.nav_fav){
            fm.beginTransaction().replace(R.id.container,FavouriteFragment.getInstance(stritem)).commit();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void aboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("عن التطبيق");
        builder.setMessage("{وَالذَّاكِرِينَ اللَّهَ كَثِيرًا وَالذَّاكِرَاتِ أَعَدَّ اللَّهُ لَهُم مَّغْفِرَةً وَأَجْرًا عَظِيمًا}"+"\n"+"{الَّذِينَ آمَنُوا وَتَطْمَئِنُّ قُلُوبُهُم بِذِكْرِ اللَّهِ ۗ أَلَا بِذِكْرِ اللَّهِ تَطْمَئِنُّ الْقُلُوبُ} "+"\n"+"تمت برمجة التطبيق بواسطة khalidmostafa48@gmail.com");
        builder.setNegativeButton("إغلاق", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

    private void shareDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("مشاركه بواسطة")
                .setView(R.layout.share_lay);
        builder.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("إغلاق", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alert = builder.show();
    }

    public void startAM() {
        Intent alarmIntent = new Intent(this,
                AlarmActivity.class);
       PendingIntent pendingIntent = PendingIntent.getActivity(this,11,alarmIntent,0);

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int h = 5 ;
        int m = 30;
// Set the alarm to start at 10:00 AM
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY,h);
        calendar.set(Calendar.MINUTE,m);
        calendar.set(Calendar.SECOND, 0);




        manager.setRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), 86400000, // for repeating in every 24 hours
                pendingIntent);
    }


    @Override
    public void selecteditem(String mylist) {
        this.stritem = mylist;
    }
}
