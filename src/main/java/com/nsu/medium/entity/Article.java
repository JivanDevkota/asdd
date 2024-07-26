package com.nsu.medium.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

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

}
