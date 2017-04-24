/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.service;

import java.util.List;

import org.hibernate.Session;

import id.qwack.configuration.HibernateUtil;
import id.qwack.model.Tag;

/**
 *
 * @author fajar
 */
public class TagService {
  
  public void save(Tag tag) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(tag);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchSave(List<Tag> list) {
    for (Tag live : list) {
      this.save(live);
    }
  }
  
  
  public List<Tag> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Tag> list = (List<Tag>) session.createQuery(
        "from Tag").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }

  public Tag findById(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    Tag tg = (Tag) session.createQuery(
        "from Tag where tag_id=:id").setParameter("id", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return tg;
  }

  public void delete(Tag tag) {
    ChannelTagService cts = new ChannelTagService();
    cts.batchDeleteByTag(tag.getId());
    
    UserInterestService uis = new UserInterestService();
    uis.batchDeleteByTag(tag.getId());
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(tag);
    session.getTransaction().commit();
    session.close();
  }

  public void update(Tag tag) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        "update Tag set name= :name "
                + "where tag_id=:id")
            .setParameter("name", tag.getName())
            .setParameter("id", tag.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
