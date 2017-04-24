/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fajar
 */
@Entity
@Table(name="channel_participant")
public class ChannelParticipant implements Serializable {
  
    @Id
    @ManyToOne
    @JoinColumn(name="participant_id",
                nullable = false, updatable = false)
    private Participant participant;
    
    @Id
    @ManyToOne
    @JoinColumn(name="channel_id",
                nullable = false, updatable = false)
    private Channel channel;

    @ManyToOne
    @JoinColumn(
        name = "role_id",
        updatable = false)
    @NotNull // Doesn't generate SQL constraint, so not part of the PK!
    private Roles role;

    public ChannelParticipant(Participant participant, Channel channel, Roles role) {
        this.participant = participant;
        this.channel = channel;
        this.role = role;
    }

    public ChannelParticipant() {
    }
    
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
    
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ChannelParticipant{" 
                + "participant=" + participant 
                + ", channel=" + channel 
                + ", role=" + role 
                + '}';
    }    
}
