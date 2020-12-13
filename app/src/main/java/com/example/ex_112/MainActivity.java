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

/**
 * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version 1.1
 * @since 14/12/2020
 * short description- the credits.
 */
public class MainActivity extends AppCompatActivity {

    EditText ed;
    TextView tv;
    String Sed;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=findViewById(R.id.ed);
        tv=findViewById(R.id.textView);

        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        int countB =settings.getInt("counter way",1);
        String strB =settings.getString("The input","");
        tv.setText(countB+"+"+strB);

    }

    public void countB(View view) {

        count++;
        tv.setText(count+"");

    }

    public void resetB(View view) {

        count =0;
        tv.setText(count+"");
    }

    public void exitB(View view) {

        Sed= ed.getText().toString();
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("counter way",count);
        editor.putString("The input",Sed);
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

