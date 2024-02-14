package com.example.rmdatabase;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    Context ncontext;
    RecyclerView recyclerView2;
    Registrationdatabase db;
    List<Registrationmodel> fulllist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listrecycler);
       ncontext=this;
       recyclerView2=findViewById(R.id.recycler);
       recyclerView2.setLayoutManager(new LinearLayoutManager(ncontext));
       AsyncTaskExample asyncTask=new AsyncTaskExample();
        asyncTask.execute();
     }

    private class AsyncTaskExample extends AsyncTask<String, String, Void> {
    Registrationdatabase db;

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
        db = Registrationdatabase.getInstance(ncontext);
        Log.e("WORKING","CHECK");
        fulllist=new ArrayList();
        fulllist.clear();
        fulllist=db.reg().getRegistrationmodelList();
        Log.e("fulllist 534", String.valueOf(fulllist.size()));
       recyclerView2.setAdapter(new Listadapteractivity(fulllist,ncontext,db.reg()));
        return null;
    }
}
}