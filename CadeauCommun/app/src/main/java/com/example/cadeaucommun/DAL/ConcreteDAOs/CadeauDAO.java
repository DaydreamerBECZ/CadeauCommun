package com.example.cadeaucommun.DAL.ConcreteDAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cadeaucommun.BLL.Model.Cadeau;
import com.example.cadeaucommun.DAL.IDAO;
import com.example.cadeaucommun.DAL.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class CadeauDAO implements IDAO<Cadeau> {
    MyHelper myHelper;
    Context context;

    public CadeauDAO(Context context) {
        this.context = context;
        this.myHelper = new MyHelper(this.context);
    }

    @Override
    public void add(Cadeau cadeau) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", cadeau.getTitle());
        values.put("description", cadeau.getDescription());
        values.put("goal", cadeau.getGoal());
        db.insert("cadeau", null, values);
    }

    @Override
    public Cadeau findOne(int id) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM cadeau WHERE id = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        Cadeau cadeau = null;
        if(cursor !=null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            cadeau = new Cadeau();
            cadeau.setId(cursor.getInt(0));
            cadeau.setTitle(cursor.getString(1)); //title
            cadeau.setDescription(cursor.getString(2)); //description
            cadeau.setGoal(cursor.getDouble(3)); //goal
        }
        return cadeau;
    }

    @Override
    public List<Cadeau> findAll() {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM cadeau";
        Cursor cursor = db.rawQuery(sql, null);
        List<Cadeau> cadeaux = null;
        if(cursor !=null && cursor.getCount() > 0) {
            cadeaux = new ArrayList();
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                cursor.moveToFirst();
                Cadeau cadeau = new Cadeau();
                cadeau.setId(cursor.getInt(0));
                cadeau.setTitle(cursor.getString(1)); //title
                cadeau.setDescription(cursor.getString(2)); //description
                cadeau.setGoal(cursor.getDouble(3)); //goal
                cadeaux.add(cadeau);
                cursor.moveToNext();
            }
        }
        return cadeaux;
    }

    @Override
    public void update(Cadeau cadeau) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", cadeau.getTitle());
        values.put("description", cadeau.getDescription());
        values.put("goal", cadeau.getGoal());
        db.update("cadeau", values, "id=?", new String[]{cadeau.getId()+""});
    }

    @Override
    public void deleteById(int id) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        db.delete("cadeau", "id=?", new String[]{id+""});
    }
}
