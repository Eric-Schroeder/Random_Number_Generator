package info.schroeder17.randomnumbergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Answer_Activity extends Activity {

    private int mAnswer;
    private Button mReplayButton;
    private String mAnswerText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_);

        Intent intent = getIntent();
        mAnswer = intent.getIntExtra("answer", 0);

        mAnswerText = String.valueOf(mAnswer);
        mTextView = (TextView)findViewById(R.id.answerView);
        mTextView.setText(mAnswerText);

    mReplayButton = (Button)findViewById(R.id.replayButton);
        mReplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }




}
