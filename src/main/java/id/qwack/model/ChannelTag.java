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
@Table(name="channel_tag")
public class ChannelTag implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name="channel_id",
                nullable = false, updatable = false)
    private Channel channel;
    
    @Id
    @ManyToOne
    @JoinColumn(name="tag_id",
                nullable = false, updatable = false)
    private Tag tag;

    public ChannelTag(Channel channel, Tag tag) {
        this.channel = channel;
        this.tag = tag;
    }
    
    public ChannelTag() {
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ChannelTag{" 
                + "channel=" + channel 
                + ", tag=" + tag 
                + '}';
    }
}
