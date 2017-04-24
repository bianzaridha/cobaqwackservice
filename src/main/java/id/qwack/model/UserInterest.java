/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fajar
 */
@Entity
@Table(name="user_interest")
public class UserInterest implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name="participant_id",
                nullable = false, updatable = false)
    private Participant participant;
    
    @Id
    @ManyToOne
    @JoinColumn(name="tag_id",
                nullable = false, updatable = false)
    private Tag tag;

    public UserInterest(Participant participant, Tag tag) {
        this.participant = participant;
        this.tag = tag;
    }
    
    public UserInterest() {
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "UserInterest{" 
                + "participant=" + participant 
                + ", tag=" + tag 
                + '}';
    }
}
