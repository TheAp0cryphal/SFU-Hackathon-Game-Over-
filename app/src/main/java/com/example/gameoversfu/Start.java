package com.example.gameoversfu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class Start extends AppCompatActivity {
    Layout coordinate = new Layout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);
        coordinate=Layout.getInstance();

        HomeWatcher mHomeWatcher;

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override

            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }


        });
        mHomeWatcher.startWatch();
        begin();
    }

    private void begin()
    {

        Button btn1 = findViewById(R.id.north);
        Button btn2 = findViewById(R.id.south);
        Button btn3 = findViewById(R.id.west);
        Button btn4 = findViewById(R.id.east);

        ImageView character=findViewById(R.id.character);
        final ImageView object=findViewById(R.id.object);
        character.setImageResource(R.drawable.character);
        String s2 = coordinate.getString(coordinate.i,coordinate.j);
        TextView textView = findViewById(R.id.textView);
        textView.setText(s2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(coordinate.go_north()) {
                    if(coordinate.i==4){
                        if(coordinate.j==1)
                            object.setImageResource(R.drawable.bear);
                        if(coordinate.j==4)
                            object.setImageResource(R.drawable.id);
                    }
                    if(coordinate.i==1){
                        if(coordinate.j==2){
                            object.setImageResource(R.drawable.pondds);
                        }
                    }
                    if(coordinate.i==2){
                        if(coordinate.j==2)
                            object.setImageResource(R.drawable.bin);
                        if(coordinate.j==4)
                            object.setImageResource(R.drawable.assignment);
                    }

                    setString();


            }
                else
                {
                    String s = "Cannot go further into the forest, Are you Crazy?!";
                    Toast.makeText(Start.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coordinate.go_south()) {

                        if(coordinate.i==4){
                            if(coordinate.j==1)
                                object.setImageResource(R.drawable.bear);
                            if(coordinate.j==4)
                                object.setImageResource(R.drawable.id);
                        }
                        if(coordinate.i==1){
                            if(coordinate.j==2){
                                object.setImageResource(R.drawable.pondds);
                            }
                        }
                        if(coordinate.i==2){
                            if(coordinate.j==2)
                                object.setImageResource(R.drawable.bin);
                            if(coordinate.j==4)
                                object.setImageResource(R.drawable.assignment);
                        }

                        setString();


                }
                else
                {
                    String s = "Cannot go further into the forest, Are you Crazy?!";
                    Toast.makeText(Start.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coordinate.go_west()) {

                    if(coordinate.i==4){
                        if(coordinate.j==1)
                            object.setImageResource(R.drawable.bear);
                        if(coordinate.j==4)
                            object.setImageResource(R.drawable.id);
                    }
                    if(coordinate.i==1){
                        if(coordinate.j==2){
                            object.setImageResource(R.drawable.pondds);
                        }
                    }
                    if(coordinate.i==2){
                        if(coordinate.j==2)
                            object.setImageResource(R.drawable.bin);
                        if(coordinate.j==4)
                            object.setImageResource(R.drawable.assignment);
                    }
                    setString();


                }
                else
                {
                    String s = "Cannot go further into the forest, Are you Crazy?!";
                    Toast.makeText(Start.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coordinate.go_east()) {
                    if(coordinate.i==4){
                        if(coordinate.j==1)
                            object.setImageResource(R.drawable.bear);
                        if(coordinate.j==4)
                            object.setImageResource(R.drawable.id);
                    }
                    if(coordinate.i==1){
                        if(coordinate.j==2){
                            object.setImageResource(R.drawable.pondds);
                        }
                    }
                    if(coordinate.i==2){
                        if(coordinate.j==2)
                            object.setImageResource(R.drawable.bin);
                        if(coordinate.j==4)
                            object.setImageResource(R.drawable.assignment);
                    }
                    setString();


                }
                else
                {
                    String s = "Cannot go further into the forest, Are you Crazy?!";
                    Toast.makeText(Start.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });



    }



















    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }
    protected void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);

    }

    public void setString()
    {

        String s2 = coordinate.getString(coordinate.i,coordinate.j);
        if(coordinate.i == 2 && coordinate.j ==2) {
            String op1 = "Throw the food in the compost bin and leave, screw Nellie!";
            String cons1 = "You die: Nellie is a racoon goddess and kills you";
            String op2 = "Hover the food over the bin so Nellie smells it and then throw it in the compost";
            String cons2 = "You survive: Nellie eats well and the trash is recycled.";
            String op3 = "Throw it in the mixed-paper, screw recycling, the racoon is hungry";
            String cons3 = "You die: Climate change happens, heat exhaustion kills you";
            String op4 = "Throw the food in the compost bin, grab Nellie and throw her in the bin as well";
            String cons4 = "You die: Nellie attacks you and you get rabies";
            TextView textView = findViewById(R.id.north);
            textView.setText(op1);
            TextView textView2 = findViewById(R.id.south);
            textView2.setText(op2);
            TextView textView3 = findViewById(R.id.east);
            textView3.setText(op3);
            TextView textView4 = findViewById(R.id.west);
            textView4.setText(op4);



        }
        else if ((coordinate.i == 4 && coordinate.j ==1))
        {
            String op1 = "You run as fast as you can back the way you came.";
            String cons1 = "You die: Bears are faster, you get mauled.";
            String op2 = "You pick a rock and attack the bear";
            String cons2 = "You die: Bears are stronger, you get mauled.";
            String op3 = "You are so afraid, you freeze from the terror, and scream as loud as you can for help";
            String cons3 = "You die: The bear was clearly enraged and hungry, you get mauled.";
            String op4 = "You slowly start inching backwards, and are a paragon of calm";
            String cons4 = "You survive: You were cool and collected, you escaped with your life.";
            TextView textView = findViewById(R.id.north);
            textView.setText(op1);
            TextView textView2 = findViewById(R.id.south);
            textView2.setText(op2);
            TextView textView3 = findViewById(R.id.east);
            textView3.setText(op3);
            TextView textView4 = findViewById(R.id.west);
            textView4.setText(op4);
        }
        else if (coordinate.i == 4 && coordinate.j ==4)
        {
            String op1 = "You stare at the construction, its fascinating watching people work on something that will never be accomplished.";
            String cons1 = "You die: Construction equipment falls on you and you die.";
            String op2 = "You are an organized, determined student, the one of a kind, you head straight to the ID place and get you ID.";
            String cons2 = "You survive: you get you ID and leave successfully.";
            String op3 = "You decide to get, food you are hungry!";
            String cons3 = "You die: You eat meat, a bone gets stuck in your throat, you suffocate.";
            String op4 = "Oh wow, the bookstore has many hoodies and textbooks, you overspend on hoodies you know are extremely overpriced and spend so much money on textbooks, yet just end up getting two.";
            String cons4 = "You die: Education is a business, you overspend and your family became poor, they could no longer afford your education and without a degree and a job, you starve to death.";
            TextView textView = findViewById(R.id.north);
            textView.setText(op1);
            TextView textView2 = findViewById(R.id.south);
            textView2.setText(op2);
            TextView textView3 = findViewById(R.id.east);
            textView3.setText(op3);
            TextView textView4 = findViewById(R.id.west);
            textView4.setText(op4);
        }
        else if (coordinate.i == 1 && coordinate.j ==2)
        {
            String op1 = "You go close to the water to get a better “feel” of it";
            String cons1 = "You die: you fall in and drown.";
            String op2 = "Fishes!!! You want to feed them, and so you do";
            String cons2 = "You die: The fish think you are food and take you down, you are eaten.";
            String op3 = "You were here to enjoy the view, there are some benches nearby, you could just kick back and relax.";
            String cons3 = "You die: you fall asleep and a flash snow storm freezes you over. Too bad the buses couldn’t come up!";
            String op4 = "You’ve seen the view, and enjoyed the breeze, let’s leave the pond and go somewhere else.";
            String cons4 = "You survive: your amazing time management skills saved you before you died.";
            TextView textView = findViewById(R.id.north);
            textView.setText(op1);
            TextView textView2 = findViewById(R.id.south);
            textView2.setText(op2);
            TextView textView3 = findViewById(R.id.east);
            textView3.setText(op3);
            TextView textView4 = findViewById(R.id.west);
            textView4.setText(op4);

        }
        else if(coordinate.i == 2 && coordinate.j ==4)
        {
            String op1 = "You lie and tell you have done the assignment.";
            String cons1 = "You die: liar, liar pants on fire, you burn to death.";
            String op2 = "You tell him the truth about the incomplete assignment.";
            String cons2 = "You survive: your honesty is rewarded with an extension.";
            String op3 = "You do not talk about the assignment, you can quickly finish it and ask for an extension.";
            String cons3 = "You die: assignments make you feel overloaded, you die from sheer pressure.";
            String op4 = "You ask him for more marks, you really want an A.";
            String cons4 = "You die: Professors are busy people, you wasted time and so your time got wasted, time is money, you got poor and starved.";
            TextView textView = findViewById(R.id.north);
            textView.setText(op1);
            TextView textView2 = findViewById(R.id.south);
            textView2.setText(op2);
            TextView textView3 = findViewById(R.id.east);
            textView3.setText(op3);
            TextView textView4 = findViewById(R.id.west);
            textView4.setText(op4);
        }
        else
        {
            String op1 = "North";
            String cons1 = "You die: liar, liar pants on fire, you burn to death.";
            String op2 = "South";
            String cons2 = "You survive: your honesty is rewarded with an extension.";
            String op3 = "East";
            String cons3 = "You die: assignments make you feel overloaded, you die from sheer pressure.";
            String op4 = "West";
            String cons4 = "You die: Professors are busy people, you wasted time and so your time got wasted, time is money, you got poor and starved.";
            TextView textView = findViewById(R.id.north);
            textView.setText(op1);
            TextView textView2 = findViewById(R.id.south);
            textView2.setText(op2);
            TextView textView3 = findViewById(R.id.east);
            textView3.setText(op3);
            TextView textView4 = findViewById(R.id.west);
            textView4.setText(op4);
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(s2);
    }
}








