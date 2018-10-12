package com.example.souhi.capitales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {


    Button btnClic, btnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Toast.makeText(getApplicationContext(),"debut", Toast.LENGTH_SHORT);

btnClic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Intent i = new Intent(ChooseActivity.this, MainClicActivity.class);
//        startActivity(i);
//        finish();
    }
});

btnText.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(ChooseActivity.this, MainTextActivity.class);
//        startActivity(intent);
//        finish();
   }
});


    }
}
