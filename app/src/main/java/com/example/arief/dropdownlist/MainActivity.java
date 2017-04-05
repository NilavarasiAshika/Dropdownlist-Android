package com.example.arief.dropdownlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button:
                //  mediasound.start();
                SqlDB bs=new SqlDB(this);
                String a=e1.getText().toString();


                bs.puttable(a);

                Toast.makeText(this,a, Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                startActivity(new Intent(this,Main2Activity.class));
                break;

        }

    }
}
