package com.dipakkr.github.testaynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    private static String TAG  = MainActivity.class.getSimpleName();

    TextView textView;
    private static int j = 0;
    MyTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.score);
        Button bt = (Button)findViewById(R.id.bt);
        Button bt1 = (Button)findViewById(R.id.cancel);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 task = new MyTask();
                task.execute();

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
                j = 0;
                String q = Integer.toString(j);
                textView.setText(q);
            }
        });
    }
    private class MyTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"starting",Toast.LENGTH_LONG);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0;i<1000;i++){
              try{
                  Thread.sleep(10);
                  publishProgress(j);
                  j++;
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate();
            String t = Integer.toString(values[0]);
            Log.d(TAG,t);
            textView.setText(t);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
