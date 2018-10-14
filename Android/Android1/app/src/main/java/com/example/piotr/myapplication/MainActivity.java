package com.example.piotr.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeText;
    private Button button;
    private EditText dishNameInput, emailInput, addressInput;
    private CheckBox doubleMeatInput;
    private RadioGroup cityInput;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setTextColor(Color.BLUE);
        welcomeText.setTextSize(24);
        emailInput = findViewById(R.id.emailInput);
        emailInput.setHint("Enter email");
        addressInput = findViewById(R.id.addressInput);
        addressInput.setHint("Enter address");
        dishNameInput = findViewById(R.id.dishNameInput);
        dishNameInput.setHint("Enter dish name");
        doubleMeatInput = findViewById(R.id.checkBox);
        cityInput = findViewById(R.id.radioCity);
        restoreValuesFromSecondView();
        button = findViewById(R.id.button);

        button.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), SecondView.class);
            RadioButton radioButton = cityInput.findViewById(cityInput.getCheckedRadioButtonId());

            String dishName = dishNameInput.getText().toString();
            intent.putExtra("dishName", dishName);
            Log.i("INFO", "Dish name: " + dishName);
            String addres = addressInput.getText().toString();
            intent.putExtra("address", addres);
            Log.i("INFO", "Address: " + addres);
            String email = emailInput.getText().toString();
            intent.putExtra("email", email);
            Log.i("INFO", "Email: " + email);

            boolean doubleMeatBoolean = doubleMeatInput.isChecked();
            String doubleMeat = Boolean.toString(doubleMeatBoolean);
            intent.putExtra("doubleMeat", doubleMeat);
            Log.i("INFO", "Boolean value of double meat: " + doubleMeatBoolean);

            intent.putExtra("city", radioButton.getText());
            Log.i("INFO", "City: " + radioButton.getText());
            startActivity(intent);
        });
    }

    private void restoreValuesFromSecondView() {
        Bundle bundle = getIntent().getExtras();
        if(bundle==null) {
            Log.i("INFO", "No values to restore");
            Log.i("INFO","Setting city value to default");
            ((RadioButton) cityInput.getChildAt(1)).setChecked(true);
            return;
        }
        String dishName=bundle.getString("dishName");
        Log.i("INFO","Received dishName from SecondVoew: "+dishName);
        dishNameInput.setText(dishName);
        String email=bundle.getString("email");
        Log.i("INFO","Received email from SecondVoew: "+email);
        emailInput.setText(email);
        String address=bundle.getString("address");
        Log.i("INFO","Received address from SecondVoew: "+address);
        addressInput.setText(address);
        String city=bundle.getString("city");
        Log.i("INFO","Received city from SecondVoew: "+city);
        int indexOfCheckedRadio;
        if(city.equals("Warsaw"))
            indexOfCheckedRadio=R.id.radioWarsaw;
        if(city.equals("Bialystok"))
            indexOfCheckedRadio=R.id.radioBialystok;
        else
            indexOfCheckedRadio=R.id.radioGdynia;
        cityInput.check(indexOfCheckedRadio);
        String isDoubleMeat =bundle.getString("isDoubleMeat");
        Log.i("INFO","Received isDoubleMeat from SecondVoew: "+isDoubleMeat);
        if(isDoubleMeat.equals("true"))
            doubleMeatInput.setChecked(true);
        else
            doubleMeatInput.setChecked(false);
    }
}
