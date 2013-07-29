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
package br.edu.infnet.evaluation.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.infnet.evaluation.bean.SurveyEJBService;
import br.edu.infnet.evaluation.dto.SurveyDTO;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.util.BeanLocator;

/**
 * Managed bean that contains all methods to handle survey.
 * 
 * @author Felipe Santos da Rocha
 * @author Renan T. Pinzon
 */
@ManagedBean
@ViewScoped
public class SurveyMBean implements Serializable {

	private static final long serialVersionUID = 8903720058141456007L;

	private SurveyDTO surveyDTO;

	/**
	 * Getter method for surveyDTO.
	 * 
	 * @return the surveyDTO
	 */
	public SurveyDTO getSurveyDTO() {
		return surveyDTO;
	}

	/**
	 * Setter method for surveyDTO.
	 * 
	 * @param surveyDTO the surveyDTO to set
	 */
	public void setSurveyDTO(SurveyDTO surveyDTO) {
		this.surveyDTO = surveyDTO;
	}

	/**
	 * Retrieves all surveys for the current user.
	 * 
	 * @return a list containing all surveys for the logged in user
	 */
	public List<SurveyDTO> getList() {
		SurveyEJBService surveyEJBService = BeanLocator.lookup(SurveyEJBService.class);
		return surveyEJBService.find(getCurrentUser());
	}

	/**
	 * Retrieves the current user from session.
	 * 
	 * @return the logged in user
	 */
	private User getCurrentUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentUser");
		return user;
	}

	/**
	 * Redirects to the question's page.
	 * 
	 * @return the question's page
	 */
	public String questions() {
		return "question?faces-redirect=true";
	}

}
