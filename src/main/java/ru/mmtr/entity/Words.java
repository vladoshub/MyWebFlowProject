package ru.mmtr.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "words")
public class Words implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "word")
    private String word;
    @ManyToOne(fetch = FetchType.LAZY)
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

    public void setId(Long id) {
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
