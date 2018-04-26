package com.example.amansingh.loginsignup_filesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity{

    EditText name,pass,email;
    RadioGroup sex;
    RadioButton gender;
    String Gender;
    Button register;
    String Filename = "file2.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.username1);
        pass = (EditText)findViewById(R.id.password1);
        email = (EditText)findViewById(R.id.email1);
        sex = (RadioGroup)findViewById(R.id.radioSex1);
        register = (Button)findViewById(R.id.register1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.length() != 0 && pass.length() != 0 && email.length() != 0) {
                    gender = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                    Gender = gender.getText().toString();
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = openFileOutput(Filename, MODE_PRIVATE);
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                        writer.write(" "+name.getText().toString()+","+pass.getText().toString()+","+email.getText().toString()+","+Gender+";");
                        writer.close();
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, "User Regsitered in File Succesfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
               /*try
               {
                     FileInputStream fileInputStream = openFileInput(Filename);
                   InputStreamReader reader = new InputStreamReader(fileInputStream);

                   int c;
                   while((c=reader.read())!=-1)
                   {
                        text = text + (char)c;
                   }
                   reader.close();
                   textto.setText(text);
                   Toast.makeText(MainActivity.this, "File Read !", Toast.LENGTH_SHORT).show();
               }
               catch (FileNotFoundException e)
               {
                   e.printStackTrace();
               }
               catch (IOException e)
               {
                   e.printStackTrace();
               }*/

