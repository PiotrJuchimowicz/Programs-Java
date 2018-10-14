package com.example.piotr.myapplication.main;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.piotr.myapplication.R;
import com.example.piotr.myapplication.model.Database;
import com.example.piotr.myapplication.model.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView informationOnTop;
    ListView tasksListView;
    Database database= Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("INFO","Application launched");
        informationOnTop = findViewById(R.id.informationOnTop);
        informationOnTop.setTextColor(Color.BLUE);
        List<Task> tasks = database.getTasks();
        // Get ListView object from XML
        final ArrayAdapter<Task> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        tasksListView = findViewById(R.id.listOfTasks);
        tasksListView.setAdapter(arrayAdapter);
        tasksListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    Task taskToRemove = database.getTaskBasedOnList(position);
                    if(taskToRemove.getName().equals("RUN_YOUTUBE")){
                        Log.i("INFO","Running youtube");
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(taskToRemove.getDescription()));
                        startActivity(intent);
                        Log.i("INFO", "Youtube is running");
                        return;
                    }
                    Log.i("INFO", "Removing task with position on list: " + String.valueOf(position));
                    database.deleteTaskIdBasedOnList(position);
                    arrayAdapter.notifyDataSetChanged();
                    Log.w("WARN", "Removed task " + taskToRemove);
                    Toast.makeText(MainActivity.this, "You deleted : " + taskToRemove, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Log.e("ERROR","Unable to delete task with position on list: " + String.valueOf(position));

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add:{
                Log.i("INFO","You've checked add option");
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.delete:{
                Log.i("INFO","You've checked delete option");
                Intent intent = new Intent(getApplicationContext(),RemoveActivity.class);
                startActivity(intent);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
