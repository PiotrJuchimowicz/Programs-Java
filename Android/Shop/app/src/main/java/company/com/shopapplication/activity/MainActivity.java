package company.com.shopapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import company.com.shopapplication.R;
import company.com.shopapplication.model.Shop;

public class MainActivity extends AppCompatActivity {
    private Button exitButton;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleExitButton();
        handleProceedButton();
    }

    public void handleProceedButton(){
        Button proceedButton =  findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), ProductsListActivity.class);
            startActivity(intent);
        });
    }

    public void handleExitButton(){
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> System.exit(0));
    }
}
