package com.example.rmdatabase;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


    @Database(entities = {Registrationmodel.class}, version = 1)
    public abstract class Registrationdatabase extends RoomDatabase {
        public abstract Registrationinterface reg();

        private static Registrationdatabase INSTANCE;

        public static Registrationdatabase getInstance(final Context context) {

            if (INSTANCE == null) {

                synchronized (Registrationdatabase.class) {

                    if (INSTANCE == null) {

                        INSTANCE = Room.databaseBuilder(
                                        context, Registrationdatabase.class, "REGISTRATION_DATABASE")
                                .fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }
    }
