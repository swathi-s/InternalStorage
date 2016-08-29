package com.example.user.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void save(View view) {

        String text1 = userName.getText().toString();
        String text2 = password.getText().toString();
        File file = null;
        text1 = text1+" ";
        FileOutputStream fileOutputStream = null;
        try {
            file = getFilesDir();
            fileOutputStream = openFileOutput("swathi.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());

        } catch (FileNotFoundException e) {
            Log.d("error",e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("error",e.toString());
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,"user details has been updated successfully "+file+ "/swathi.txt",Toast.LENGTH_SHORT).show();

    }

    public void next(View view) {

        Toast.makeText(this,"Go to B button has clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);
    }
}
