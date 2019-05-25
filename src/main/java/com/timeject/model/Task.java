package com.timeject.model;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    public  enum Status{
        TODO,IN_PROGRESS,DONE;
    }
	@Id
	@Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "task_title", nullable = false)
    private String title;
    @Column(name = "task_description", nullable = true)
    private String description;
	@Column(name = "task_start_date", nullable = false)
    private Timestamp startDate;
	@Column(name = "task_due_date", nullable = false)
    private Timestamp dueDate;
	@Column(name = "task_end_date")
    private Timestamp endDate;
	@Column(name = "task_status", nullable = false)
    private String status;
    @Column(name = "project_id")
    private Long projectId;
}
