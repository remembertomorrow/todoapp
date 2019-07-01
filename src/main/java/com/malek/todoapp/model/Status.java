package com.malek.todoapp.model;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
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

    @OneToMany(mappedBy = "status")
    @Getter
    @Setter
    @JsonBackReference
    private Set<Task> tasks;

}
