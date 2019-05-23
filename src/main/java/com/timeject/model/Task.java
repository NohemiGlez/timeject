package com.timeject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    private Long id;
    private String description;
    private Timestamp startDate;
    private Timestamp dueDate;
    private Timestamp endDate;
    private String status;

}
