package com.example.piotr.myapplication.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.piotr.myapplication.R;
import com.example.piotr.myapplication.model.Database;
import com.example.piotr.myapplication.model.Task;

public class RemoveActivity extends Activity {

    private EditText taskId;
    private TextView welcomeText;
    private Button deleteButton,returnButton;
    Database database = Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_activity);

        welcomeText = findViewById(R.id.removeInformation);
        welcomeText.setText("Delete task ");
        welcomeText.setTextColor(Color.BLUE);
        welcomeText.setTextSize(24);

        taskId = findViewById(R.id.taskId);
        taskId.setHint("Enter task id");
        Log.i("INFO","Entered task id " + taskId.getText());
        deleteButton = findViewById(R.id.removeButton);
        returnButton=findViewById(R.id.returnButtonFromTaskDelete);

        deleteButton.setOnClickListener((View view) -> {
            String taskIdFromForm = taskId.getText().toString();
            Task taskToDelete;
            try {
                taskToDelete= database.getTaskBasedOnTask(Integer.parseInt(taskIdFromForm));
            }
            catch (Exception e)
            {
                Toast.makeText(RemoveActivity.this, "Unable to find task with id " + taskIdFromForm , Toast.LENGTH_SHORT).show();
                Log.e("ERROR","Unable to find task with id " + taskIdFromForm,e);
                return;
            }
            try {
                database.deleteTaskIdBasedOnTask(Integer.parseInt(taskIdFromForm));
            }
            catch (Exception e)
            {
                Log.e("ERROR","Unable to delete task with id " + taskIdFromForm);
            }
            View parentLayout = findViewById(android.R.id.content);
            Log.w("WARN","Deleted task " + taskToDelete);
            Snackbar.make(parentLayout, "Deleted  task: " + taskToDelete, Snackbar.LENGTH_LONG)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();
        });

        returnButton.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Log.i("INFO","Returned to main activity");
            startActivity(intent);
        });
    }
}
