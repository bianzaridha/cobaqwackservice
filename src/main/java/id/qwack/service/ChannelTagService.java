/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.ChannelTag;

/**
 *
 * @author fajar
 */
public class ChannelTagService {
  
  public void save(ChannelTag ct) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(ct);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchSave(List<ChannelTag> list) {
    for (ChannelTag live : list) {
      this.save(live);
    }
  }
  
  
  public List<ChannelTag> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelTag> list = (List<ChannelTag>) session.createQuery(
        "from ChannelTag").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<ChannelTag> getAllByChannel(Long cid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelTag> list = (List<ChannelTag>) session.createQuery(
        "from ChannelTag where channel_id=:cid").setParameter("cid", cid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
    
  public List<ChannelTag> getAllByTag(Long tid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelTag> list = (List<ChannelTag>) session.createQuery(
        "from ChannelTag where tag_id=:tid").setParameter("tid", tid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public void delete(ChannelTag ct) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(ct);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByChannel(Long cid) {
    List<ChannelTag> list = this.getAllByChannel(cid);
    for (ChannelTag kill : list) {
      this.delete(kill);
    }
  }
  
  public void batchDeleteByTag(Long tid) {
    List<ChannelTag> list = this.getAllByTag(tid);
    for (ChannelTag kill : list) {
      this.delete(kill);
    }
  }
}
