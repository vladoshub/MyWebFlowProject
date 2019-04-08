package ru.mmtr.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "keys")
public class Keys {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String key;
    @OneToMany(mappedBy = "key", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Words> words;

    public Keys() {
        super();
    }

    public Keys(String key, List<Words> words) {
        this.key = key;
        this.words = words;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key_id) {
        this.key = key_id;
    }

    public List<Words> getWords() {
        return words;
    }

    public void setWords(Words words) {

        this.words.add(words);
    }

    public void setWords(List<Words> words) {

        this.words=words;
    }

    @Override
    public String toString() {
        return "KEYS{" +
                "id=" + id +
                ", Key='" + key + '\'' +
                ", Words=" + words +
                '}';
    }
}
