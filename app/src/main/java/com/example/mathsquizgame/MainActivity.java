package com.example.mathsquizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start,btn_ans1,btn_ans2,btn_ans3,btn_ans4;
    TextView tv_score,tv_timer,tv_que,tv_bmsg;
    ProgressBar prog_timer;
    Game g =new Game();
    int secRem=100;
    int pt=100;
    CountDownTimer timer=new CountDownTimer(100000,1000) {
        @Override
        public void onTick(long l) {
        secRem--;
        tv_timer.setText(Integer.toString(secRem));
        pt--;
        prog_timer.setProgress(pt);
        }

        @Override
        public void onFinish() {
            btn_ans1.setEnabled(false);
            btn_ans2.setEnabled(false);
            btn_ans3.setEnabled(false);
            btn_ans4.setEnabled(false);
            tv_bmsg.setText("Time is up"+g.getNumcorrect()+"/"+(g.getTotalQuestion()-1));

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.btn_start);
        btn_ans1 = findViewById(R.id.btn_ans1);
        btn_ans2 = findViewById(R.id.btn_ans2);
        btn_ans3 = findViewById(R.id.btn_ans3);
        btn_ans4 = findViewById(R.id.btn_ans4);


        prog_timer = findViewById(R.id.prog_timer);

        tv_score = findViewById(R.id.tv_score);
        tv_bmsg = findViewById(R.id.tv_bmsg);
        tv_que = findViewById(R.id.tv_que);
        tv_timer = findViewById(R.id.tv_timer);

        tv_timer.setText("0sec");
        tv_que.setText("");
        tv_bmsg.setText("Press Go");
        tv_score.setText("0pts");
        prog_timer.setProgress(0);

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button start_button = (Button) view;
                start_button.setVisibility(View.INVISIBLE);
                startGame();
                timer.start();

            }
        };
        View.OnClickListener ansbtnonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btnclick = (Button) view;
                int answerselected = Integer.parseInt(btnclick.getText().toString());
                Toast.makeText(MainActivity.this,"AnswerSelected"+answerselected,Toast.LENGTH_SHORT).show();
                g.checkans(answerselected);
                tv_score.setText(Integer.toString(g.getScore()));
                startGame();

            }
        };
        btn_start.setOnClickListener(startButtonClickListener);
        btn_ans1.setOnClickListener(ansbtnonClickListener);
        btn_ans2.setOnClickListener(ansbtnonClickListener);
        btn_ans3.setOnClickListener(ansbtnonClickListener);
        btn_ans4.setOnClickListener(ansbtnonClickListener);

    }
    private void startGame(){
        g.makenewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();
        btn_ans1.setText(Integer.toString(answer[0]));
        btn_ans2.setText(Integer.toString(answer[1]));
        btn_ans3.setText(Integer.toString(answer[2]));
        btn_ans4.setText(Integer.toString(answer[3]));

        tv_que.setText(g.getCurrentQuestion().getQuestionpharse());

        btn_ans1.setEnabled(true);
        btn_ans2.setEnabled(true);
        btn_ans3.setEnabled(true);
        btn_ans4.setEnabled(true);

        tv_bmsg.setText(g.getNumcorrect()+"/"+(g.getTotalQuestion()-1));
    }

}