package com.example.piotr.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondView extends Activity {
    private TextView dishNameOutput, emailOutput, addressOutput, cityOutput, doubleMeatOutput;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Bundle bundle = getIntent().getExtras();

        dishNameOutput=findViewById(R.id.dishNameOutput);
        String dishNameFromForm=bundle.getString("dishName");
        dishNameOutput.setText("Dish name: " + dishNameFromForm);

        emailOutput=findViewById(R.id.emailOutput);
        String emailFromForm=bundle.getString("email");
        emailOutput.setText("Email: " + emailFromForm);

        addressOutput=findViewById(R.id.addressOutput);
        String addressFromForm=bundle.getString("address");
        addressOutput.setText("Address: "  + addressFromForm);

        cityOutput=findViewById(R.id.cityOutput);
        String cityFromForm=bundle.getString("city");
        cityOutput.setText("City: "+cityFromForm);

        doubleMeatOutput=findViewById(R.id.doubleMeatOutput);
        String doubleMeatFromForm=bundle.getString("doubleMeat");
        if(doubleMeatFromForm.equals("true"))
        doubleMeatOutput.setText("With double meat");
        else
            doubleMeatOutput.setText("Without double meat");

        returnButton=findViewById(R.id.returnButton);
        returnButton.setOnClickListener((View view)->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("dishName",dishNameFromForm);
            intent.putExtra("email",emailFromForm);
            intent.putExtra("address",addressFromForm);
            intent.putExtra("city",cityFromForm);
            intent.putExtra("isDoubleMeat",doubleMeatFromForm);
            startActivity(intent);
        });
    }
}
