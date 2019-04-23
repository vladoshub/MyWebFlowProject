package ru.mmtr.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Type;
import ru.mmtr.entity.Words;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KeysDaoImpl implements KeysDao {
    @Autowired
    public KeysDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Keys vocabulary) {
        Session session = this.sessionFactory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.persist(vocabulary);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Override
    public void AddKey(String Key,String... words) {//добавление новой записи
        List<Words> wordList=new ArrayList<>();
        try {
        int k=0;
        Keys keys = new Keys();
        for(int i =0;i<words.length;i++) {
            Words word = new Words();
            word.setKey(keys);
            word.setWord(words[k]);
            k++;
            wordList.add(word);
        }
        keys.setWords(wordList);
        keys.setKey(Key);
        Session session = this.sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.persist(keys);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }


    @Override
    public List<Keys> findByKey(String key) { // возврат листы  ключа
        Session session = this.sessionFactory.openSession();
       /* List ux = session.createQuery("SELECT id FROM Keys where key='"+key+"'").list();
        Words  w = findWordsById((int)ux.get(1));*/
        Criteria criteria = session.createCriteria(Keys.class);
        List<Keys> ux = criteria.add(Restrictions.eq("key", key)).list();
        session.close();
        return ux;
    }

    public List<Words> getWordsByKey(String key,int type) { // возврат слов по ключю(key-ключ,type-тип словаря)
        Session session = this.sessionFactory.openSession();
       /* List ux = session.createQuery("SELECT id FROM Keys where key='"+key+"'").list();
        Words  w = findWordsById((int)ux.get(1));*/
        List<Keys> ux = session.createQuery("From Keys where key='"+key+"' and type_id='"+type+"'").list();
      //  Criteria criteria = session.createCriteria(Keys.class) //-не рабочий
             //   .add(Restrictions.eq("key", key))
             //   .add(Restrictions.eq("type_id", type));
       // List<Keys> ux = criteria.list();
        session.close();
        return ux.get(0).getWords();
    }

    @Override
    public void update(Keys keys) {
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(keys);
        tx1.commit();
        session.close();
    }


    @Override
    public void deleteByObj(Object keys) {
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(keys);
        tx1.commit();
        session.close();
    }
    @Override
    public void deleteByKey(String keys) { //удаление по ключу
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(Keys.class);
        List<Keys> ux = criteria.add(Restrictions.eq("key", keys)).list();
        session.delete(ux.get(0));
        tx1.commit();
        session.close();
    }

    @Override
    public void update(String keys,List<Words>words,Type type) { //Обновление по о всему
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(Keys.class);
        Keys key = (Keys)criteria.add(Restrictions.eq("key", keys)).list().get(0);
        key.setKey(keys);
        key.setWords(words);
        key.setType(type);
        session.update(key);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(String keys,List<Words>words,String newKeys) { //Обновление по словам
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(Keys.class);
        Keys key = (Keys)criteria.add(Restrictions.eq("key", keys)).list().get(0);
        key.setKey(keys);
        key.setWords(words);
        session.update(key);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(String keys,String newKeys) { //Обновление по ключу
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(Keys.class);
        Keys key = (Keys)criteria.add(Restrictions.eq("key", keys)).list().get(0);
        key.setKey(newKeys);
        session.update(key);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(String keys,List<Words>words) { //Обновление по словам
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Criteria criteria = session.createCriteria(Keys.class);
        Keys key = (Keys)criteria.add(Restrictions.eq("key", keys)).list().get(0);
        key.setWords(words);
        session.update(key);
        tx1.commit();
        session.close();
    }
    @Override
    public Words findWordsById(long id) {

        return (Words) this.sessionFactory.openSession().get(Words.class, id);
    }

    @Override
    public List<Keys> getKeysList(int type) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Keys WHERE type_id="+type+" ORDER BY key ASC";
        List<Keys> VocabularyList = session.createQuery(hql).list();
        session.close();
        return VocabularyList;

    }
}
