package ru.mmtr.dao;

import ru.mmtr.entity.Keys;

import java.util.List;

public interface KeysDao {
    public String deleteByKey(Long id);

    public String addKey(String Key, Integer type, List<String> words);

    public String addKey(String Key, Integer type, String word);

    public List<String> getRegexKeys();

    public List<String> getRegexWords();

    public String addWordToKey(Long id, Integer type, List<String> words);

    public String addWordToKey(Long id, Integer type, String words);

    public String updateByKey(Long id, String newKeys, Integer type);

    public String updateByWord(Long id, String newWords, Integer type);

    public String deleteByWord(Long id);

    public List<Keys> findByKey(String key);

    public List<Keys> findByWord(String key, Integer type);

    public List<Keys> getKeysList(Integer type);

}
