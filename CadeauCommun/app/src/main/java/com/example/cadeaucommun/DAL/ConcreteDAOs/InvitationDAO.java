package com.example.cadeaucommun.DAL.ConcreteDAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import androidx.annotation.RequiresApi;

import com.example.cadeaucommun.BLL.Model.Evenement;
import com.example.cadeaucommun.BLL.Model.Invitation;
import com.example.cadeaucommun.DAL.IDAO;
import com.example.cadeaucommun.DAL.MyHelper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InvitationDAO implements IDAO<Invitation> {
    MyHelper myHelper;
    Context context;

    ParticipantDAO pDAO = new ParticipantDAO();
    EvenementDAO eDAO = new EvenementDAO();

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Invitation findOne(int id) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM invitation WHERE id = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        Invitation invitation = null;
        if(cursor !=null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            invitation = new Invitation();
            invitation.setId(cursor.getInt(0));
            invitation.setRsvp(Boolean.parseBoolean(cursor.getString(1)));
            invitation.setParticipant(pDAO.findOne(cursor.getInt(2)));
            invitation.setEvenement(eDAO.findOne(cursor.getInt(3)));
        }
        return invitation;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public List<Invitation> findMany(int id) {
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        String sql = "SELECT * FROM invitation";
        Cursor cursor = db.rawQuery(sql, null);
        List<Invitation> invitations = null;
        if(cursor !=null && cursor.getCount() > 0) {
            invitations = new ArrayList();
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                cursor.moveToFirst();
                Invitation invitation = new Invitation();
                invitation.setId(cursor.getInt(0));
                invitation.setRsvp(Boolean.parseBoolean(cursor.getString(1)));
                invitation.setParticipant(pDAO.findOne(cursor.getInt(2)));
                invitation.setEvenement(eDAO.findOne(cursor.getInt(3)));
                invitations.add(invitation);
                cursor.moveToNext();
            }
        }
        return invitations;
    }

    @Override
    public void update(Invitation invitation) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rsvp", invitation.isComing());
        values.put("participantID", invitation.getParticipant().getId());
        values.put("eventID", invitation.getEvenement().getId());
        db.update("invitation", values, "id=?", new String[]{invitation.getId()+""});
    }

    @Override
    public void deleteById(int id) {
        SQLiteDatabase db = this.myHelper.getWritableDatabase();
        db.delete("invitation", "id=?", new String[]{id+""});
    }
}
