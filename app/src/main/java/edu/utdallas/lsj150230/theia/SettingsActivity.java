package edu.utdallas.lsj150230.theia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    private Button configButton, contactsButton, soundButton, miscButton, backButton;

    void createButtons()
    {
        this.configButton = (Button) findViewById(R.id.button0);
        this.contactsButton = (Button) findViewById(R.id.button1);
        this.soundButton = (Button) findViewById(R.id.button2);
        this.miscButton = (Button) findViewById(R.id.button3);
        this.backButton = (Button) findViewById(R.id.button4);

        /*
        configButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                startActivity(new Intent(SettingsActivity.this, ConfigurationActivity.class));
            }
        });
        */

        contactsButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(SettingsActivity.this, ContactsActivity.class));
            }
        });

        /*
        soundButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(SettingsActivity.this, SoundActivity.class));
            }
        });

        miscButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(SettingsActivity.this, MiscActivity.class));
            }
        });
        */

        backButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        createButtons();
    }
}
