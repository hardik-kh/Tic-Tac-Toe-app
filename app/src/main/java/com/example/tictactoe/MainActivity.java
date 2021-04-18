package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    // 0 - O
    // 1 - X

    int activePlayer = 1;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    // State meaning
    // 0 - O
    // 1 - X
    // 2 - null

    int [][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int click =0;

    public void tap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if (gameState[tappedImage]==2){
           gameState[tappedImage] = activePlayer;
           img.setTranslationY(-1000f);

           if(activePlayer == 1){
               img.setImageResource(R.drawable.x);
               activePlayer =0;
               TextView status = findViewById(R.id.status);
               status.setText("O's Turn");
               click = click+1;
           }

           else{
               img.setImageResource(R.drawable.o);
               activePlayer = 1;
               TextView status = findViewById(R.id.status);
               status.setText("X's Turn");
               click = click+1;
           }
            img.animate().translationYBy(1000f).setDuration(300);

        }
        // check for win
        for(int [] winPosition: winPositions){
            if(click == 9){
                if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]] !=2){
                    // Somebody has won
                    String winnerStr;
                    gameActive = false;
                    if(gameState[winPosition[0]]==0){
                        winnerStr = "O has won";
                        click=0;
                    }
                    else {
                        winnerStr = "X has won";
                        click=0;
                    }

                    // Update satus by anouncing
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                }
                else{
                    TextView status = findViewById(R.id.status);
                    status.setText("Game Drawn");
                    gameActive = false;
                    click=0;
                }

            }
            else{
                if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]] !=2){
                    // Somebody has won
                    String winnerStr;
                    gameActive = false;
                    if(gameState[winPosition[0]]==0){
                        winnerStr = "O has won";
                        click=0;
                    }
                    else {
                        winnerStr = "X has won";
                        click=0;
                    }

                    // Update satus by anouncing
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                }
            }

        }



    }

    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for (int i =0; i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to Play");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}