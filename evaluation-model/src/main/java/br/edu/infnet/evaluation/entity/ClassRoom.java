/*
 * Copyright (c) 2013 Renan T. Pinzon <rpinzon@gmail.com>
 * 
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package br.edu.infnet.evaluation.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Object that represents a class at database.
 * 
 * @author Renan T. Pinzon
 */
@Entity
@Table(name = "class")
public class ClassRoom implements Serializable {

	private static final long serialVersionUID = 632310191484649502L;

	private Integer id;

	private Course course;

	private Subject subject;

	private User teacher;

	private Set<User> students = new HashSet<User>();

	private Set<Survey> surveys = new HashSet<Survey>();

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_class")
	public Integer getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method for course.
	 * 
	 * @return the course
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_course")
	public Course getCourse() {
		return course;
	}

	/**
	 * Setter method for course.
	 * 
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Getter method for subject.
	 * 
	 * @return the subject
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_subject")
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Setter method for subject.
	 * 
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * Getter method for teacher.
	 * 
	 * @return the teacher
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	public User getTeacher() {
		return teacher;
	}

	/**
	 * Setter method for teacher.
	 * 
	 * @param teacher the teacher to set
	 */
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	/**
	 * Getter method for students.
	 * 
	 * @return the students
	 */
	@ManyToMany(mappedBy = "classesRoom", fetch = FetchType.LAZY)
	public Set<User> getStudents() {
		return students;
	}

	/**
	 * Setter method for students.
	 * 
	 * @param students the students to set
	 */
	public void setStudents(Set<User> students) {
		this.students = students;
	}

	/**
	 * Getter method for surveys.
	 * 
	 * @return the surveys
	 */
	@ManyToMany(mappedBy = "classesRoom")
	public Set<Survey> getSurveys() {
		return surveys;
	}

	/**
	 * Setter method for surveys.
	 * 
	 * @param surveys the surveys to set
	 */
	public void setSurveys(Set<Survey> surveys) {
		this.surveys = surveys;
	}

}
