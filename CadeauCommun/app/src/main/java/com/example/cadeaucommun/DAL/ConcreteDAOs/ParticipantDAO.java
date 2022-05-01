package com.example.cadeaucommun.DAL.ConcreteDAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.cadeaucommun.BLL.Model.Participant;
import com.example.cadeaucommun.DAL.IDAO;
import com.example.cadeaucommun.DAL.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO implements IDAO<Participant> {
    MyHelper myHelper;
    Context context;

    public ParticipantDAO(Context context) {
        this.context = context;
        this.myHelper = new MyHelper(this.context);
    }


    @Override
    public void add(Participant participant) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("firstName", participant.getfName());
        values.put("lastName", participant.getlName());
        values.put("username", participant.getUsername());
        values.put("password", participant.getPassword());
        values.put("image", participant.getImage());
        db.insert("participant", null, values);
    }

    @Override
    public Participant findOne(int anId) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM participant WHERE id = " + anId;
        Cursor cursor = db.rawQuery(sql, null);
        Participant participant = null;
        if(cursor !=null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            participant = new Participant();
            participant.setId(cursor.getInt(0));
            participant.setfName(cursor.getString(1)); //first name
            participant.setlName(cursor.getString(2)); //last name
            participant.setUsername(cursor.getString(3)); //username
            participant.setPassword(cursor.getString(4)); //password
            participant.setImage(cursor.getString(5)); //profile picture link
        }
        return participant;
    }

    public Participant findParticipantByUsername(String aUsername) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM participant WHERE username = " + '\"' + aUsername + '\"';
        Cursor cursor = db.rawQuery(sql, null);
        Participant participant = null;
        if(cursor !=null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            participant = new Participant();
            participant.setId(cursor.getInt(0));
            participant.setfName(cursor.getString(1)); //first name
            participant.setlName(cursor.getString(2)); //last name
            participant.setUsername(cursor.getString(3)); //username
            participant.setPassword(cursor.getString(4)); //password
            participant.setImage(cursor.getString(5)); //profile picture link
        }
        return participant;
    }

    public Participant findParticipantByPassword(String aPassword) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM participant WHERE password = " + '\"' + aPassword + '\"';
        Cursor cursor = db.rawQuery(sql, null);
        Participant participant = null;
        if(cursor !=null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            participant = new Participant();
            participant.setId(cursor.getInt(0));
            participant.setfName(cursor.getString(1)); //first name
            participant.setlName(cursor.getString(2)); //last name
            participant.setUsername(cursor.getString(3)); //username
            participant.setPassword(cursor.getString(4)); //password
            participant.setImage(cursor.getString(5)); //profile picture link
        }
        return participant;
    }

    //public Participant findByUserNameAndPassword()

    @Override
    public List<Participant> findMany(int id) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM participant";
        Cursor cursor = db.rawQuery(sql, null);
        List<Participant> participants = null;
        if(cursor !=null && cursor.getCount() > 0) {
            participants = new ArrayList();
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                Participant participant = new Participant();
                participant.setId(cursor.getInt(0));
                participant.setfName(cursor.getString(1)); //first name
                participant.setlName(cursor.getString(2)); //last name
                participant.setUsername(cursor.getString(3)); //username
                participant.setPassword(cursor.getString(4)); //password
                participant.setImage(cursor.getString(5)); //profile picture link
                participants.add(participant);
                cursor.moveToNext();
            }
        }
        return participants;
    }

    @Override
    public void update(Participant participant) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("firstName", participant.getfName());
        values.put("lastName", participant.getlName());
        values.put("username", participant.getUsername());
        values.put("password", participant.getPassword());
        values.put("image", participant.getImage());
        db.update("participant", values, "id=?", new String[]{participant.getId()+""});
    }

    @Override
    public void deleteById(int id) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        db.delete("participant", "id=?", new String[]{id+""});
    }
}
