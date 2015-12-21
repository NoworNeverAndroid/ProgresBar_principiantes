package com.example.nowor_000.progresbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBarHorizontal, progressBarCircular;
    Button btnProgress;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadirVistas();

        btnProgress.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                new AsyncTask_load().execute();
                btnProgress.setClickable(false);
            }
        });

    }



    private void añadirVistas() {

        btnProgress = (Button)findViewById(R.id.btn1);

        progressBarHorizontal = (ProgressBar)findViewById(R.id.progressbar_Horizontal);
       // progressBarHorizontal.setProgress(0);

        progressBarCircular = (ProgressBar)findViewById(R.id.progressBarCircular);
       // progressBarCircular.setProgress(0);

    }


    public class AsyncTask_load extends AsyncTask<Void, Integer, Void> {

        int progreso;


        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "onPreExecute", Toast.LENGTH_LONG).show();
            progreso = 0;
            progressBarCircular.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {

            while(progreso < 100){
                progreso++;
                publishProgress(progreso);
                SystemClock.sleep(20);
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

            progressBarHorizontal.setProgress(values[0]);
            progressBarCircular.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(MainActivity.this, "onPostExecute", Toast.LENGTH_LONG).show();
            btnProgress.setClickable(true);
            progressBarCircular.setVisibility(View.INVISIBLE);
        }


    }




}