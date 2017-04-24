/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.Participant;


/**
 *
 * @author fajar
 */
public class ParticipantService {
    
   public void save(Participant participant) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(participant);
    session.getTransaction().commit();
    session.close();
  }
   
  public void batchSave(List<Participant> list) {
    for (Participant live : list) {
      this.save(live);
    }
  }
  
  
  public List<Participant> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Participant> list = (List<Participant>) session.createQuery(
        "from Participant").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public Participant findById(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    Participant pr = (Participant) session.createQuery(
        "from Participant where participant_id=:id").setParameter("id", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return pr;
  }

  public void delete(Participant participant) {
    ChannelParticipantService cps = new ChannelParticipantService();
    cps.batchDeleteByParticipant(participant.getId());
    
    UserInterestService uis = new UserInterestService();
    uis.batchDeleteByParticipant(participant.getId());
    
    DataChatService dcs = new DataChatService();
    dcs.batchDeleteByParticipant(participant.getId());
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(participant);
    session.getTransaction().commit();
    session.close();
  }

  public void update(Participant participant) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        "update Participant set full_name= :fn,"
                + " email= :em,"
                + " username= :un,"
                + " password= :ps,"
                + " url_photo= :up,"
                + " online_status= :os"
                + "  where participant_id=:id")
            .setParameter("fn", participant.getName())
            .setParameter("em", participant.getEmail())
            .setParameter("un", participant.getUsername())
            .setParameter("ps", participant.getPassword())
            .setParameter("up", participant.getUrl_photo())
            .setParameter("os", participant.getOnline_status())
            .setParameter("id", participant.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
