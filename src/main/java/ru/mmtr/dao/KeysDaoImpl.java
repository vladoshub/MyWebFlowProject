package ru.mmtr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Type;
import ru.mmtr.entity.Words;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KeysDaoImpl implements KeysDao {
    @Autowired
    public KeysDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KeysDaoImpl.class);

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
    public String addKey(String Key, Long type, List<String> words) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Keys keys = new Keys();
            keys.setKey(Key);
            for (String wordStr : words) {
                Words word = new Words();
                word.setWord(wordStr);
                keys.setWords(word);
                word.setKey(keys);
            }
            Type typeL = new Type();
            typeL.setId(type);
            keys.setType(typeL);
            session.saveOrUpdate(keys);
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String addKey(String Key, Long type, String wordStr) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Keys keys = new Keys();
            keys.setKey(Key);
            Words word = new Words();
            word.setWord(wordStr);
            keys.setWords(word);
            word.setKey(keys);
            Type typeL = new Type();
            typeL.setId(type);
            keys.setType(typeL);
            session.saveOrUpdate(keys);
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String addWordToKey(Long id, Long type, List<String> words) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Keys keys = new Keys();
            keys.setId(id);
            for (String s : words) {
                Words word = new Words();
                word.setWord(s);
                word.setKey(keys);
                session.saveOrUpdate(word);
            }
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String addWordToKey(Long id, Long type, String words) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Keys keys = new Keys();
            keys.setId(id);
            Words word = new Words();
            word.setWord(words);
            word.setKey(keys);
            session.saveOrUpdate(word);
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<Keys> findByKey(String key) {
        try {
            Session session = this.sessionFactory.openSession();
            List<Keys> ux = session.createQuery("From Keys where key='" + key + "'").list();
            session.close();
            return ux;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public List<Keys> findByWord(String word, Long type) {
        try {
            List<Keys> ux2 = new ArrayList<Keys>();
            int count = 0;
            Session session = this.sessionFactory.openSession();
            List<Words> ux = session.createQuery("From Words where word='" + word + "'").list();
            for (Words w : ux) {
                Keys keys = new Keys();
                keys.setType(w.getKey().getType());
                keys.setWords(w.getKey().getWords());
                keys.setKey(w.getKey().getKey());
                keys.setId(w.getKey().getId());
                ux2.add(keys);
            }
            session.close();
            return ux2;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

   /* public String getRegWord(Long type) {
        try {
            Session session = this.sessionFactory.openSession();
            Type type1 = (Type) session.createQuery("From Type where type=" + type + "").uniqueResult();
            session.close();
            return type1.getRegWord();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    public String getRegKey(Long type) {
        try {
            Session session = this.sessionFactory.openSession();
            Type type1 = (Type) session.createQuery("From Type where type=" + type + "").uniqueResult();
            session.close();
            return type1.getRegKey();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
*/
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
    public String deleteByKey(Long id) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            List<Keys> ux = session.createQuery("From Keys where id=" + id + "").list();
            session.delete(ux.get(0));
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String deleteByWord(Long id) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Words word = (Words) session.load(Words.class, id);
            session.delete(word);

            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String updateByKey(Long id, String newKeys, Long type) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            List<Keys> ux = session.createQuery("From Keys where id=" + id + " and type_id=" + type + "").list();
            ux.get(0).setKey(newKeys);
            session.update(ux.get(0));
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String updateByWord(Long id, String newWords, Long type) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Words word = (Words) session.get(Words.class, id);
            word.setWord(newWords);
            session.update(word);
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Words findWordsById(Long id) {

        return (Words) this.sessionFactory.openSession().get(Words.class, id);
    }

    @Override
    public List<Keys> getKeysList(Long type) {
        try {
            Session session = this.sessionFactory.openSession();
            String hql = "FROM Keys WHERE type_id=" + type + " ORDER BY key ASC";
            List<Keys> VocabularyList = session.createQuery(hql).list();
            session.close();
            return VocabularyList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
