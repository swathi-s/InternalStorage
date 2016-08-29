package com.example.user.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by user on 8/29/2016.
 */
public class ActivityB  extends AppCompatActivity{

    TextView loadUserName;
    TextView loadUserPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb_layout);

        loadUserName = (TextView) findViewById(R.id.loadedUserName);
        loadUserPassword = (TextView) findViewById(R.id.loadedPassword);
    }

    public void load(View view) {

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = openFileInput("swathi.txt");
            int read = -1;
            StringBuffer buffer =new StringBuffer();
            while((read = fileInputStream.read()) != -1)
            {
                buffer.append((char)read);
            }

            Log.d("swathi",buffer.toString());
            String text1 = buffer.substring(0,buffer.indexOf(" "));
            String text2 = buffer.substring(buffer.indexOf(" ")+1);

            loadUserName.setText(text1);
            loadUserPassword.setText(text2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this,"Load button has clicked", Toast.LENGTH_SHORT).show();
    }

    public void previous(View view) {

        Toast.makeText(this,"Previous button has clicked",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
