package com.nsu.medium.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 10000)
    private String content;

    private String file;
    private String links;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "articles_tags",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tags> tags = new HashSet<>();
}
