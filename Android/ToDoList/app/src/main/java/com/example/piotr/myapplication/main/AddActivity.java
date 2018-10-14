package com.example.piotr.myapplication.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.*;

import com.example.piotr.myapplication.R;
import com.example.piotr.myapplication.model.Database;
import com.example.piotr.myapplication.model.Task;

public class AddActivity extends Activity {
    private EditText name, description;
    private TextView welcomeText;
    private Button addButton, returnButtonFromTaskAdding;
    Database database = Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        welcomeText = findViewById(R.id.addInformation);
        welcomeText.setText("Add new task ");
        welcomeText.setTextColor(Color.BLUE);
        welcomeText.setTextSize(24);

        name = findViewById(R.id.name);
        name.setHint("Enter task name");
        description = findViewById(R.id.description);
        description.setHint("Enter task description");
        addButton = findViewById(R.id.addButton);
        returnButtonFromTaskAdding =findViewById(R.id.returnButton);

        addButton.setOnClickListener((View view) -> {
            String nameFromForm = name.getText().toString();
            String descriptionFromForm = description.getText().toString();
            if(!nameFromForm.equals(nameFromForm.toUpperCase())){
                Toast.makeText(AddActivity.this, "Task name must contain only upper case letters" , Toast.LENGTH_SHORT).show();
                Log.w("WARN","Errors in form");
                return;
            }
            Task addedTask=new Task(nameFromForm,descriptionFromForm);
            database.setTask(addedTask);
            View parentLayout = findViewById(android.R.id.content);
            Log.i("INFO","Added new task " + addedTask);
            Snackbar.make(parentLayout, "Added new task: " + addedTask, Snackbar.LENGTH_LONG)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();
        });

        returnButtonFromTaskAdding.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Log.i("INFO","Returned to main activity");
            startActivity(intent);
        });
    }
}
