package com.timeject.model;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

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
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
	private Project project;
    private  Float percentageCompleted;
}
