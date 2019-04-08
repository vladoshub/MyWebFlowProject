package ru.mmtr.dao;

import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);

    public void update(Keys K);

    public void deleteByObj(Object K);
    public void deleteByKey(String keys);
    public void AddKey(String Key, String... words);
    public Words findWordsById(long id);

    public List<Keys> findByKey(String key);
    public List<Words> getWordsByKey(String key);

    public List<Keys> getKeysList();

}
