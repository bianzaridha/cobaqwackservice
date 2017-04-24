/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.UserInterest;

/**
 *
 * @author fajar
 */
public class UserInterestService {
  
  public void save(UserInterest ui) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(ui);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchSave(List<UserInterest> list) {
      for (UserInterest live : list) {
          this.save(live);
      }
  }
  
  public List<UserInterest> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<UserInterest> list = (List<UserInterest>) session.createQuery(
        "from UserInterest").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<UserInterest> getAllByParticipant(Long pid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<UserInterest> list = (List<UserInterest>) session.createQuery(
        "from UserInterest where participant_id=:pid").setParameter("pid", pid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<UserInterest> getAllByTag(Long tid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<UserInterest> list = (List<UserInterest>) session.createQuery(
        "from UserInterest where tag_id=:tid").setParameter("tid", tid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public void delete(UserInterest ui) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(ui);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByParticipant(Long pid) {
    List<UserInterest> list = this.getAllByParticipant(pid);
    for (UserInterest kill : list) {
        this.delete(kill);
    }
  }
  
  public void batchDeleteByTag(Long tid) {
    List<UserInterest> list = this.getAllByTag(tid);
    for (UserInterest kill : list) {
        this.delete(kill);
    }
  }
}
