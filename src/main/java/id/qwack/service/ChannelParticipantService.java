/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.ChannelParticipant;

/**
 *
 * @author fajar
 */
public class ChannelParticipantService {
    
  public void save(ChannelParticipant cp) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(cp);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchSave(List<ChannelParticipant> list) {
    for (ChannelParticipant live : list) {
      this.save(live);
    }
  }
  
  public List<ChannelParticipant> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelParticipant> list = (List<ChannelParticipant>) session.createQuery(
        "from ChannelParticipant").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }  
  
  public List<ChannelParticipant> getAllByChannel(Long cid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelParticipant> list = (List<ChannelParticipant>) session.createQuery(
        "from ChannelParticipant where channel_id=:cid").setParameter("cid", cid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }  
  
  public List<ChannelParticipant> getAllByParticipant(Long pid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelParticipant> list = (List<ChannelParticipant>) session.createQuery(
        "from ChannelParticipant where participant_id=:pid").setParameter("pid", pid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
    
  public List<ChannelParticipant> getAllByRole(Long rid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ChannelParticipant> list = (List<ChannelParticipant>) session.createQuery(
        "from ChannelParticipant where role_id=:rid").setParameter("rid", rid).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public ChannelParticipant findById(Long cid, Long pid) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    ChannelParticipant cp = (ChannelParticipant) session.createQuery(
        "from ChannelParticipant where channel_id=:cid and participant_id=:pid")
            .setParameter("cid", cid)
            .setParameter("pid", pid)
            .uniqueResult();
    session.getTransaction().commit();
    session.close();
    return cp;
  }

  public void delete(ChannelParticipant cp) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(cp);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByChannel(Long cid) {
    List<ChannelParticipant> list = this.getAllByChannel(cid);
    for (ChannelParticipant kill : list) {
      this.delete(kill);
    }
  }
  
  public void batchDeleteByParticipant(Long pid) {
    List<ChannelParticipant> list = this.getAllByChannel(pid);
    for (ChannelParticipant kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(ChannelParticipant cp) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        "update ChannelParticipant set role_id= :rid,"
                + "where channel_id=:cid and "
                + "participant_id=:pid")
            .setParameter("rid", cp.getRole().getId())
            .setParameter("cid", cp.getChannel().getId())
            .setParameter("pid", cp.getParticipant().getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  } 
}
