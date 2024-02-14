package com.example.rmdatabase;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "Employee_table")
public class Registrationmodel  {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String designation;

    public Registrationmodel(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
