package com.example.riliancedigital.bingo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static int num = 0,rSum=0,cSum=0,c1Sum=0,c2Sum=0,score=0;
private static int starter = 0;
private static int idReference[][] = new int[5][5];
static ArrayList<View> ids = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int x=0;x<5;x++) {
            for (int y = 0; y < 5; y++)
                idReference[x][y] = 0;
        }

        ArrayList<Views> viewId = new ArrayList<Views>();
        viewId.add(new Views((TextView) findViewById(R.id.R1C1), 0, 0,0));
        viewId.add(new Views((TextView) findViewById(R.id.R1C2), 0, 1,0));
        viewId.add(new Views((TextView) findViewById(R.id.R1C3), 0, 2,0));
        viewId.add(new Views((TextView) findViewById(R.id.R1C4), 0, 3,0));
        viewId.add(new Views((TextView) findViewById(R.id.R1C5), 0, 4,0));
        viewId.add(new Views((TextView) findViewById(R.id.R2C1), 1, 0,0));
        viewId.add(new Views((TextView) findViewById(R.id.R2C2), 1, 1,0));
        viewId.add(new Views((TextView) findViewById(R.id.R2C3), 1, 2,0));
        viewId.add(new Views((TextView) findViewById(R.id.R2C4), 1, 3,0));
        viewId.add(new Views((TextView) findViewById(R.id.R2C5), 1, 4,0));
        viewId.add(new Views((TextView) findViewById(R.id.R3C1), 2, 0,0));
        viewId.add(new Views((TextView) findViewById(R.id.R3C2), 2, 1,0));
        viewId.add(new Views((TextView) findViewById(R.id.R3C3), 2, 2,0));
        viewId.add(new Views((TextView) findViewById(R.id.R3C4), 2, 3,0));
        viewId.add(new Views((TextView) findViewById(R.id.R3C5), 2, 4,0));
        viewId.add(new Views((TextView) findViewById(R.id.R4C1), 3, 0,0));
        viewId.add(new Views((TextView) findViewById(R.id.R4C2), 3, 1,0));
        viewId.add(new Views((TextView) findViewById(R.id.R4C3), 3, 2,0));
        viewId.add(new Views((TextView) findViewById(R.id.R4C4), 3, 3,0));
        viewId.add(new Views((TextView) findViewById(R.id.R4C5), 3, 4,0));
        viewId.add(new Views((TextView) findViewById(R.id.R5C1), 4, 0,0));
        viewId.add(new Views((TextView) findViewById(R.id.R5C2), 4, 1,0));
        viewId.add(new Views((TextView) findViewById(R.id.R5C3), 4, 2,0));
        viewId.add(new Views((TextView) findViewById(R.id.R5C4), 4, 3,0));
        viewId.add(new Views((TextView) findViewById(R.id.R5C5), 4, 4,0));

        ids.add(findViewById(R.id.B));
        ids.add(findViewById(R.id.I));
        ids.add(findViewById(R.id.N));
        ids.add(findViewById(R.id.G));
        ids.add(findViewById(R.id.O));
        Button button = (Button) findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                starter =  1;
                Log.v("button is",String.valueOf(starter));
            }
        });

    }

    // method for number incrementation
    public int numIn() {
        num = num + 1;
        Log.v("number is",String.valueOf(num));

        return num;
    }
    public int getNum()
    {
        return num;
    }
    public int getStarter()
    {
        return starter;
    }
    //setter for id reference
    public void setIdReference(int row,int col)
    {Log.v("Before Insetreferenceid","method");

        idReference[row][col]=1;
        Log.v("After Insetreferenceid ",String.valueOf(row)+String.valueOf(col));
    }
    //checking method
    public int checker(int r,int c)
    {
        //calculating sum for row
        for (int col=0;col<5;col++)
            rSum = rSum + idReference[r][col];
        Log.v("row sum is",String .valueOf(rSum));
        //calculating sum for coloumn
        for (int row = 0; row<5; row++)
            cSum = cSum + idReference[row][c];
        Log.v("col sum is",String .valueOf(cSum));
        //sum for 1st diagonal'\'
        if(r == c) {
            for (int rc = 0; rc < 5; rc++)
                c1Sum = c1Sum + idReference[rc][rc];
            Log.v("C1 sum is",String .valueOf(c1Sum));
        }
        //calculating sum for @nd diagonal'/'
        if(r+c == 4)
        {
            for (int cr = 0; cr<5; cr++)
                c2Sum = c2Sum + idReference[cr][4-cr];
            Log.v("C2 sum is",String .valueOf(c2Sum));
        }
        //calculating the score
        if (rSum == 5)
        {
            score = score+1;
            rSum = 0;
//            a(counter);
        }
        else
            rSum = 0;
        if (cSum == 5)
        {
            score = score+1;
            cSum = 0;
           //a(counter);
        }
        else
            cSum = 0;
        if (c1Sum == 5)
        {
            score = score+1;
            c1Sum = 0;
           //a(counter);
        }
        else
            c1Sum = 0;
        if (c2Sum == 5)
        {
            score = score+1;
            c2Sum = 0;
            //a(counter);
        }
        else c2Sum = 0;
        return score;
    }
  /*  public void a(int score)
    {
       // int i = ids.size();
        Log.v("size",String.valueOf(getIds(score-1)));
      // TextView textView = (TextView)findViewById(getIds(score-1));
        Log.v("dclarration","done");
       // textView.setTextColor(Color.parseColor("#FF0000"));

    }
public void setIds()
{
    ids.add(R.id.B);
    ids.add(R.id.I);
    ids.add(R.id.N);
    ids.add(R.id.G);
    ids.add(R.id.O);
}*/
public View getIds(int count)
{
    Log.v("value if 5",String.valueOf(count));

    return ids.get(count);
}
}