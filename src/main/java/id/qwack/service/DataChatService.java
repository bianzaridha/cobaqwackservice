/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.DataChat;


/**
 *
 * @author fajar
 */
public class DataChatService {
  
  public void save(DataChat dc) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(dc);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchSave(List<DataChat> list) {
    for (DataChat live : list) {
      this.save(live);
    }
  }
  
  public List<DataChat> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<DataChat> list = (List<DataChat>) session.createQuery(
        "from DataChat").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<DataChat> getAllByChannel(Long cid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<DataChat> list = (List<DataChat>) session.createQuery(
        "from DataChat where channel_id=:cid").setParameter("cid", cid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<DataChat> getAllByParticipant(Long pid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<DataChat> list = (List<DataChat>) session.createQuery(
        "from DataChat where participant_id=:pid").setParameter("pid", pid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public DataChat findById(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    DataChat tg = (DataChat) session.createQuery(
        "from DataChat where chat_id=:id").setParameter("id", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return tg;
  }

  public void delete(DataChat dc) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(dc);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByChannel(Long cid) {
    List<DataChat> list = this.getAllByChannel(cid);
    for (DataChat kill : list) {
      this.delete(kill);
    }
  }
  
  public void batchDeleteByParticipant(Long pid) {
    List<DataChat> list = this.getAllByParticipant(pid);
    for (DataChat kill : list) {
      this.delete(kill);
    }
  }
}
