package ru.mmtr.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
public class Type implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
   /* private String RegWord;
    private String RegKey;
    */
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

    public void setId(Long id) {
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

   /* public String getRegKey() {
        return RegKey;
    }

    public String getRegWord() {
        return RegWord;
    }

    public void setRegKey(String regKey) {
        RegKey = regKey;
    }

    public void setRegWord(String regWord) {
        RegWord = regWord;
    }
*/
    @Override
    public String toString() {
        return "KEYS{" +
                "id=" + id +
                ", Key='" + type + '\'' +
                ", Words=" + keys +
                '}';
    }
}