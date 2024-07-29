package com.nsu.medium.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

    private String fileName;
    private String fileType;
    private String filePath;

    private String links;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @ElementCollection
    private Set<String> tags;
}
