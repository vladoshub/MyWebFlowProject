package ru.mmtr.dao;

import ru.mmtr.entity.Key;

import java.util.List;

public interface KeysDao {
    public String deleteKeyById(Long id);

    public String addKey(String Key, Integer type, List<String> words);

    public String addKey(String Key, Integer type, String word);

    public List<String> getRegexKeys();

    public List<String> getRegexWords();

    public String addWord(Long id, Integer type, List<String> words);

    public String addWord(Long id, Integer type, String words);

    public String updateKey(Long id, String newKeys, Integer type);

    public String updateWord(Long id, String newWords, Integer type);

    public String deleteWordById(Long id);

    public List<Key> findByKey(String key,Integer type);

    public List<Key> findByWord(String key, Integer type);

    public List<Key> getKeysList(Integer type);

}
