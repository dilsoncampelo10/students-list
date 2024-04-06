package devandroid.dilson.applistaaluno.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class StudentListDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "students.list";
    public static final int DB_VERSION = 1;
    SQLiteDatabase db;
    Cursor cursor;
    public StudentListDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String table
                = "CREATE TABLE students (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName TEXT, " +
                "lastName TEXT, " +
                "courseName TEXT, "+
                "numberCod INTEGER)";


        db.execSQL(table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void create(String tableName, ContentValues contentValues){
        db.insert(tableName,null,contentValues);
    }
}
