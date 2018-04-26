package com.example.amansingh.loginsignup_filesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    Intent i;
    ListView details;
    ArrayAdapter <String> adapter;
    Button edit , logout;
    ArrayList<String> list;
    String name , email , gender;
    String det[] = {"","",""};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        details = (ListView)findViewById(R.id.details);
        edit = (Button)findViewById(R.id.edit);
        logout = (Button)findViewById(R.id.logout);

        i = getIntent();
        if(i.hasExtra("user")&&i.hasExtra("user")&&i.hasExtra("user"))
        {
            name = i.getStringExtra("user");
            email = i.getStringExtra("email");
            gender = i.getStringExtra("gender");
            Log.i("a",""+name);
            det = new String[]{"Name : " + name, "Email : " + email, "Gender : " + gender};
        }

        adapter = new ArrayAdapter<String>(Home.this,android.R.layout.simple_list_item_1,det);
        details.setAdapter(adapter);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Home.this,edit_details.class);
                intent.putExtra("user",name);
                intent.putExtra("email",email);
                intent.putExtra("gender",gender);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                 Intent i = new Intent(Home.this,LoginActivity.class);
                 startActivity(i);
                Toast.makeText(Home.this, "Logout Succesfully !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
