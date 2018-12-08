package example.raju.com.viewcalendarv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String SHARED_PREF_NAME = "trackTimeTable";
    private static final String KEY_NAME = "timeTracker";

    private Button reg;
    private EditText nameText, einText, locationText;
    //private DbHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameT);
        einText = findViewById(R.id.ein);
        locationText = findViewById(R.id.locationT);

        reg = findViewById(R.id.registrationButton);
        reg.setOnClickListener(this);

        findViewById(R.id.registrationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saveShared();
            }
        });

    }
    @Override
    public void onClick(View v) {
        if(v.getId() ==R.id.registrationButton) {
            register();
        }

    }
    private void register(){

        //Reading Data
        String name = nameText.getText().toString();
        String ein = einText.getText().toString();
        String location = locationText.getText().toString();

        //Validation for Blank Field
        if(name.isEmpty()){
            nameText.setError("Name Required");
            nameText.requestFocus();
            return;
        }
        if(ein.isEmpty()){
            einText.setError("Name Required");
            einText.requestFocus();
            return;
        }
        if(location.isEmpty()){
            locationText.setError("Name Required");
            locationText.requestFocus();
            return;
        }


    }

}
