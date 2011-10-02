package com.perry.ntnu;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

public class Courses {

   private ArrayList<Course> arraylist;

   public Courses(){
       super();
       arraylist = new ArrayList<Course>();
   }

   public void addCourse(String coursecode){
        Course course = getCourseFromAPI(coursecode);
        if (course != null){
            arraylist.add(course);
            Log.i("addCourse", "successfully added course " + coursecode);
        }else{
            Log.e("addCourse", "course is null");
        }
    }

    public InputStream retrieveStream(String url) {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        Log.i("retrieveStream", request.toString());
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        try {
            HttpResponse getResponse = client.execute(request);

            final int statusCode = getResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.i("retrieveStream", "statusCode != SC_OK");
                return null;
            }

            HttpEntity getResponseEntity = getResponse.getEntity();
            Log.i("retrieveStream", "statusCode == SC_OK");
            return getResponseEntity.getContent();

        } catch (IOException e) {
            request.abort();
        }
        return null;
    }

    public Course getCourseFromAPI(String coursecode) {
        Course course = null;
        String url = "http://www.ime.ntnu.no/api/course/"+coursecode;
        Log.i("getCourseFromAPI", url.toString());
        InputStream source = retrieveStream(url);

        if (source != null) {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(source);

            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(reader);
            JsonElement jsonElement = jsonObject.get("course");
            course = gson.fromJson(jsonElement, Course.class);

            Log.i("getCourseFromAPI", course.getCode());
            Log.i("getCourseFromAPI", course.getName());
            Log.i("getCourseFromAPI", course.getStudyLevelName());
        }

        return course;
    }

    public ArrayList<Course> getCourseList(){
        return arraylist;
    }
}
