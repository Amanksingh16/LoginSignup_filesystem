package com.example.amansingh.loginsignup_filesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class edit_details extends AppCompatActivity {

    EditText name , email;
    Button save;
    RadioGroup sex;
    RadioButton gender;
    String Gender;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        name = (EditText)findViewById(R.id.editText1);
        email = (EditText)findViewById(R.id.editText2);;
        sex = (RadioGroup)findViewById(R.id.radioSex2);
        save = (Button)findViewById(R.id.save);
        i = getIntent();

        name.setText(i.getStringExtra("user"));
        email.setText(i.getStringExtra("email"));

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                gender = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                Gender = gender.getText().toString();
                Intent intent = new Intent(edit_details.this,Home.class);
                intent.putExtra("user", name.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("gender", Gender);
                Toast.makeText(edit_details.this, "Details Edited", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
