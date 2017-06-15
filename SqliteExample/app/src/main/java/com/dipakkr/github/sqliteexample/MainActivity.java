package com.dipakkr.github.sqliteexample;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dipakkr.github.sqliteexample.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        db.addStudent(new Student(1,"Deepak Kumar","CS"));
        db.addStudent(new Student(2,"Aryan","ECE"));
        db.addStudent(new Student(3,"Priyanshu","ME"));

        List<Student> students = db.getAllStudents();

        for (Student st : students){
            String log = "id" + st.getId() + "NAME : " + st.getName() + "SUB" + st.getSubject() ;
            Log.d(TAG,log);
        }

    }
}
