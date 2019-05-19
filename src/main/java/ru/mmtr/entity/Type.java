package ru.mmtr.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "types")
public class Type implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Keys> keys;

    public Type() {
        super();
    }

    public Type(String type, List<Keys> keys) {
        this.type = type;
        this.keys = keys;
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

    public void setKeys(Keys keys) {

        this.keys.add(keys);
    }

    public void setWords(List<Keys> keys) {

        this.keys=keys;
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