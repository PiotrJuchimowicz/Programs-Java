package com.example.piotr.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import com.example.piotr.myapplication.model.Task;

import java.util.List;

public class AdapterTask extends ArrayAdapter<Task> {
    private Activity activity;
    private List<Task> tasks;
    private static LayoutInflater inflater = null;

    public AdapterTask(Activity activity, int textViewResourceId, List<Task> tasks) {
        super(activity, textViewResourceId, tasks);
        try {
            this.activity = activity;
            this.tasks = tasks;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {
            Log.e("ERROR", "Exception in constructor: " + AdapterTask.class);

        }
    }


}

