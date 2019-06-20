package edu.utdallas.lsj150230.theia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button aboutButton, setButton, emergConButton, routeStatButton, voiceAssistButton;

    void createButtons()
    {
        this.aboutButton = (Button) findViewById(R.id.button0);
        this.setButton = (Button) findViewById(R.id.button1);
        this.emergConButton = (Button) findViewById(R.id.button2);
        this.routeStatButton = (Button) findViewById(R.id.button3);
        this.voiceAssistButton = (Button) findViewById(R.id.button4);

        aboutButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

        setButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        emergConButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, EmergencyContactActivity.class));
            }
        });

        /*
        routeStatButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, RouteStatusActivity.class));
            }
        });

        voiceAssistButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, VoiceAssistance.class));
            }
        });
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * *    ABOUT BUTTOn
         */
        createButtons();
    }
}
