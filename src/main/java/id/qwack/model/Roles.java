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
@Table(name="roles")
public class Roles implements Serializable {
   
    @Id
    @Column(name = "role_id", nullable = false)
    private Long id;
    
    @Column(name = "name")
    private String name;

    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Roles() {
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

    @Override
    public String toString() {
        return "Roles{" 
                + "id=" + id 
                + ", name=" + name 
                + '}';
    }
}
