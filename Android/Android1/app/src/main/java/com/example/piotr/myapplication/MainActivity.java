package com.example.piotr.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private EditText dishNameInput,emailInput,addressInput;
    private CheckBox doubleMeatInput;
    private RadioGroup cityInput;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText=findViewById(R.id.welcomeText);
        welcomeText.setTextColor(Color.BLUE);
        welcomeText.setTextSize(24);
        emailInput=findViewById(R.id.emailInput);
        emailInput.setHint("Enter email");
        addressInput=findViewById(R.id.addressInput);
        addressInput.setHint("Enter address");
        dishNameInput=findViewById(R.id.dishNameInput);
        dishNameInput.setHint("Enter dish name");
        doubleMeatInput =findViewById(R.id.checkBox);
        cityInput =findViewById(R.id.radioCity);
        button =findViewById(R.id.button);

        button.setOnClickListener((View view)->{
            Intent intent = new Intent(getApplicationContext(), SecondView.class);
            RadioButton radioButton = cityInput.findViewById(cityInput.getCheckedRadioButtonId());

            String dishName = dishNameInput.getText().toString();
            intent.putExtra("dishName", dishName);
            String addres=addressInput.getText().toString();
            intent.putExtra("address",addres);
            String email = emailInput.getText().toString();
            intent.putExtra("email",email);

            boolean doubleMeatBoolean = doubleMeatInput.isChecked();
            String doubleMeat=Boolean.toString(doubleMeatBoolean);
            intent.putExtra("doubleMeat", doubleMeat);


            intent.putExtra("city",radioButton.getText());
            startActivity(intent);
        });
    }
}
