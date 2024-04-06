package devandroid.dilson.applistaaluno.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.dilson.applistaaluno.R;
import devandroid.dilson.applistaaluno.database.StudentListDB;

public class SplashActivity extends AppCompatActivity {
    public static final int TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        changeToMainView();
    }

    private void changeToMainView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    StudentListDB studentListDB = new StudentListDB(SplashActivity.this);
                } catch (Exception e){
                    Log.i("try",e.getMessage());
                }



                Intent main = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(main);
                finish();
            }
        },TIME_OUT);

    }
}