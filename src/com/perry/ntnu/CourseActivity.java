package com.perry.ntnu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info);

    }

    public void populateInfo(){
        TextView codeText = (TextView) findViewById(R.id.coursecode);
        TextView nameText = (TextView) findViewById(R.id.coursename);
        TextView levelText = (TextView) findViewById(R.id.courselevel);


    }
}
