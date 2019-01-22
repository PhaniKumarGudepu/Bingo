package com.example.riliancedigital.bingo;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RILIANCE DIGITAL on 24-03-2018.
 */

public class Views {
    MainActivity number = new MainActivity();
    int score;
    static int count=1;
    int color;
    //constructor
    public Views(final TextView id, final int i, final int j, final int colorChecker)
    {
          color = colorChecker;
        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText()=="")
                id.setText(String.valueOf(number.numIn()));


                else if (number.getStarter() == 1&&number.getNum()==25&&color == 0&&score<=5)
                {
                    Log.v("befor setting","background color");
                    id.setBackgroundColor(Color.parseColor("#000000"));
                    id.setTextColor(Color.parseColor("#FFFFFF"));
                    Log.v("after setting","background color");
                    number.setIdReference(i,j);
                   score =  number.checker(i,j);
                   color = 1;

                }
                if (score==count&&score<=5){

                    number.getIds(score-1).setBackgroundColor(Color.parseColor("#FF0000"));
                    count=count+1;
                    Log.v("count is",String.valueOf(count));
                    Log.v("the score is",String.valueOf(score));
                }
                if (score==5){
                   // Toast toast = Toast.makeText(number.getApplicationContext(),"GAME OVER",Toast.LENGTH_SHORT);
                    //toast.show();
                    Log.v("Game","over");
                    if (score==5)
                        score=score+1;
                }
            }
        });
    }
}
