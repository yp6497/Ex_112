package com.example.ex_112;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOError;
import java.io.IOException;
import java.io.InvalidObjectException;

/**
 * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version 1.1
 * @since 14/12/2020
 * description- 3 buttons(each doing something else), one editText to enter an input
 and one text view that showing the "count" and the input(if the information is saved).
 */
public class MainActivity extends AppCompatActivity {


    boolean bo=false;
    EditText ed;
    /**
     * Holds the user input.
     */
    TextView tv;
    String Sed;
    /**
     * Count the number of times the "Count" button is clicked.
     */
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.ed);
        tv = findViewById(R.id.textView);
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);

        /**
         * Checks if this is the first time the program has been run.
         */
        boolean bo = settings.getBoolean("Exit or not", false);
        if(bo==true){
            /**
             *reads the information saved in the last exit and shows it in the text view..
             */
        int countB = settings.getInt("counter", 1);
        String strB = settings.getString("The input", "");
        tv.setText(countB);
        ed.setText("the input: " + strB);
        }
    }


    /**
     *short description- every time the button is clicked, The value of the param increases by one and displayed in text
     * @param view the view
     */
    public void countB(View view) {

        count++;
        tv.setText(count+"");

    }

    /**
     *short description- reset the param "count" to zero.
     * @param view the view
     */
    public void resetB(View view) {

        count =0;
        tv.setText(count+"");
    }

    /**short description- Exits the program and saves the information.
     * @param view the view
     */
    public void exitB(View view) {

        bo=true;
        Sed= ed.getText().toString();

        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("counter",count);
        editor.putString("The input",Sed);
        editor.putBoolean("Exit or not",bo);
        editor.commit();
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Credits");
        return true;
    }

    /**
     * description- if "credits" selected: goes to the credits activity.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String st = item.getTitle().toString();
        if (st.endsWith("Credits")) {
            Intent si = new Intent(this, creditsActivity.class);
            startActivity(si);
        }
        return true;
    }
}

