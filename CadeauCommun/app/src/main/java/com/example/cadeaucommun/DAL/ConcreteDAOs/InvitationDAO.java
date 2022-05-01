package com.example.cadeaucommun.DAL.ConcreteDAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cadeaucommun.BLL.Model.Invitation;
import com.example.cadeaucommun.DAL.IDAO;
import com.example.cadeaucommun.DAL.MyHelper;

import java.util.List;

public class InvitationDAO implements IDAO<Invitation> {
    MyHelper myHelper;
    Context context;

    public InvitationDAO(Context context) {
        this.context = context;
        this.myHelper = new MyHelper(this.context);
    }

    @Override
    public void add(Invitation invitation) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rsvp", invitation.isComing());
        values.put("participantID", invitation.getParticipant().getId());
        values.put("eventID", invitation.getEvenement().getId());
        db.insert("invitation", null, values);
    }

    @Override
    public Invitation findOne(int id) {
        return null;
    }

    @Override
    public List<Invitation> findMany(int id) {
        return null;
    }

    @Override
    public void update(Invitation invitation) {

    }

    @Override
    public void deleteById(int id) {

    }
}
