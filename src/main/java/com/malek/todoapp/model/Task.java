package com.malek.todoapp.model;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

    @Getter
    @Setter
    @Column(name = "priority", nullable = false)
    private PriorityEnum priority;


    @Getter
    @Setter
    @OneToMany(mappedBy = "task")
    private Set<Status> statuses;
}
