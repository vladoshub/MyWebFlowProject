package ru.mmtr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mmtr.entity.Key;
import ru.mmtr.entity.Type;
import ru.mmtr.entity.Word;

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

    @Override
    public String addKey(String Key, Integer type, List<String> words) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Key key = new Key(type);
            key.setKey(Key);
            for (String wordStr : words) {
                Word word = new Word();
                word.setWord(wordStr);
                key.setWords(word);
                word.setKey(key);
            }
            session.saveOrUpdate(key);
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
            Key key = new Key(type);
            key.setKey(Key);
            Word word = new Word();
            word.setWord(wordStr);
            key.setWords(word);
            word.setKey(key);
            session.saveOrUpdate(key);
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String addWord(Long id, Integer type, List<String> words) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            for (String s : words) {
                Word word = new Word(id);
                word.setWord(s);
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
    public String addWord(Long id, Integer type, String words) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Word word = new Word(id);
            word.setWord(words);
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
    public List<Key> findByKey(String key, Integer type) {
        try {
            Session session = this.sessionFactory.openSession();
            List<Key> ux = session.createQuery("From Key where key='" + key + "' and type_id='" + type + "'").list();
            session.close();
            return ux;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<Key> findByWord(String word, Integer type) {
        try {
            List<Key> ux2 = new ArrayList<>();
            Session session = this.sessionFactory.openSession();
            List<Word> ux = session.createQuery("From Word where word='" + word + "' and type_id='" + type + "'").list();
            for (Word w : ux) {
                Key key = new Key();
                key.setType(w.getKey().getType());
                key.setWords(w.getKey().getWords());
                key.setKey(w.getKey().getKey());
                key.setId(w.getKey().getId());
                ux2.add(key);
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
                regKeys.add(types.get(i).getRegKeys());
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
                regWords.add(types.get(i).getRegWords());
            }
            session.close();
            return regWords;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    @Override
    public String deleteKeyById(Long id) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Key key = (Key) session.load(Key.class, id);
            session.delete(key);
            tx1.commit();
            session.close();
            return "Ok";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String deleteWordById(Long id) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Word word = (Word) session.load(Word.class, id);
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
    public String updateKey(Long id, String newKeys, Integer type) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            List<Key> ux = session.createQuery("From Key where id=" + id + " and type_id=" + type + "").list();
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
    public String updateWord(Long id, String newWords, Integer type) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            Word word = (Word) session.get(Word.class, id);
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
    public List<Key> getKeysList(Integer type) {
        try {
            Session session = this.sessionFactory.openSession();
            String hql = "FROM Key WHERE type_id=" + type + " ORDER BY key ASC";
            List<Key> VocabularyList = session.createQuery(hql).list();
            session.close();
            return VocabularyList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Type findByIdType(String type) {
        try {
            Session session = this.sessionFactory.openSession();
            String hql = "FROM Type WHERE type='" + type + "' ORDER BY type ASC";
            Type typel = (Type) session.createQuery(hql).uniqueResult();
            session.close();
            return typel;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
