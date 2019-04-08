package ru.mmtr.entity;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Words {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String word;
    @ManyToOne
    @JoinColumn(name="key_id")
    private Keys key;

    public void setKey(Keys key) {
        this.key = key;
    }

    public Keys getKey() {
        return key;
    }

    public Words() {
        super();
    }

    public Words(String word) {
        this.word = word;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", words=" + word +
                '}';
    }

}
