package com.timeject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects_type")
@Getter
@Setter
@NoArgsConstructor
public class ProjectType {
    public enum Type{
      A,B,C
    };
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "project_type_id")
    private Long id;
	@Column(name = "project_type_type", nullable = false)
    private String type;

}
