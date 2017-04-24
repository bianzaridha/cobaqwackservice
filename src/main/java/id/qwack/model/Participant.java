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
@Table(name="participant")
public class Participant implements Serializable {
    
    @Id
    @Column(name = "participant_id", nullable = false)
    private Long id;
    
    @Column(name = "full_name")
    private String name;
        
    @Column(name = "email")
    private String email;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "url_photo")
    private String url_photo;
    
    @Column(name = "online_status")
    private Boolean online_status;

    public Participant(Long id, String name, String email, String username, String password, String url_photo, Boolean online_status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.url_photo = url_photo;
        this.online_status = online_status;
    }
    
    public Participant() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public Boolean getOnline_status() {
        return online_status;
    }

    public void setOnline_status(Boolean online_status) {
        this.online_status = online_status;
    }

    @Override
    public String toString() {
        return "Participant{" 
                + "id=" + id 
                + ", name=" + name 
                + ", email=" + email 
                + ", username=" + username 
                + ", password=" + password 
                + ", url_photo=" + url_photo 
                + ", online_status=" + online_status 
                + '}';
    }
}
