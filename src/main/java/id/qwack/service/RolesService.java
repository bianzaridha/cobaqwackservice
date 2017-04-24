/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;
import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.Roles;


/**
 *
 * @author fajar
 */
public class RolesService {
    
  public void save(Roles role) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(role);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchSave(List<Roles> list) {
    for (Roles live : list) {
      this.save(live);
    }
  }
  
  public List<Roles> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Roles> list = (List<Roles>) session.createQuery(
        "from Roles").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public Roles findById(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    Roles rl = (Roles) session.createQuery(
        "from Roles where role_id=:id").setParameter("id", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return rl;
  }

  public void delete(Roles role) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(role);
    session.getTransaction().commit();
    session.close();
  }

  public void update(Roles role) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        "update Roles set name= :name "
                + "  where role_id=:id")
            .setParameter("name", role.getName())
            .setParameter("id", role.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  } 
}
