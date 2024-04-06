package devandroid.dilson.applistaaluno.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentListDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "students.list";
    public static final int DB_VERSION = 1;
    public StudentListDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = getWritableDatabase();
       String table = "CREATE TABLE students (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
        "first_name TEXT, last_name TEXT,course TEXT,number_cod, INTEGER)";
       db.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
