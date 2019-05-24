package com.timeject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "project_status_id", nullable = true)
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ProjectStatus status;
    @JoinColumn(name = "project_type_id", nullable = true)
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ProjectType type;
    @ManyToOne
    @JoinColumn(name= "task_id")
    private Task task;

}
