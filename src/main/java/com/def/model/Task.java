package com.def.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tsk")
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDateTime createdDate;
    private boolean isFavorite;
    private boolean isHide;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private User user;

    public Task(String description, LocalDateTime createdDate, boolean isFavorite, boolean isHide) {
        this.description = description;
        this.createdDate = createdDate;
        this.isFavorite = isFavorite;
        this.isHide = isHide;
    }

    @Override
    public String toString() {
        return "id: " + id + " " + "description: " + description +
                " " + "createdDate: " + createdDate + " " +
                "isFavorite: " + isFavorite +
                " " + "isHide: " + isHide;
    }
}
