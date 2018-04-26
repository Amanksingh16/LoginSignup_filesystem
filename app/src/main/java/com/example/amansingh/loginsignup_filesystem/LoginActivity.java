package com.example.amansingh.loginsignup_filesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class LoginActivity extends AppCompatActivity {

    EditText name , pass;
    Button login;
    String Filename = "file2.txt";
    int count = 0;
    int trial = 0;
    String user = "", password = "" , email = "",gender= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText)findViewById(R.id.user1);
        pass = (EditText)findViewById(R.id.pass1);
        login = (Button)findViewById(R.id.login1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = openFileInput(Filename);
                    InputStreamReader reader = new InputStreamReader(fileInputStream);
                    int c;
                    while((c = reader.read()) != -1)
                    {
                        while ((char)(c = reader.read()) != ';')
                        {
                            if (((char) c) == ',')
                            {
                                count++;
                            }
                            if (count == 0)
                            {
                                user = user + (char) c;
                            }
                            if (count == 1)
                            {
                                password = password + (char) c;
                            }
                            if (count == 2)
                            {
                                email = email + (char) c;
                            }
                            if (count == 3)
                            {
                                gender = gender + (char) c;
                            }
                        }
                        Log.i("name", "" + user);
                        Log.i("pass", "" + password);
                        Log.i("email", "" + email);

                        password = password.substring(1);
                        email = email.substring(1);
                        gender = gender.substring(1);
                            if (user.equals(name.getText().toString()))
                            {
                                if (password.equalsIgnoreCase(pass.getText().toString()))
                                {
                                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(LoginActivity.this,Home.class);
                                    i.putExtra("user",user);
                                    i.putExtra("email",email);
                                    i.putExtra("gender",gender);
                                    startActivity(i);
                                    finish();
                                    break;
                                }
                                else
                                    {
                                    Toast.makeText(LoginActivity.this, "Your Password is incorrect", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                           trial++;
                          }
                    reader.close();
                    Toast.makeText(LoginActivity.this, "trial"+trial, Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this, "File Read Succesfully", Toast.LENGTH_SHORT).show();
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
