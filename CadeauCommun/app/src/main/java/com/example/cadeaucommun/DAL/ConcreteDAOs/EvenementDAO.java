package com.example.cadeaucommun.DAL.ConcreteDAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.cadeaucommun.BLL.Model.Evenement;
import com.example.cadeaucommun.DAL.IDAO;
import com.example.cadeaucommun.DAL.MyHelper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAO implements IDAO<Evenement> {
    MyHelper myHelper;
    Context context;

    public EvenementDAO(Context context) {
        this.context = context;
        this.myHelper = new MyHelper(this.context);
    }

    @Override
    public void add(Evenement evenement) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", evenement.getTitle());
        values.put("description", evenement.getDescription());
        values.put("beginDate", evenement.getBeginDate().toString());
        values.put("endDate", evenement.getEndDate().toString());
        db.insert("evenement", null, values);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Evenement findOne(int id) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM evenement WHERE id = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        Evenement evenement = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        if(cursor !=null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            evenement = new Evenement();
            evenement.setId(cursor.getInt(0));
            evenement.setTitle(cursor.getString(1)); //title
            evenement.setDescription(cursor.getString(2)); //description
            evenement.setBeginDate(LocalDate.parse(cursor.getString(3),formatter)); //beginning date
            evenement.setEndDate(LocalDate.parse(cursor.getString(4),formatter)); //beginning date
        }
        return evenement;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public List<Evenement> findMany(int id) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM evenement";
        Cursor cursor = db.rawQuery(sql, null);
        List<Evenement> evenements = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        if(cursor !=null && cursor.getCount() > 0) {
            evenements = new ArrayList();
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                cursor.moveToFirst();
                Evenement evenement = new Evenement();
                evenement.setId(cursor.getInt(0));
                evenement.setTitle(cursor.getString(1)); //title
                evenement.setDescription(cursor.getString(2)); //description
                evenement.setBeginDate(LocalDate.parse(cursor.getString(3),formatter)); //beginning date
                evenement.setEndDate(LocalDate.parse(cursor.getString(4),formatter));
                evenements.add(evenement);
                cursor.moveToNext();
            }
        }
        return evenements;
    }

    @Override
    public void update(Evenement evenement) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", evenement.getTitle());
        values.put("description", evenement.getDescription());
        values.put("beginDate", evenement.getBeginDate().toString());
        values.put("endDate", evenement.getEndDate().toString());
        db.update("evenement", values, "id=?", new String[]{evenement.getId()+""});
    }

    @Override
    public void deleteById(int id) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        db.delete("evenement", "id=?", new String[]{id+""});
    }
}
