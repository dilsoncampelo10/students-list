package devandroid.dilson.applistaaluno.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import devandroid.dilson.applistaaluno.R;
import devandroid.dilson.applistaaluno.controller.CourseController;
import devandroid.dilson.applistaaluno.controller.StudentController;
import devandroid.dilson.applistaaluno.model.Course;
import devandroid.dilson.applistaaluno.model.Student;

public class MainActivity extends AppCompatActivity {

    StudentController controller;
    CourseController courseController;
    List<Course> courseList;
    EditText txtFirstName;
    EditText txtLastName;
    EditText txtCourseName;
    EditText txtNumberCod;

    Button buttonReset;
    Button buttonSave;
    Button buttonFinish;

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        controller = new StudentController(MainActivity.this);
        courseController = new CourseController();
        courseList = courseController.getCourses();
        Student student = new Student();
        controller.getData(student);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtCourseName = findViewById(R.id.txtCourseName);
        txtNumberCod = findViewById(R.id.txtNumberCod);

        buttonReset = findViewById(R.id.buttonReset);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,courseController.getCoursesName());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        txtFirstName.setText(student.getFirstName());
        txtLastName.setText(student.getLastName());
        txtCourseName.setText(student.getCourseName());
        txtNumberCod.setText(student.getNumberCod());

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFirstName.setText("");
                txtLastName.setText("");
                txtCourseName.setText("");
                txtNumberCod.setText("");

                controller.clear();

            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Volte Sempre",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student.setFirstName(txtFirstName.getText().toString());
                student.setLastName(txtLastName.getText().toString());
                student.setCourseName(spinner.getSelectedItem().toString());
                student.setNumberCod(txtNumberCod.getText().toString());

                Toast.makeText(MainActivity.this,"Salvo: "+ student.toString(),Toast.LENGTH_LONG).show();

                controller.save(student);
            }
        });

        Log.i("Poo","Aqui");
    }
}