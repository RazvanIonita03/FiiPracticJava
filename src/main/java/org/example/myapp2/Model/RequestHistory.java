package org.example.myapp2.Model;

import jakarta.persistence.*;

@Entity
public class RequestHistory {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lat;

    @Column(nullable = false)
    private String lon;

    @Column
    private Boolean q;

    @Column
    private Boolean aqi;

    @Column
    private Boolean alerts;

    @Column
    private Integer days;

    @Column(nullable = false,length = 2047)
    private String response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "user_id")
    private User user;
}
