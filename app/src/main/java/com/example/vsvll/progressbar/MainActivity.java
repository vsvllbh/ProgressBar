package com.example.vsvll.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button Cbutton, Hbutton;
    ProgressBar Circular, Horizontal;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Circular = findViewById(R.id.progress_circular);
        Horizontal = findViewById(R.id.progress_horizontal);

        Cbutton = findViewById(R.id.button1);
        Hbutton = findViewById(R.id.button2);

        //Set Visibility GONE so it dose not show on start.
        Circular.setVisibility(View.GONE);
        Horizontal.setVisibility(View.GONE);

    }
    public void circularClick(View view)
    {
        //When the button is clicked the Visibility will be ON!
        Circular.setVisibility(View.VISIBLE);

    }

    public void horizontalClick(View view)
    {
        //When the button is clicked the Visibility will be ON!
        Horizontal.setVisibility(View.VISIBLE);

        //method to set the value on progress and pass value = 0
        setProgressValue(progress);
    }
    public void setProgressValue(final int progress)
    {
        Horizontal.setProgress(progress);

        //Thread is used to give delay and set Value accordingly

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }

}
