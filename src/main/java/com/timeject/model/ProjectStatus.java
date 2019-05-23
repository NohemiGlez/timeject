package com.timeject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProjectStatus {
    @Id
    private Long id;
    private Timestamp start;
    private Timestamp end;
    private Float percentageCompleted;
}
