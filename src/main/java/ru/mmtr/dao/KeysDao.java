package ru.mmtr.dao;

import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);

    public void update(Keys K);

    public void deleteByObj(Object K);

    public String deleteByKey(Long id);

    public String addKey(String Key, Long type, String... words);

    public String addWordToKey(Long id, Long type, String words);

    public String updateByKey(Long id, String newKeys, Long type);

    public String updateByWord(Long id, String newWords, Long type);

    public String deleteByWord(Long id);

    public Words findWordsById(Long id);

    public List<Keys> findByKey(String key);

    public List<Keys> findByWord(String key, Long type);

    public List<Keys> getKeysList(Long type);

}
