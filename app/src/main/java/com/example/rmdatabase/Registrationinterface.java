package com.example.rmdatabase;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Registrationinterface {



        @Query("SELECT * FROM Employee_table")
         List<Registrationmodel>  getRegistrationmodelList();
        @Insert
        void insert(Registrationmodel models);

        @Query("DELETE FROM Employee_table WHERE id = :id")
        abstract  void deletee(String id);

        @Update
        void update(Registrationmodel model);


}
