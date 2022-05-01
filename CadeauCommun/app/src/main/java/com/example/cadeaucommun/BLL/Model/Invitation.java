package com.example.cadeaucommun.BLL.Model;

public class Invitation {
    private static int auto_id = -1;
    private int id;
    private boolean rsvp;
    private Participant participant;
    private Evenement evenement;

    public Invitation(boolean rsvp, Participant p, Evenement e) {
        this.id = auto_id++;
        this.rsvp = rsvp;
        this.participant = p;
        this.evenement = e;
    }
    public Invitation(){ }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", rsvp=" + rsvp +
                ", participant=" + participant +
                ", evenement=" + evenement +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isComing() {
        return rsvp;
    }
    public void setRsvp(boolean rsvp) {
        this.rsvp = rsvp;
    }
    public Participant getParticipant() {
        return participant;
    }
    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
    public Evenement getEvenement() {
        return evenement;
    }
    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}
