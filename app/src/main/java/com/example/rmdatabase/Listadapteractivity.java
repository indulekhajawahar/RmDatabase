package com.example.rmdatabase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Listadapteractivity extends RecyclerView.Adapter<Listadapteractivity.ViewHolder> {

    private List<Registrationmodel> flist;
    private Context mContext;
    private Registrationinterface db;


    public Listadapteractivity(List<Registrationmodel> flist, Context ncontext, Registrationinterface db) {
        this.flist = flist;
        this.mContext = ncontext;
        this.db = db;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_list, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        Log.e("Araay Size", String.valueOf(flist.size()));
        Log.e("Araay Size", String.valueOf(flist));
        viewHolder.id.setText(String.valueOf(flist.get(position).getId()));
        viewHolder.name.setText(flist.get(position).getName());
        viewHolder.designation.setText(flist.get(position).getDesignation());
        String idvalue = String.valueOf(flist.get(position).getId());
        viewHolder.delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("idvalue",String.valueOf(idvalue));
               AsyncTaskExample asyncTask = new AsyncTaskExample(position,idvalue);
                asyncTask.execute();
            }
        });
    }

    @Override
    public int getItemCount() {
        return flist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView designation;
        ImageButton delbutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id1);
            name = itemView.findViewById(R.id.name1);
            designation = itemView.findViewById(R.id.desgntn1);
            delbutton = itemView.findViewById(R.id.delbutton);
        }
    }

    private class AsyncTaskExample extends AsyncTask<String, String, Void> {

        int post;
        String exm;
        private AsyncTaskExample(int position, String yy) {
            this.post=position;
            this.exm=yy;
        }
            @Override
            protected void onPreExecute () {
                super.onPreExecute();
                /*p = new ProgressDialog(MainActivity.this);
                p.setMessage("Please wait...");
                p.setIndeterminate(false);
                p.setCancelable(false);
                p.show();*/
            }
            @Override
            protected Void doInBackground (String...strings){
                db.deletee(exm);
                flist.remove(post);
                return null;
            }
        }}


