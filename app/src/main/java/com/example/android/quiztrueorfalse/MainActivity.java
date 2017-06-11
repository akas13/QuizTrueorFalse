package com.example.android.quiztrueorfalse;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.checked;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int radio1 = 0;
    public int radio4 = 0;
    public int points = 0;

    public void submit(View view) {


        //logic for 2 What maximum speed can the air of a human sneeze reach? 60 km/h 100 km/h 160 km/h" 100 is ans

        EditText speed = (EditText) findViewById(R.id.ansq2);
        String stringSpeed = speed.getText().toString();
        if (stringSpeed.matches("")) {
            Toast.makeText(this, "You did not enter an answer for #2", Toast.LENGTH_SHORT).show();
            return;
        }
        int iSpeed = Integer.parseInt(stringSpeed);

        // logic for question 3, washington question
        CheckBox city = (CheckBox) findViewById(R.id.city_q3);
        boolean hasCity = city.isChecked();
        CheckBox person = (CheckBox) findViewById(R.id.person_q3);
        boolean hasPerson = person.isChecked();
        CheckBox state = (CheckBox) findViewById(R.id.state_q3);
        boolean hasState = state.isChecked();

        //logic for question 4 The computer of the Lunar Module Eagle had a random access memory (RAM) of only 4 kilobits. t/f true
        // Is the button now checked?

// pass the variables to their logic methods
        String answerone = answer1(radio1);
        String answertwo = answer2(iSpeed);
        String answerthree = answer3(hasCity, hasPerson, hasState);
        String answerfour = answer4(radio4);
        //send results of methods to displays

        display_ans1(answerone);
        display_ans2(answertwo);
        display_ans3(answerthree);
        display_ans4(answerfour);
        Toast.makeText(getApplicationContext(), "You got " + points + " of 4!", Toast.LENGTH_LONG).show();
        points = 0;
    }

    public int isClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.true_q1:
                if (checked)
                    radio1 = 1;
                break;
            case R.id.false_q1:
                if (checked)
                    radio1 = 2;
                break;
        }
        return radio1;
    }

    public int isClicked4(View view) {
        boolean checked4 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.true_q4:
                if (checked4)
                    radio4 = 1;
                break;
            case R.id.false_q4:
                if (checked4)
                    radio4 = 2;
                break;
        }
        return radio4;
    }

    public void display_ans1(String ansone) {
        TextView summary_text_view = (TextView) findViewById(R.id.ans1);
        summary_text_view.setText(ansone);
    }

    public void display_ans2(String anstwo) {
        TextView summary_text_view = (TextView) findViewById(R.id.ans2);
        summary_text_view.setText(anstwo);
    }

    public void display_ans3(String ansthree) {
        TextView summary_text_view = (TextView) findViewById(R.id.ans3);
        summary_text_view.setText(ansthree);
    }

    public void display_ans4(String ansfour) {
        TextView summary_text_view = (TextView) findViewById(R.id.ans4);
        summary_text_view.setText(ansfour);
    }

    private String answer1(int radio1) {
        if (radio1 == 2) {
            String ansone = "correct, well done!";
            points++;
            return ansone;
        } else if (radio1 == 1) {
            String ansone = "incorrect";
            return ansone;
        } else {
            String ansone = "please enter an answer";
            return ansone;
        }
    }

    private String answer2(int iSpeed) {
        if (iSpeed == 100) {
            String anstwo = "Correct";
            points++;
            return anstwo;
        } else {
            String anstwo = "Incorrect, The answer is 100mph. When a human sneezes, they can expel air at speeds of up to 100 mph (160 km/h).";
            return anstwo;
        }
    }


    private String answer3(boolean hasCity, boolean hasPerson, boolean hasState) {
        if (hasCity == true & hasPerson == true & hasState == true) {
            String ansthree = "correct, all three are true";
            points++;
            return ansthree;
        } else {
            String ansthree = "incorrect, all three are true";
            return ansthree;
        }
    }

    public String answer4(int radio4) {
        if (radio4 == 1) {
            String ansfour = "correct, well done!";
            points++;
            return ansfour;
        } else if (radio4 == 2) {
            String ansfour = "Incorrect, The answer is TRUE. The computer of the Lunar Module Eagle (used during the Apollo missions,1961–1972) had 74 kilobits of memory, including random access memory (RAM) of 4 kilobits. This is less than the memory in a modern coffee maker.";
            return ansfour;
        } else {
            String ansfour = "please enter a value";
            return ansfour;
        }
    }

}
//questions taken from http://quipoquiz.com/quiz/science-or-fiction/
// rubric https://review.udacity.com/#!/rubrics/158/view