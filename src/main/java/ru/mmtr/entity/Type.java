package ru.mmtr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "types")
public class Type implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String regwords;
    private String regkeys;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Keys> keys;

    public Type() {
        super();
    }

    public Type(String type, List<Keys> keys) {
        this.type = type;
        this.keys = keys;
    }

    public Type(String type, Keys keys) {
        this.type = type;
        this.keys.add(keys);
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String key_id) {
        this.type = key_id;
    }

    public List<Keys> getKeys() {
        return keys;
    }


    public void setKeys(List<Keys> keys) {

        this.keys = keys;
    }

    public void setKeys(Keys keys) {

        this.keys.add(keys);
    }

    public String getRegkeys() {
        return regkeys;
    }

    public String getRegwords() {
        return regwords;
    }

    public void setRegkeys(String regKey) {
        regkeys = regKey;
    }

    public void setRegwords(String regWord) {
        regwords = regWord;
    }

    @Override
    public String toString() {
        return "KEYS{" +
                "id=" + id +
                ", Key='" + type + '\'' +
                ", Words=" + keys +
                '}';
    }
}