package com.mercur1y.servingwebcontent.domain;

import org.hibernate.engine.profile.Fetch;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the note")
    @Length(max = 2048, message = "Note too long (more than 2kB)")
    private String text;

    private Date localDateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Note() {
    }

    public Note(String text, User user, Date localDateTime) {
        this.author = user;
        this.text = text;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "none";
    }

    public Long getAuthorId() {
        return author.getId();
    }

    public Date getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Date localDateTime) {
        this.localDateTime = localDateTime;
    }
}
