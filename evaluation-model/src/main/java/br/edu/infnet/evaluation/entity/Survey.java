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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Object that represents a survey at database.
 * 
 * @author Renan T. Pinzon
 */
@Entity
@Table(name = "survey")
public class Survey implements Serializable {

	private static final long serialVersionUID = -7159591037047994045L;

	private Integer id;

	private String description;

	private Boolean enabled;

	private Date start;

	private Date deadline;

	private Set<Question> questions = new HashSet<Question>();

	private Set<ClassRoom> classesRoom = new HashSet<ClassRoom>();

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_survey")
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
	 * Getter method for description.
	 * 
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Setter method for description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter method for enabled.
	 * 
	 * @return the enabled
	 */
	@Column(name = "enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Setter method for enabled.
	 * 
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Getter method for start.
	 * 
	 * @return the start
	 */
	@Column(name = "start")
	public Date getStart() {
		return start;
	}

	/**
	 * Setter method for start.
	 * 
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * Getter method for deadline.
	 * 
	 * @return the deadline
	 */
	@Column(name = "deadline")
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * Setter method for deadline.
	 * 
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * Getter method for questions.
	 * 
	 * @return the questions
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "survey_question", joinColumns = { @JoinColumn(name = "id_survey") }, inverseJoinColumns = { @JoinColumn(name = "id_question") })
	public Set<Question> getQuestions() {
		return questions;
	}

	/**
	 * Setter method for questions.
	 * 
	 * @param questions the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	/**
	 * Getter method for classesRoom.
	 * 
	 * @return the classes room
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "survey_class", joinColumns = { @JoinColumn(name = "id_survey") }, inverseJoinColumns = { @JoinColumn(name = "id_class") })
	public Set<ClassRoom> getClassesRoom() {
		return classesRoom;
	}

	/**
	 * Setter method for classesRoom.
	 * 
	 * @param classesRoom the classesRoom to set
	 */
	public void setClassesRoom(Set<ClassRoom> classesRoom) {
		this.classesRoom = classesRoom;
	}

}
