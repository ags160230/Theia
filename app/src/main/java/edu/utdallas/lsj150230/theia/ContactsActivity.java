package edu.utdallas.lsj150230.theia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.EditText;
import android.text.InputType;
import android.content.DialogInterface;
import android.widget.TextView;


import java.io.*;

public class ContactsActivity extends AppCompatActivity {

    private Button contact1, contact2, contact3, contact4, backButton;
    private TextView name, number;
    private String nameString = "", numberString = "";

    void createButtons()
    {
        this.contact1 = (Button) findViewById(R.id.button0);
        this.contact2 = (Button) findViewById(R.id.button1);
        this.contact3 = (Button) findViewById(R.id.button2);
        this.contact4 = (Button) findViewById(R.id.button3);
        this.backButton = (Button) findViewById(R.id.button4);

        contact1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // startActivity(new Intent(SettingsActivity.this, ConfigurationActivity.class));
                createTextDialogue();
                displayEmergencyContact();
            }
        });

        /*
        contact2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                startActivity(new Intent(SettingsActivity.this, ContactsActivity.class));
            }
        });

        contact3.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(SettingsActivity.this, SoundActivity.class));
            }
        });

        contact4.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(SettingsActivity.this, MiscActivity.class));
            }
        });
        */

        backButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(ContactsActivity.this, SettingsActivity.class));
            }
        });
    }

    void displayEmergencyContact()
    {
        // this.name = (TextView) findViewById(R.id.textView);
        this.number = (TextView) findViewById(R.id.textView2);

        //name.setText(nameString);
        number.setText(" Number: " + numberString);

        /*
        //                  Name TextBox
        //***********************************************************
        //Enter your name textbox
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
        //Empties the textbox once it's focused
        private void textBox1_Enter(object sender, EventArgs e)
        {
            if(name.Focus())
                textBox1.Text = String.Empty;
        }
        //Resets the placeholder text for password textbox
        private void textBox1_Leave(object sender, EventArgs e)
        {
            if(!textBox1.Focused)
                textBox1.Text = "Name: ";
        }

        //Resets the placeholder text for name textbox
        private void textBox1_Leave(object sender, EventArgs e)
        {
            if(!textBox1.Focused && textBox1.Text.Trim() == String.Empty)
                textBox1.Text = "Name: ";
        }

        //***********************************************************
        //                  Password TextBox
        //***********************************************************
        //Enter your password textbox
        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
        //Empties the password  textbox once it's focused
        private void textBox2_Enter(object sender, EventArgs e)
        {
            if(textBox2.Focus())
                textBox2.Text = String.Empty;
        }
        //Resets the placeholder text for password textbox
        private void textBox2_Leave(object sender, EventArgs e)
        {
            if(!textBox2.Focused)
                textBox2.Text = "Password: ";
        }

        //Resets the placeholder text for password textbox
        private void textBox2_Leave(object sender, EventArgs e)
        {
            if(!textBox2.Focused && textBox2.Text.Trim() == String.Empty)
                textBox2.Text = "Password: ";
        }
        //***********************************************************
        */
    }

    void createTextDialogue()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Emergency Contact Number");

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                numberString = input.getText().toString();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    void createContactsFile()
    {
        // TODO: make function to write designated emergency contact number to a file in the app's internal storage
        /*
        String filename = "myfile";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, ContactsActivity.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        createButtons();
        //createContactsFile();
    }
}

