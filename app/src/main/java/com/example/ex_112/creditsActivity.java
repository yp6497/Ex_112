package com.example.ex_112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

    /**
     * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
     * @version 1.1
     * @since 14/12/2020
     * short description- the credits.
     */
    public class creditsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_credits);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            menu.add("Main Activity");
            return true;
        }

        /**
         * description- if "Main Activity" selected: return back to the Main activity.
         */
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            String st = item.getTitle().toString();
            if (st.endsWith("Main screen"))
                finish();

            return true;
        }
    }

