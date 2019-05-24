package com.timeject.model;

import java.sql.Timestamp;

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
@Table(name = "projects_status")
@Getter
@Setter
@NoArgsConstructor
public class ProjectStatus {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "project_status_id")
    private Long id;
	@Column(name = "project_status_start", nullable = false)
	private Timestamp start;
	@Column(name = "project_status_end", nullable = false)
    private Timestamp end;
	@Column(name = "project_status_percentage_completed", nullable = false)
    private Float percentageCompleted;
}
