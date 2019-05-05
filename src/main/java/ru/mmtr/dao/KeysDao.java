package ru.mmtr.dao;

import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Type;
import ru.mmtr.entity.Words;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);

    public void update(Keys K);

    public void deleteByObj(Object K);
    public void deleteByKey(String keys);
    public void AddKey(String Key, int type,String... words);
    public void updateByKey(String keys,String newKeys,int type);
    public void updateByWord(String Words,String newWords,int type);
    public void deleteByWord(String id);

    public Words findWordsById(long id);

    public List<Keys> findByKey(String key);
    public List<Words> getWordsByKey(String key,int type);

    public List<Keys> getKeysList(int type);

}
