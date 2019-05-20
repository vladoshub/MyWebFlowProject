package ru.mmtr.dao;

import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Type;
import ru.mmtr.entity.Words;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);

    public void update(Keys K);

    public void deleteByObj(Object K);
    public String deleteByKey(String keys);
    public String AddKey(String Key, int type,String... words);
    public String AddWordtoKey(String id, int type,String words);
    public String updateByKey(String keys,String newKeys,int type);
    public String updateByWord(String Words,String newWords,int type);
    public String deleteByWord(String id);

    public Words findWordsById(long id);

    public List<Keys> findByKey(String key);
    public List<Keys> findByWord(String key, int type);

    public List<Keys> getKeysList(int type);

}
