package edu.utdallas.lsj150230.theia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    private Button backButton;

    void createButtons()
    {
        this.backButton = (Button) findViewById(R.id.button0);

        backButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_screen);

        createButtons();
    }
}
