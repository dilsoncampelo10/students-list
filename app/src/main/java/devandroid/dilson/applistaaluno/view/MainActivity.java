package devandroid.dilson.applistaaluno.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.dilson.applistaaluno.R;
import devandroid.dilson.applistaaluno.model.Student;

public class MainActivity extends AppCompatActivity {

    EditText txtFirstName;
    EditText txtLastName;
    EditText txtCourseName;
    EditText txtNumberCod;

    Button buttonReset;
    Button buttonSave;
    Button buttonFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Student student = new Student("Dilson","Campêlo","Java","12211");
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtCourseName = findViewById(R.id.txtCourseName);
        txtNumberCod = findViewById(R.id.txtNumberCod);

        buttonReset = findViewById(R.id.buttonReset);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        txtFirstName.setText(student.getFirstName());
        txtLastName.setText(student.getLastName());
        txtCourseName.setText(student.getCourseName());
        txtNumberCod.setText(student.getNumberCod());

        Log.i("Poo","Aqui");
    }
}