/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fajar
 */
@Entity
@Table(name="channel")
public class Channel implements Serializable {
    
    @Id
    @Column(name = "channel_id", nullable = false)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "privacy_status")
    private Boolean privacyStatus;
    

    public Channel(Long id, String name, Boolean privacyStatus) {
        this.id = id;
        this.name = name;
        this.privacyStatus = privacyStatus;
    }

    public Channel() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPrivacyStatus() {
        return privacyStatus;
    }

    public void setPrivacyStatus(Boolean privacyStatus) {
        this.privacyStatus = privacyStatus;
    }

    @Override
    public String toString() {
        return "Channel{" 
                + "id=" + id 
                + ", name=" + name 
                + ", privacyStatus=" + privacyStatus 
                + '}';
    }
    
}
