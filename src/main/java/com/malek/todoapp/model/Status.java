package com.malek.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "status")
public class Status {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long statusId;

    @Getter
    @Setter
    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @Getter
    @Setter
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Getter
    @Setter
    @Column(name = "finish_date", nullable = true)
    private LocalDateTime finishDate;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="task_id", nullable=false)
    @JsonIgnore
    private Task task;

}
