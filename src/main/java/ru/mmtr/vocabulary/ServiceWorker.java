package ru.mmtr.vocabulary;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.dao.KeysDao;
import ru.mmtr.dao.KeysDaoImpl;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("ServiceWorker")
public class ServiceWorker {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ServiceWorker.class);

    private List<Type> types;


    @Autowired
    public ServiceWorker(SessionFactory ses) {
        keysDao = new KeysDaoImpl(ses);
        types = new ArrayList<>();
        regKeys = keysDao.getRegexKeys();
        regWords = keysDao.getRegexWords();

    }


    private KeysDao keysDao;
    private List<String> regWords;
    private List<String> regKeys;


    public String delByKey(Long id) throws IOException {
        try {
            return keysDao.deleteByKey(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String delByWord(Long id) throws IOException {
        try {
            return keysDao.deleteByWord(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }


    public List<Keys> searchByKey(String key, Integer type) throws IOException {
        try {
            return keysDao.findByKey(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public List<Keys> searchByWord(String word, Integer type) throws IOException {
        try {
            return keysDao.findByWord(word, type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String updateByKey(Long id, String newKey, Integer type) throws IOException {
        try {
            if (!checkKey(newKey, type))
                return "ключ не относится к данному словарю";
            return keysDao.updateByKey(id, newKey, type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String updateByWord(Long id, String newWord, Integer type) throws IOException {

        try {
            if (checkWord(newWord, type))
                return keysDao.updateByWord(id, newWord, type);
            return "несоответсвие правилам словаря ";

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    public String add(Integer type, String key, List<String> words) throws IOException {
        try {
            if (!checkKey(key, type))
                return "ключ не относится к данному словарю";
            List<String> newWords = new ArrayList<String>();
            for (String s : words) {
                if (checkWord(s, type))
                    newWords.add(s);
            }
            if (newWords.size() > 0)
                return keysDao.addKey(key, type, newWords);
            return "ни 1 слово не подходит по правилам словаря";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String add(Integer type, String key, String word) throws IOException {
        try {
            if (!checkKey(key, type))
                return "ключ не относится к данному словарю";
            if (checkWord(word, type))
                return keysDao.addKey(key, type, word);
            return "слово не подходит по правилам словаря";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String addToKey(Integer type, Long id, List<String> words) throws IOException {
        try {
            List<String> newWords = new ArrayList<String>();
            for (String s : words) {
                if (checkWord(s, type))
                    newWords.add(s);
            }
            if (newWords.size() > 0)
                return keysDao.addWordToKey(id, type, words);
            return "ни 1 слово не подходит по правилам словаря";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }

    public String addToKey(Integer type, Long id, String word) throws IOException {
        try {
            if (checkWord(word, type))
                return keysDao.addWordToKey(id, type, word);
            return "слово не подходит по правилам словаря";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    public List<Keys> printKeys(Integer type) {
        try {
            return keysDao.getKeysList(type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public boolean checkWord(String word, Integer num) {
        return ServiceChecker.checkWord(word, num, regWords);
    }

    public boolean checkKey(String word, Integer num) {
        return ServiceChecker.checkKey(word, num, regKeys);
    }


}