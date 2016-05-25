package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liguochao on 2016/5/22.
 */
public class DBOperate {
    ArrayList<PersonMessage> list ;
    public boolean createPerson(Context context , String userName , String smallName
                                , String photoName, String sex , int age, int height
                                , int weight, double trl , double tbl    ){
        String name = "person.db" ;
        PersonDBHelper helper ;
        SQLiteDatabase db ;
        String databasePath = "/data/data/com.example.liguochao.cuberunning/databases/"+name ;
        if(new File(databasePath).exists()){
            Log.d("DB", "file is exits!" ) ;
            db = SQLiteDatabase.openDatabase(databasePath,null,0) ;
        } else {
            Log.d("DB", "file is not exits!" ) ;
            helper = new PersonDBHelper(context,name,null,1) ;
            db = helper.getWritableDatabase() ;
        }

        String dbPath = db.getPath() ;
        Log.d("DB", "db path is " + dbPath);

        ContentValues values = new ContentValues() ;

        values.put(Person.getNAME(),userName);
        values.put(Person.getSMALLNAME(),smallName);
        values.put(Person.getPHOTO(),photoName);
        values.put(Person.getSEX(),sex);
        values.put(Person.getAGE(),age);
        values.put(Person.getHEIGHT(),height);
        values.put(Person.getWEIGTH(),weight);
        values.put(Person.getTBL(), 0);
        values.put(Person.getTRL(), 0);

        long newRowId;
        newRowId = db.insert(Person.getTableName(),null,values) ;
        return  true ;
    }

    public ArrayList<PersonMessage> queryMessage(Context context ,  String userName){
        String name = "person.db" ;
        PersonDBHelper helper ;
        SQLiteDatabase db ;
        String databasePath = "/data/data/com.example.liguochao.cuberunning/databases/"+name ;
        if(new File(databasePath).exists()){
            Log.d("DB", "IN queryMessage file is exits!" ) ;
            db = SQLiteDatabase.openDatabase(databasePath,null,0) ;
        } else {
            return null ;
        }
       list = new ArrayList<>() ;
        long newRowId;
        Cursor cursor = db.query(Person.getTableName(), null, null, null, null, null, null) ;
        cursor.moveToFirst() ;
        String [] names = cursor.getColumnNames() ;
        for(int i = 0 ; i < names.length ; i++ ){
            Log.d("DBOperate",names[i]) ;
        }
        int i = 0 ;
        cursor.moveToFirst() ;
        list.add(new PersonMessage(Person.getNAME(), cursor.getString(cursor.getColumnIndexOrThrow(Person.getNAME())))) ;
        list.add(new PersonMessage(Person.getSMALLNAME(), cursor.getString(cursor.getColumnIndexOrThrow(Person.getSMALLNAME())))) ;
        list.add(new PersonMessage(Person.getPHOTO() , cursor.getString(cursor.getColumnIndexOrThrow(Person.getPHOTO())))) ;
        list.add(new PersonMessage(Person.getSEX() , cursor.getString(cursor.getColumnIndexOrThrow(Person.getSEX())))) ;
        Integer temInt =  cursor.getInt(cursor.getColumnIndexOrThrow(Person.getAGE())) ;
        list.add(new PersonMessage(Person.getAGE() , temInt.toString())) ;
        temInt = cursor.getInt(cursor.getColumnIndexOrThrow(Person.getHEIGHT())) ;
        list.add(new PersonMessage(Person.getHEIGHT() , temInt.toString())) ;
        temInt = cursor.getInt(cursor.getColumnIndexOrThrow(Person.getWEIGTH())) ;
        list.add(new PersonMessage(Person.getWEIGTH() , temInt.toString())) ;
        Double temDouble = cursor.getDouble(cursor.getColumnIndexOrThrow(Person.getTRL())) ;
        list.add(new PersonMessage(Person.getTRL() , temDouble.toString())) ;
        temDouble = cursor.getDouble(cursor.getColumnIndexOrThrow(Person.getTBL())) ;
        list.add(new PersonMessage(Person.getTBL() , temDouble.toString())) ;
        return list ;
    }

    public void updateTRL(Context context , String userName, double trl){
        String tableName = "person.db" ;
        String databasePath = "/data/data/com.example.liguochao.cuberunning/databases/"+tableName ;
        if(! new File(databasePath).exists()){
            return;
        }
        ContentValues values = new ContentValues() ;
        values.put(Person.getTRL(),trl);
        SQLiteDatabase db = SQLiteDatabase.openDatabase(databasePath,null,0) ;
        db.update(tableName,values,Person.getNAME()+"="+userName,null) ;
    }
}
