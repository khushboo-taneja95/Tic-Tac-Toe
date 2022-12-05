package com.letsdowebsite.game.tictak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.letsdowebsite.game.tictak.R.string.lost;
import static com.letsdowebsite.game.tictak.R.string.won;

public class Game extends AppCompatActivity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private int win,lose,draw;
    private char grid[][]=new char[3][3];
    private int firstGame =1;
    boolean firstMove;
    private TextView tw,td,tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.v("onCreate()(Game.java)","inside onCreate");
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;*/

        setTitle("Lets Play!!");
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]='e';

        win=lose=draw=0;
        firstMove =true;
        tw=(TextView)findViewById(R.id.wincount);
        td=(TextView)findViewById(R.id.drawcount);
        tl=(TextView)findViewById(R.id.losscount);

        Button b1 = (Button) findViewById(R.id.new_game);
        Button b2 = (Button) findViewById(R.id.end_game);
        t1=(TextView)findViewById(R.id.one);
        t2=(TextView)findViewById(R.id.two);
        t3=(TextView)findViewById(R.id.three);
        t4=(TextView)findViewById(R.id.four);
        t5=(TextView)findViewById(R.id.five);
        t6=(TextView)findViewById(R.id.six);
        t7=(TextView)findViewById(R.id.seven);
        t8=(TextView)findViewById(R.id.eight);
        t9=(TextView)findViewById(R.id.nine);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
                Random random=new Random();
                int val=random.nextInt(100);
                if(val<50){
                    //nextMove();
                    Toast.makeText(Game.this,"Computer Moves first!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Game.this,"Your Move first!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game.this,MainActivity.class));
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t5.getText().toString().compareTo("O");
            int q= t5.getText().toString().compareTo("X");
            Log.e("onClickFive()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t5.setText("X");
                grid[1][1]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickFive","calling nextMove()");
                nextMove();
            }
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t1.getText().toString().compareTo("O");
            int q= t1.getText().toString().compareTo("X");
            Log.e("onClickOne()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t1.setText("X");
                grid[0][0]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickOne","calling nextMove()");
                nextMove();
            }
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t2.getText().toString().compareTo("O");
            int q= t2.getText().toString().compareTo("X");
            Log.e("onClickTwo()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t2.setText("X");
                grid[0][1]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickTwo","calling nextMove()");
                nextMove();
            }
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t3.getText().toString().compareTo("O");
            int q= t3.getText().toString().compareTo("X");
            Log.e("onClickThree()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t3.setText("X");
                grid[0][2]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickThree","calling nextMove()");
                nextMove();
            }
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t4.getText().toString().compareTo("O");
            int q= t4.getText().toString().compareTo("X");
            Log.e("onClickFour()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t4.setText("X");
                grid[1][0]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickFour","calling nextMove()");
                nextMove();
            }
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t6.getText().toString().compareTo("O");
            int q= t6.getText().toString().compareTo("X");
            Log.e("onClickSix()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t6.setText("X");
                grid[1][2]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickSix","calling nextMove()");
                nextMove();
            }
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t7.getText().toString().compareTo("O");
            int q= t7.getText().toString().compareTo("X");
            Log.e("onClickSeven()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t7.setText("X");
                grid[2][0]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickSeven","calling nextMove()");
                nextMove();
            }
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t8.getText().toString().compareTo("O");
            int q= t8.getText().toString().compareTo("X");
            Log.e("onClickEight()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t8.setText("X");
                grid[2][1]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickEight","calling nextMove()");
                nextMove();
            }
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int p=t9.getText().toString().compareTo("O");
            int q= t9.getText().toString().compareTo("X");
            Log.e("onClickNine()","p: "+p+" q: "+q);
            if(p!=0 && q!=0)
            {
                t9.setText("X");
                grid[2][2]='x';
                if(result()) {
                    return;
                }
                Log.v("onClickNine","calling nextMove()");
                nextMove();
            }
            }
        });
        if(firstGame==1)
        {
            Log.v("onCreate() firstGame","firstGame: "+firstGame);
            firstGame++;
            Random random=new Random();
            int val=random.nextInt(100);
            Log.v("onCreate()","random value: "+String.valueOf(val));
            if(val<50){
                Log.v("onCreate()firstGameIf","calling nextMove()");
                nextMove();
                Toast.makeText(this,"Computer Moves first!!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"You Moves first!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean result()
    {
        //x is player and o is computer
        //Log.v("result()","inside result() chk mech");
        if(grid[0][0]=='x' && grid[0][1]=='x' &&grid[0][2]=='x')   //player win row 1
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            Log.v("result()","player won");
            String str=String.valueOf(win);
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][0]=='o' &&grid[0][1]=='o'&&grid[0][2]=='o') // comp win row 1
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][0]=='o' &&grid[1][0]=='o'&&grid[2][0]=='o') //comp win column 1
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][0]=='x' &&grid[1][0]=='x'&&grid[2][0]=='x') // player win column 1
        {
            win++;
            Log.v("result()","player won");
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[1][0]=='x' &&grid[1][1]=='x'&&grid[1][2]=='x') //player win row 2
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);
            Log.v("result()","player won");
            refresh();
            return true;
        }
        else if(grid[0][1]=='x' &&grid[1][1]=='x'&&grid[2][1]=='x') //player win column 2
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            Log.v("result()","player won");
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[1][0]=='o' &&grid[1][1]=='o'&&grid[1][2]=='o') // comp win row 2
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            Log.v("result()","computer won");
            String str=String.valueOf(lose);
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][1]=='o' &&grid[1][1]=='o'&&grid[2][1]=='o') //comp win column 2
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[2][0]=='x' &&grid[2][1]=='x'&&grid[2][2]=='x') //player win row 3
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            Log.v("result()","player won");
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][2]=='x' &&grid[1][2]=='x'&&grid[2][2]=='x') //player win column 3
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            Log.v("result()","player won");
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[2][0]=='o' &&grid[2][1]=='o'&&grid[2][2]=='o') //comp win row 3
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][2]=='o' &&grid[1][2]=='o'&&grid[2][2]=='o') // comp win column 3
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][0]=='x' &&grid[1][1]=='x'&&grid[2][2]=='x') //player win diag 1
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            Log.v("result()","player won");
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[2][0]=='x' &&grid[1][1]=='x'&&grid[0][2]=='x') //player win diag 2
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            Log.v("result()","player won");
            tw.setText(str);
            refresh();
            return true;
        }
        else if(grid[0][0]=='o' &&grid[1][1]=='o'&&grid[2][2]=='o') //comp win diag 1
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else if(grid[2][0]=='o' &&grid[1][1]=='o'&&grid[0][2]=='o') //comp win diag 2
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            Log.v("result()","computer won");
            tl.setText(str);
            refresh();
            return true;
        }
        else {
            int flag = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == 'e') {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1)
                    break;
            }
            if (flag == 0) {
                Log.v("result()","calling drawProtocol() from result() function");
                drawProtocol();
                return true;
            }
        }
        return false;
    }

    private boolean defensive()  // return false when no defensive move possible else true
    {
        //Log.v("defensive()","inside defensive mve()");
        if(grid[0][0]=='x' && grid[0][1]=='x' &&grid[0][2]=='e')
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='x' &&grid[0][1]=='e'&&grid[0][2]=='x')
        {
            grid[0][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[0][1]=='x'&&grid[0][2]=='x')
        {
            grid[0][0]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][0]=='x'&&grid[2][0]=='e')
        {
            grid[2][0]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][0]=='e'&&grid[2][0]=='x')
        {
            grid[1][0]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][0]=='x'&&grid[2][0]=='x')
        {
            grid[0][0]='o';
        }
        else if(grid[1][0]=='x' &&grid[1][1]=='x'&&grid[1][2]=='e')
        {
            grid[1][2]='o';
        }
        else if(grid[1][0]=='x' &&grid[1][1]=='e'&&grid[1][2]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[1][0]=='e' &&grid[1][1]=='x'&&grid[1][2]=='x')
        {
            grid[1][0]='o';
        }
        else if(grid[0][1]=='x' &&grid[1][1]=='x'&&grid[2][1]=='e')
        {
            grid[2][1]='o';
        }
        else if(grid[0][1]=='x' &&grid[1][1]=='e'&&grid[2][1]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[0][1]=='e' &&grid[1][1]=='x'&&grid[2][1]=='x')
        {
            grid[0][1]='o';
        }
        else if(grid[2][0]=='x' &&grid[2][1]=='x'&&grid[2][2]=='e')
        {
            grid[2][2]='o';
        }
        else if(grid[2][0]=='x' &&grid[2][1]=='e'&&grid[2][2]=='x')
        {
            grid[2][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[2][1]=='x'&&grid[2][2]=='x')
        {
            grid[2][0]='o';
        }
        else if(grid[0][2]=='x' &&grid[1][2]=='x'&&grid[2][2]=='e')
        {
            grid[2][2]='o';
        }
        else if(grid[0][2]=='x' &&grid[1][2]=='e'&&grid[2][2]=='x')
        {
            grid[1][2]='o';
        }
        else if(grid[0][2]=='e' &&grid[1][2]=='x'&&grid[2][2]=='x')
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][1]=='x'&&grid[2][2]=='e')
        {
            grid[2][2]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][1]=='e'&&grid[2][2]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][1]=='x'&&grid[2][2]=='x')
        {
            grid[0][0]='o';
        }
        else if(grid[2][0]=='x' &&grid[1][1]=='x'&&grid[0][2]=='e')
        {
            grid[0][2]='o';
        }
        else if(grid[2][0]=='x' &&grid[1][1]=='e'&&grid[0][2]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[1][1]=='x'&&grid[0][2]=='x')
        {
            grid[2][0]='o';
        }
        else
            return false;
        return true;
    }

    private boolean offensive()  // return true when no offesive move possible else false
    {
        //Log.v("offensive()","inside offensive mve()");
        if(grid[0][0]=='o' && grid[0][1]=='o' &&grid[0][2]=='e')  //row 1
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='o' &&grid[0][1]=='e'&&grid[0][2]=='o') // row 1
        {
            grid[0][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[0][1]=='o'&&grid[0][2]=='o') // row 1
        {
            grid[0][0]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][0]=='o'&&grid[2][0]=='e') //column 1
        {
            grid[2][0]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][0]=='e'&&grid[2][0]=='o')
        {
            grid[1][0]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][0]=='o'&&grid[2][0]=='o')
        {
            grid[0][0]='o';
        }
        else if(grid[1][0]=='o' &&grid[1][1]=='o'&&grid[1][2]=='e') //row 2
        {
            grid[1][2]='o';
        }
        else if(grid[1][0]=='o' &&grid[1][1]=='e'&&grid[1][2]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[1][0]=='e' &&grid[1][1]=='o'&&grid[1][2]=='o')
        {
            grid[1][0]='o';
        }
        else if(grid[0][1]=='o' &&grid[1][1]=='o'&&grid[2][1]=='e') //column 2
        {
            grid[2][1]='o';
        }
        else if(grid[0][1]=='o' &&grid[1][1]=='e'&&grid[2][1]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[0][1]=='e' &&grid[1][1]=='o'&&grid[2][1]=='o')
        {
            grid[0][1]='o';
        }
        else if(grid[2][0]=='o' &&grid[2][1]=='o'&&grid[2][2]=='e') // row 3
        {
            grid[2][2]='o';
        }
        else if(grid[2][0]=='o' &&grid[2][1]=='e'&&grid[2][2]=='o')
        {
            grid[2][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[2][1]=='o'&&grid[2][2]=='o')
        {
            grid[2][0]='o';
        }
        else if(grid[0][2]=='o' &&grid[1][2]=='o'&&grid[2][2]=='e') // column 3
        {
            grid[2][2]='o';
        }
        else if(grid[0][2]=='o' &&grid[1][2]=='e'&&grid[2][2]=='o')
        {
            grid[1][2]='o';
        }
        else if(grid[0][2]=='e' &&grid[1][2]=='o'&&grid[2][2]=='o')
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][1]=='o'&&grid[2][2]=='e') // diag 1
        {
            grid[2][2]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][1]=='e'&&grid[2][2]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][1]=='o'&&grid[2][2]=='o')
        {
            grid[0][0]='o';
        }
        else if(grid[2][0]=='o' &&grid[1][1]=='o'&&grid[0][2]=='e')  //diag 2
        {
            grid[0][2]='o';
        }
        else if(grid[2][0]=='o' &&grid[1][1]=='e'&&grid[0][2]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[1][1]=='o'&&grid[0][2]=='o')
        {
            grid[2][0]='o';
        }
        else
            return true;
        return false;
    }

    private void drawProtocol()
    {
        //Log.v("drawProtocol()","inside draw chk mech");
        draw++;
        Toast.makeText(this,R.string.ydraw,Toast.LENGTH_SHORT).show();
        String str=String.valueOf(draw);
        td.setText(str);
        refresh();
    }

    private void nextMove()
    {
        Log.v("nextMove()","inside next Computer mve()");
        Log.v("firstMove blk","firstMove: "+ firstMove);
        if(firstMove)
        {
            firstMove =false;
            Random r=new Random();
            int random=r.nextInt(100);
            //Log.v("firstMove blk","random: "+random);
            if(random<50 && grid[1][1]=='e')
            {
                grid[1][1]='o';
                //Log.v("firstMove blk","random<50");
            }
            else
            {
                if(random%5==0)
                {
                    if(grid[0][0]=='e')
                        grid[0][0]='o';
                }
                else if(random%5==1)
                {
                    if(grid[2][0]=='e')
                        grid[2][0]='o';
                }
                else if(random%5==2)
                {
                    if(grid[0][2]=='e')
                        grid[0][2]='o';
                }
                else if(random%5==3)
                {
                    if(grid[2][2]=='e')
                        grid[2][2]='o';
                }
                else
                {
                    if(random%4==0 && grid[1][0]=='e')
                        grid[1][0]='o';
                    else if(random%4==1 && grid[1][2]=='e')
                        grid[1][2]='o';
                    else if(random%4==2 && grid[0][1]=='e')
                        grid[0][1]='o';
                    else
                        grid[2][1]='o';
                }
            }
        }
        else
        {
            boolean doneoff=offensive();    // return true when no offensive move possible else false
            boolean donedef=false;
            if(doneoff)
                donedef=defensive();        // return false when no defensive move possible else true
            if(doneoff && !donedef)
            {
                if(grid[1][1]=='e')
                    grid[1][1]='o';
                else if(grid[2][0]=='e')
                {
                    grid[2][0]='o';
                }
                else if(grid[0][2]=='e')
                {
                    grid[0][2]='o';
                }
                else if(grid[2][2]=='e')
                {
                    grid[2][2]='o';
                }
                else if(grid[0][0]=='e')
                    grid[0][0]='o';
                else
                {
                    if(grid[1][0]=='e')
                        grid[1][0]='o';
                    else if(grid[1][2]=='e')
                        grid[1][2]='o';
                    else if(grid[0][1]=='e')
                        grid[0][1]='o';
                    else if(grid[2][1]=='e')
                        grid[2][1]='o';
                    else {
                        Log.v("nextMove()","No move left; calling drawProtocol() after player made the move");
                        drawProtocol();
                    }
                }
            }
            if(result()) {
                return;
            }
        }
        if(grid[0][0]=='o')
            t1.setText("O");
        if(grid[0][1]=='o')
            t2.setText("O");
        if(grid[0][2]=='o')
            t3.setText("O");
        if(grid[1][0]=='o')
            t4.setText("O");
        if(grid[1][1]=='o')
        {
            t5.setText("O");
            //Log.v("nextMove()","grid[1][1]: "+grid[1][1]+" t5.getText(): "+t5.getText());
        }
        if(grid[1][2]=='o')
            t6.setText("O");
        if(grid[2][0]=='o')
            t7.setText("O");
        if(grid[2][1]=='o')
            t8.setText("O");
        if(grid[2][2]=='o')
            t9.setText("O");
        int flag=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(grid[i][j]=='e')
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        if(flag==0) {
            Log.v("nextMove()","No move left; calling drawProtocol() after comp made the move");
            drawProtocol();
        }
    }

    private void refresh()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]='e';
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        firstMove =true;
        Random random=new Random();
        int val=random.nextInt(100);
        Log.v("refresh()","random value: "+String.valueOf(val));
        if(val<50){
            nextMove();
            Log.v("refresh()","nextMove()made !!");
            Toast.makeText(this,"Computer Moves first!!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Your Move first!",Toast.LENGTH_SHORT).show();
        }
    }
}