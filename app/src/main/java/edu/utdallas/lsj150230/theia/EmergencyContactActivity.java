package edu.utdallas.lsj150230.theia;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.Scanner;
import android.view.View;
import android.widget.Button;
import android.view.animation.AnimationUtils;

public class EmergencyContactActivity extends AppCompatActivity {

    private final String EMERGENCY_SERVICES_NUMBER = "911";
    private String emergencyContactNumber = "2149848730"; // Hard-coded value for demonstration purposes

    private Button backButton;

    void createButtons()
    {
        this.backButton = (Button) findViewById(R.id.button0);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EmergencyContactActivity.this, MainActivity.class));
            }
        });
    }

    void makePhoneCall(String phoneNumber)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        callIntent.setData(Uri.parse("tel:" + phoneNumber));

        if (ActivityCompat.checkSelfPermission(EmergencyContactActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        // else System.exit(1);

        startActivity(callIntent);
    }

    void determineUserUrgency()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("I am contacting your designated emergency contact now...");
        System.out.println("Would you prefer if I call 911?");

        String userResponse = scan.nextLine();

        while(!userResponse.equals("yes") && !userResponse.equals("no"))
        {

            System.out.println("I am contacting your designated emergency contact now...");
            System.out.println("Would you prefer if I call 911?");

            userResponse = scan.nextLine();
        }

        if (userResponse.equals("yes"))
        {
            // TODO: an automated text should be sent to the designated emergency contact stating the
            //       user has contacted 911, as containing information about the user's current location
            //       ( it is now in violation of Google Play policy to automate the text using Android's
            //         built-in SMS functions ->
            //         https://stackoverflow.com/questions/26311243/sending-sms-programmatically-without-opening-message-app;
            //         back-end issue )

            System.out.println("I am alerting your designated emergency contact and dialing 911...");
            makePhoneCall(this.EMERGENCY_SERVICES_NUMBER);

        }
        else if (userResponse.equals("no"))
        {
            // Do nothing, already calling...
            System.out.println("Okay. Dialing your designated emergency contact...");
            makePhoneCall(this.emergencyContactNumber);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact);

        createButtons();

        View view = (View) findViewById(R.id.imageView);

        /*
            This section is representative of the context in the which a user is exchanging responses with the voice AI
            ( Not how the interaction would be correctly programmed given all the necessary resources, etc. )
         */
        boolean userSpeaking = true;

        view.startAnimation(AnimationUtils.loadAnimation(EmergencyContactActivity.this, R.anim.fader));

        //determineUserUrgency();

        // -----------------------------------------------------------------------------------------
    }
}

