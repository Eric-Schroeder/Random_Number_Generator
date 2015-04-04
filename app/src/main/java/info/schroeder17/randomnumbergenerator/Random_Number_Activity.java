package info.schroeder17.randomnumbergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class Random_Number_Activity extends Activity {

    //public static final String TAG = Random_Number_Activity.class.getSimpleName();

    public int randomNumber;
    private int mFirstNumber;
    private int mSecondNumber;
    private Button mAnswerButton;
    private EditText mFirstNumberField;
    private EditText mSecondNumberField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random__number_);



        mFirstNumberField = (EditText) findViewById(R.id.firstNumber);
        mSecondNumberField = (EditText) findViewById(R.id.secondNumber);
        mAnswerButton = (Button) findViewById(R.id.answerButton);


        mAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFirstNumberField.length() == 0 || mSecondNumberField.length() == 0) {
                    Toast.makeText(Random_Number_Activity.this, "You MUST enter two numbers", Toast.LENGTH_LONG).show();
                } else {
                    mFirstNumber = Integer.parseInt(mFirstNumberField.getText().toString());
                    mSecondNumber = Integer.parseInt(mSecondNumberField.getText().toString());

                    if (mFirstNumber < mSecondNumber) {
                        randomNumber = getRandomNumber(mFirstNumber, mSecondNumber);
                        startAnswer(randomNumber);
                    } else {
                        Toast.makeText(Random_Number_Activity.this, "First number must be lower than the second number!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

    }

    public int getRandomNumber(int firstNumber, int secondNumber) {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt((secondNumber - firstNumber) + 1) + firstNumber;

        return randomNumber;
    }

    public void startAnswer(int randomNumber) {
        Intent intent = new Intent(Random_Number_Activity.this, Answer_Activity.class);
        intent.putExtra("answer", randomNumber);
        startActivity(intent);
    }
}
