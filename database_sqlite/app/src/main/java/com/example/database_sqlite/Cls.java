package com.example.database_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class Cls extends SQLiteOpenHelper {

    //Database info
    public static String dbname="my_sqlite_db.db";
    public static String tabname="stuInfo";

    public static String col1="id";
    public static String col2="name";
    public static String col3="dep";

    public static int version=1;

    public Context c;

    SQLiteDatabase sqldb = this.getWritableDatabase();

    //query



    //other var

    public Cls(Context context) {
        super(context, dbname, null, version);
        this.c=context;

        Toast.makeText(context,"constructor",Toast.LENGTH_LONG).show();
        Log.v("sql1","constructor init");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String q="CREATE TABLE "+tabname+" ("+col1+" int PRIMARY Key,"+col2+" varchar(20) unique,"+col3+" varchar(10));";

        Log.v("sql1",q);

        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q="DROP TABLE IF EXISTS "+tabname;

        Log.v("sql1",q);

        db.execSQL(q);
        onCreate(db);
    }


    //create
    public void insert(String id, String name, String dep){

        String q="insert into "+tabname+" (id, name, dep) values"+" ("+id+",'"+name+"', '"+dep+"');";

        if(dep.isEmpty()){
            q="insert into "+tabname+" (id, name) values"+" ("+id+",'"+name+"');";
        }

        Log.v("sql1",q);
        Toast.makeText(c,"inserted",Toast.LENGTH_LONG).show();

        try{
            sqldb.execSQL(q);
        }
        catch (SQLException e){
            Log.v("sql1",e.toString());
        }
    }

    //read
    public Cursor read(String id){

        String q="select * from "+tabname+" where "+col1+"="+id+";";
        if(id.isEmpty()){
            q="select * from "+tabname+";";
        }

        Cursor cu=null;

        Log.v("sql1",q);
        Toast.makeText(c,"Read",Toast.LENGTH_LONG).show();

        try{
            cu=sqldb.rawQuery(q,null);
        }
        catch (SQLException e){
            Log.v("sql1",e.toString());
        }
        return cu;
    }

    //update
    public void update(String id, String name, String dep){

        String q="update "+tabname+" SET "+col2+" = '"+name+"', "+col3+"= '"+dep+"' where "+col1+"="+id+";";

        if(name.isEmpty()){
            q="update "+tabname+" SET "+col3+"= '"+dep+"' where "+col1+"="+id+";";
        }
        if(dep.isEmpty()){
            q="update "+tabname+" SET "+col2+"= '"+name+"' where "+col1+"="+id+";";
        }

        Log.v("sql1",q);
        Toast.makeText(c,"Update",Toast.LENGTH_LONG).show();

        try{
            sqldb.execSQL(q);
        }
        catch (SQLException e){
            Log.v("sql1",e.toString());
        }
    }

    //delete
    public void delete(String id){

        String q="delete from "+tabname+" where "+col1+"="+id+";";

        Log.v("sql1",q);
        Toast.makeText(c,"Delete",Toast.LENGTH_LONG).show();

        try{
            sqldb.execSQL(q);
        }
        catch (SQLException e){
            Log.v("sql1",e.toString());
        }
    }


}
