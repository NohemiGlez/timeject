package com.timeject.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
	@Id
	@Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	@Column(name = "task_description", nullable = false)
    private String description;
	@Column(name = "task_start_date", nullable = false)
    private Timestamp startDate;
	@Column(name = "task_due_date", nullable = false)
    private Timestamp dueDate;
	@Column(name = "task_end_date", nullable = false)
    private Timestamp endDate;
	@Column(name = "task_status", nullable = false)
    private String status;
}
