package com.glucozo.android_jetpack.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.glucozo.android_jetpack.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun getTaskDao():TaskDao

//    companion object {  // singleton pattern
//        private var instance : TaskDatabase? = null
//
//        @Synchronized
//        fun getInstance(ctx: Context):TaskDatabase{
//            if (instance == null){
//                //builder pattern
//                instance = Room.databaseBuilder(
//                    ctx.applicationContext,
//                    TaskDatabase::class.java,
//                    "task.db"
//                )
////                    .allowMainThreadQueries() //only for tetting, remove on production
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//            return instance!!
//        }
//    }
}