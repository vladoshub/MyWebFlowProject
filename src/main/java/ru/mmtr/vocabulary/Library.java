package ru.mmtr.vocabulary;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mmtr.dao.KeysDao;
import ru.mmtr.dao.KeysDaoImpl;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
@Component("Library")
public class Library {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Library.class);

    @Value("nameFile")
    private String nameFile;
    private String regexVocFirstLib;
    private String regexVocSecondLib;
    private KeysDao keysDao;
    private List<String> print = new ArrayList<>();


    @Autowired
    public Library(InfoBase infoBase, SessionFactory ses) {
        this.nameFile = infoBase.getFileName();
        this.regexVocFirstLib = infoBase.getRegexVocFirstLib();
        this.regexVocSecondLib = infoBase.getRegexVocSecondLib();
        keysDao = new KeysDaoImpl(ses);
    }


    public List<String> printAll(int type) {

        try {
            print.clear();
            for (Keys k : keysDao.getKeysList(type)) {
                for (Words w : k.getWords()) {
                    print.add("key: " + k.getKey() + " - " + "word: " + w.getWord() + "   ");
                }
            }
            if (print == null)
                print.add(0, "List null");
            else
                print.add(0, "Operation is Ok");

            return print;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public List<String> readFromTxt(String key, int type) {


        if (print != null) print.clear();
        try {
            for (Keys w : keysDao.findByWord(key, type)) {
                print.add("key: " + key + " - " + "word: " + w.getKey() + " ");
            }
            if (print == null)
                print.add(0, "not match");
            else
                print.add(0, "Operation is Ok");
            return print;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }


    }

    public List<Keys> searchByKey(String key, int type) {//-	поиск записи по ключу

        try {
            return keysDao.findByKey(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }


    }

    public List<Keys> searchByWord(String word, int type) {//-	поиск записи по ключу

        try {
            return keysDao.findByWord(word, type);
        } catch (Exception e) {
            return null;
        }


    }

    public List<Keys> getKeys(int type) {//-	поиск записи по ключу
        try {
            return keysDao.getKeysList(type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }


    }

    public String deleteByKey(String key) {

        try {
            return keysDao.deleteByKey(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }


    }

    public String deleteByWord(String id) {
        try {
            return keysDao.deleteByWord(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }


    }

    public String addToTxt(String key, String value, int type) {
        try {
            return keysDao.AddKey(key, type, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }

    public String addToKey(String id, String value, int type) {
        try {
            return keysDao.AddWordtoKey(id, type, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }

    public String updateByKey(String id, String newKey, int type) {//--	добавление записей

        try {
            return keysDao.updateByKey(id, newKey, type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }

    public String updateByWord(String id, String newWord, int type) {//--	добавление записей

        try {
            return keysDao.updateByWord(id, newWord, type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }


    public String addToTxt(String key, String[] value, int type) {

        try {
            return keysDao.AddKey(key, type, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


}