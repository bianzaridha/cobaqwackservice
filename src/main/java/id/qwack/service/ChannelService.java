/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.Channel;

/**
 *
 * @author fajar
 */
public class ChannelService {
  
  public void save(Channel channel) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(channel);
    session.getTransaction().commit();
    session.close();
  }
     
  public void batchSave(List<Channel> list) {
    for (Channel live : list) {
      this.save(live);
    }
  }
  
  
  public List<Channel> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Channel> list = (List<Channel>) session.createQuery(
        "from Channel").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public Channel findById(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    Channel ch = (Channel) session.createQuery(
        "from Channel where channel_id=:id").setParameter("id", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return ch;
  }

  public void delete(Channel channel) {
    ChannelParticipantService cps = new ChannelParticipantService();
    cps.batchDeleteByChannel(channel.getId());
    
    ChannelTagService cts = new ChannelTagService();
    cts.batchDeleteByChannel(channel.getId());
    
    DataChatService dcs = new DataChatService();
    dcs.batchDeleteByChannel(channel.getId());
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(channel);
    session.getTransaction().commit();
    session.close();
  }

  public void update(Channel channel) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        "update Channel set name= :name, privacy_status= :ps where channel_id=:id")
            .setParameter("name", channel.getName())
            .setParameter("ps", channel.getPrivacyStatus())
            .setParameter("id", channel.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
