package sg.edu.rp.c346.id22026341.l09_demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    TextView tvName;
    TextView tvGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        tvName = findViewById(R.id.textViewName);
        tvGPA = findViewById(R.id.textViewGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float floatGPA = Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("details", strName);
        prefEdit.putFloat("GPA", floatGPA);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String msg = prefs.getString("details", "No details");
        float msg2 = prefs.getFloat("GPA", 2.5f);
        etName.setText(msg);
        String newMsg = Float.toString(msg2);
        etGPA.setText(newMsg);
    }
}