package com.example.rmdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ids;
    EditText names;
    EditText desgs;
    String nam;
    String des;
    String id;
    Context mcontext;
    Registrationdatabase db;
    ProgressDialog p;
    int primaryID=11;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ids = findViewById(R.id.id);
        names = findViewById(R.id.name);
        desgs = findViewById(R.id.designation);
        mcontext = this;
        button2=findViewById(R.id.button2);

        db = Room.databaseBuilder(getApplicationContext(),
                Registrationdatabase.class, "REGISTRATION_DATABASE").build();


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryID=primaryID+1;
                AsyncTaskExample asyncTask=new AsyncTaskExample();
                asyncTask.execute();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

        private class AsyncTaskExample extends AsyncTask<String, String, Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
               /* p = new ProgressDialog(MainActivity.this);
                p.setMessage("Please wait...");
                p.setIndeterminate(false);
                p.setCancelable(false);
                p.show();*/
            }
            @Override
            protected Void doInBackground(String... strings) {
                nam = names.getText().toString();
                des = desgs.getText().toString();
                id = ids.getText().toString();

                db = Registrationdatabase.getInstance(mcontext);
                Registrationmodel models = new Registrationmodel(Integer.valueOf(id), nam, des);
                db.reg().insert(models);
               // List<Registrationmodel> fulllist=db.reg().getRegistrationmodelList();
               // Log.e("fulllist",String.valueOf(fulllist.size()));
                //db.reg().delete(models);
                return null;
            }

        }
    }
