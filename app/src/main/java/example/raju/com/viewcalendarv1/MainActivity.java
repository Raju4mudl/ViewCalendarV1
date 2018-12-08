package example.raju.com.viewcalendarv1;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREF_NAME = "trackTimeTable";
    private static final String KEY_NAME = "timeTracker";

    EditText nameText;
    EditText einText;
    EditText locationText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameT);
        einText = findViewById(R.id.ein);
        locationText = findViewById(R.id.locationT);

        findViewById(R.id.registrationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveShared();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void instantiateDataTable(){
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        SimpleDateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDateForMonth = df1.format(c);
        int year = Integer.parseInt(formattedDate.substring(7));
        int month = Integer.parseInt(formattedDate.substring(3,5));
        String Month = formattedDateForMonth.substring(3,6);
        YearMonth yearMonthObject = YearMonth.of(year,month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
    }
    private void saveShared(){
        String name = nameText.getText().toString();
        String ein = einText.getText().toString();
        String location = locationText.getText().toString();

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

        SharedPreferences spObj = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor spEditor = spObj.edit();

        spEditor.putString("NAME", name);
        spEditor.putString("EIN",ein);
        spEditor.putString("LOCATION",location);
    }
}
