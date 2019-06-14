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
    public String addKey(String Key, Integer type, List<String> words) {
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

    @Override
    public String addKey(String Key, Integer type, String wordStr) {
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
    public String addWordToKey(Long id, Integer type, List<String> words) {
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

    @Override
    public String addWordToKey(Long id, Integer type, String words) {
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

    @Override
    public List<Keys> findByWord(String word, Integer type) {
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


    @Override
    public List<String> getRegexKeys() {
        try {
            List<String> regKeys = new ArrayList<>();
            Session session = this.sessionFactory.openSession();
            List<Type> types = session.createQuery("From Type ORDER BY id ASC").list();
            for (Integer i = 0; i < types.size(); i++) {
                regKeys.add(types.get(i).getRegkeys());
            }
            session.close();
            return regKeys;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<String> getRegexWords() {
        try {
            List<String> regWords = new ArrayList<>();
            Session session = this.sessionFactory.openSession();
            List<Type> types = session.createQuery("From Type ORDER BY id ASC").list();
            for (Integer i = 0; i < types.size(); i++) {
                regWords.add(types.get(i).getRegwords());
            }
            session.close();
            return regWords;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
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
    public String updateByKey(Long id, String newKeys, Integer type) {
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
    public String updateByWord(Long id, String newWords, Integer type) {
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
    public List<Keys> getKeysList(Integer type) {
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
