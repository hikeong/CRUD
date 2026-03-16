package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getWriter() { return writer; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setWriter(String writer) { this.writer = writer; }
}
