package fi.tamk.miliho.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by miliho on 14.1.2018.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    boolean PLAYER_X = true;

    int TURN_COUNT = 0;

    Button b00;
    Button b01;
    Button b02;

    Button b10;
    Button b11;
    Button b12;

    Button b20;
    Button b21;
    Button b22;

    Button bReset;

    TextView tvInfo;

    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        bReset = (Button) findViewById(R.id.bReset);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        bReset.setOnClickListener(this);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);

        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        initializeBoardStatus();

    }

    @Override
    public void onClick(View view) {
        MyDebug.print(TAG, "onClick", "init", 1);

        boolean resetButtonPressed = false;

        switch (view.getId()){
            case R.id.b00:
                if(PLAYER_X){
                    b00.setText("X");
                    boardStatus[0][0] = 1;
                } else{
                    b00.setText("O");
                    boardStatus[0][0] = 0;
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if(PLAYER_X){
                    b01.setText("X");
                    boardStatus[0][1] = 1;
                } else{
                    b01.setText("O");
                    boardStatus[0][1] = 0;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if(PLAYER_X){
                    b02.setText("X");
                    boardStatus[0][2] = 1;
                } else{
                    b02.setText("O");
                    boardStatus[0][2] = 0;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if(PLAYER_X){
                    b10.setText("X");
                    boardStatus[1][0] = 1;
                } else{
                    b10.setText("O");
                    boardStatus[1][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if(PLAYER_X){
                    b11.setText("X");
                    boardStatus[1][1] = 1;
                } else{
                    b11.setText("O");
                    boardStatus[1][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if(PLAYER_X){
                    b12.setText("X");
                    boardStatus[1][2] = 1;
                } else{
                    b12.setText("O");
                    boardStatus[1][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if(PLAYER_X){
                    b20.setText("X");
                    boardStatus[2][0] = 1;
                } else{
                    b20.setText("O");
                    boardStatus[2][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if (PLAYER_X) {
                    b21.setText("X");
                    boardStatus[2][1] = 1;
                } else {
                    b21.setText("O");
                    boardStatus[2][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if (PLAYER_X) {

                    b22.setText("X");
                    boardStatus[2][2] = 1;
                } else {

                    b22.setText("O");
                    boardStatus[2][2] = 0;
                }

                b22.setEnabled(false);
                break;

            case R.id.bReset:
                resetButtonPressed = true;
                break;

            default:
                break;

        }

        if (resetButtonPressed) {

            resetBoard();
        } else {

            TURN_COUNT ++;
            PLAYER_X = !PLAYER_X;

            if (PLAYER_X) {

                setInfo("Player X turn");
            } else {

                setInfo("Player O turn");
            }

            if (TURN_COUNT==9) {

                result("Game Draw");
            }

            checkWinner();
        }
    }

    private void checkWinner() {

        MyDebug.print(TAG, "checkWinner", "Checking winner", 1);

        //Horizontal rows
        for (int i=0; i<3; i++){

            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {

                if (boardStatus[i][0]==1) {

                    result("Player X winner");
                    break;
                } else if (boardStatus[i][0]==0) {

                    result("Player O winner");
                    break;
                }
            }
        }

        //Vertical columns
        for (int i=0; i<3; i++){

            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {

                if (boardStatus[0][i]==1) {

                    result("Player X winner");
                    break;
                } else if (boardStatus[0][i]==0) {

                    result("Player O winner");
                    break;
                }
            }
        }

        //Diagonal
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {

            if (boardStatus[0][0]==1) {

                result("Player X winner");
            } else if (boardStatus[0][0]==0) {

                result("Player O winner");
            }
        }

        //Diagonal
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {

            if (boardStatus[0][2]==1) {

                result("Player X winner");
            } else if (boardStatus[0][2]==0) {

                result("Player O winner");
            }
        }
    }

    private void enableAllBoxes(boolean value) {

        MyDebug.print(TAG, "enableAllBoxes", "Toggling play buttons", 1);
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);

        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);

        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }

    private void result(String winner) {

        MyDebug.print(TAG, "result", "Toasting the result", 1);

        Toast.makeText(this.getApplicationContext(), winner, Toast.LENGTH_SHORT).show();
        setInfo(winner);
        enableAllBoxes(false);
    }

    private void resetBoard(){
        MyDebug.print(TAG, "resetBoard", "Resetting the board", 1);
        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");

        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;

        initializeBoardStatus();

        setInfo("Start Again!!!");

        Toast.makeText(this.getApplicationContext(),"Board Reset",Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text) {
        tvInfo.setText(text);
    }

    private void initializeBoardStatus() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                boardStatus[i][j] = -1;
            }
        }
    }
}