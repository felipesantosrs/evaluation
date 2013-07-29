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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.infnet.evaluation.enums.CourseType;

/**
 * Object that represents a course at database.
 * 
 * @author Renan T. Pinzon
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 4998734142642608371L;

	private Integer id;

	private CourseType type;

	private String name;

	private String description;

	private Set<Subject> subjects = new HashSet<Subject>();

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_course")
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
	 * Getter method for type.
	 * 
	 * @return the type
	 */
	@Enumerated
	@Column(name = "type")
	public CourseType getType() {
		return type;
	}

	/**
	 * Setter method for type.
	 * 
	 * @param type the type to set
	 */
	public void setType(CourseType type) {
		this.type = type;
	}

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Getter method for subjects.
	 * 
	 * @return the subjects
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_subject", joinColumns = { @JoinColumn(name = "id_course") }, inverseJoinColumns = { @JoinColumn(name = "id_subject") })
	public Set<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * Setter method for subjects.
	 * 
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

}
