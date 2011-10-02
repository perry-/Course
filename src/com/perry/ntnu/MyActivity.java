package com.perry.ntnu;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.gson.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class MyActivity extends ListActivity
{

    private ListView listView;
    private Courses courses;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        courses = new Courses();
        courses.addCourse("IT3402");
        courses.addCourse("TDT4120");


        listView = getListView();
        populateList(courses.getCourseList());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                onListItemClick(v, pos, id);
            }
        });
    }

    protected void onListItemClick(View v, int pos, long id) {
        Log.i("MyActivity", "onListItemClick id=" + id);
        Intent courseIntent = new Intent(this, CourseActivity.class);
        startActivity(courseIntent);
    }


    public void populateList(ArrayList<Course> list){

        ListAdapter adapter = new CustomAdapter(this, R.layout.list_item, list);

        listView.setAdapter(adapter);

    }
}
