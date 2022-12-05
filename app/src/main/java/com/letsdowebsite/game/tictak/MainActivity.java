package com.letsdowebsite.game.tictak;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context  context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        setTitle( R.string.app_name );
        TextView b1 = (TextView) findViewById( R.id.start_game );
        TextView b2 = (TextView) findViewById( R.id.quit );
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        } );
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Game.class );
                startActivity( intent );
            }
        } );
        getNofication( MainActivity.this);
    }


        public static Notification getNofication(Context context) {
            NotificationChannel channel = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel = new NotificationChannel("Ticktok", "ticktok", NotificationManager.IMPORTANCE_DEFAULT);
            }

            NotificationManager notificationManager = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                notificationManager = context.getSystemService(NotificationManager.class);
            }
            assert notificationManager != null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(channel);
            }


            NotificationCompat.Builder builder
                    = new NotificationCompat.Builder(context, "Well to tik tok game")

                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .setAutoCancel(false);

            Notification notification = builder.build();
            notification.flags = Notification.FLAG_FOREGROUND_SERVICE | Notification.FLAG_AUTO_CANCEL;

            return notification;


        }
    }



