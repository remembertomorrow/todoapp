package com.malek.todoapp.model;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "task")
public class Task {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long taskId;

    @Getter
    @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(name = "description", nullable = false)
    private String description;

    @Getter
    @Setter
    @Column(name = "due_date", nullable = true)
    private LocalDateTime dueDate;

    @Getter
    @Setter
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Getter
    @Setter
    @Column(name = "modify_date", nullable = true)
    private LocalDateTime modifyDate;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="status_id", nullable=false)
    @JsonIgnore
    private Status status;
}
