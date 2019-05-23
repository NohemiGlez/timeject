package com.timeject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;
    private ProjectType type;

}
