package com.wolvesmentality.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "RATING")
@Getter
@Setter
public class Rating implements Serializable {

    public Rating() {
    }

    public Rating(final int stars) {
        this.stars = stars;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "STARS", nullable = false)
    private int stars;
}
