package com.timeject.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "project_id")
    private Long id;
    @Column(name = "project_name", nullable = false)
    private String name;
    @Column(name = "project_description", nullable = false)
    private String description;
    @OneToOne(mappedBy = "project",cascade=CascadeType.ALL)
    private ProjectStatus status;
    @JoinColumn(name = "project_type_id", nullable = true)
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId
    private ProjectType type;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name= "project_id")
    private Collection<Task> task;

}
