/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fajar
 */
@Entity
@Table(name="data_chat")
public class DataChat implements Serializable {
    
    @Id
    @Column(name = "chat_id", nullable = false)
    private Long chat_id;
    
    @ManyToOne
    @JoinColumn(name="participant_id",
                nullable = false, updatable = false)
    @NotNull
    private Participant participant;

    @ManyToOne
    @JoinColumn(name="channel_id",
                nullable = false, updatable = false)
    @NotNull
    private Channel channel;
    
    @Column(name = "chat_mode")
    private Boolean chat_mode;
    
    @Column(name = "text")
    private String text;
    
    @Column(name = "url_file")
    private String url_file;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "pinned_status")
    private Boolean pinned_status;

    public DataChat(Long chat_id, Participant participant, Channel channel, Boolean chat_mode, String text, String url_file, Date date, Boolean pinned_status) {
        this.chat_id = chat_id;
        this.participant = participant;
        this.channel = channel;
        this.chat_mode = chat_mode;
        this.text = text;
        this.url_file = url_file;
        this.date = date;
        this.pinned_status = pinned_status;
    }
    
    public DataChat () {
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
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
    
    public Boolean getChat_mode() {
        return chat_mode;
    }

    public void setChat_mode(Boolean chat_mode) {
        this.chat_mode = chat_mode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl_file() {
        return url_file;
    }

    public void setUrl_file(String url_file) {
        this.url_file = url_file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPinned_status() {
        return pinned_status;
    }

    public void setPinned_status(Boolean pinned_status) {
        this.pinned_status = pinned_status;
    }

    @Override
    public String toString() {
        return "DataChat{" 
                + "chat_id=" + chat_id 
                + ", participant=" + participant 
                + ", channel=" + channel 
                + ", chat_mode=" + chat_mode 
                + ", text=" + text 
                + ", url_file=" + url_file 
                + ", date=" + date 
                + ", pinned_status=" + pinned_status 
                + '}';
    }
}
