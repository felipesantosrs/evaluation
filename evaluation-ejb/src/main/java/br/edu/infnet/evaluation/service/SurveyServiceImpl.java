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
package br.edu.infnet.evaluation.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.infnet.evaluation.dto.SurveyDTO;
import br.edu.infnet.evaluation.entity.Answer;
import br.edu.infnet.evaluation.entity.ClassRoom;
import br.edu.infnet.evaluation.entity.Question;
import br.edu.infnet.evaluation.entity.Survey;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.util.BaseServiceImpl;
import br.edu.infnet.evaluation.util.HibernateUtils;

/**
 * Class that implements all methods to handle survey.
 * 
 * @author Felipe Santos da Rocha
 */
public class SurveyServiceImpl extends BaseServiceImpl<Survey> implements SurveyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);

	/**
	 * Default constructor.
	 * 
	 * @param clazz the class of the entity
	 */
	public SurveyServiceImpl(Class<Survey> clazz) {
		super(clazz);
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.SurveyService#find(br.edu.infnet.evaluation.entity.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SurveyDTO> find(User user) {
		AnswerService answerService = new AnswerServiceImpl(Answer.class);
		List<SurveyDTO> result = new LinkedList<SurveyDTO>();
		List<Survey> list = new ArrayList<Survey>();
		try {
			session = HibernateUtils.getSession();
			Criteria criteria = session.createCriteria(Survey.class);
			criteria.add(Restrictions.eq("enabled", true));
			criteria.createAlias("classesRoom", "c");
			List<Integer> classesIds = new LinkedList<Integer>();
			Iterator<ClassRoom> classes = user.getClassesRoom().iterator();
			while (classes.hasNext()) {
				classesIds.add(classes.next().getId());
			}
			criteria.add(Restrictions.in("c.id", classesIds));
			list = criteria.list();
			for (Survey survey : list) {
				for (ClassRoom classRoom : survey.getClassesRoom()) {
					SurveyDTO surveyDTO = new SurveyDTO();
					surveyDTO.setUser(user);
					surveyDTO.setSurvey(survey);
					surveyDTO.setClassRoom(classRoom);
					surveyDTO.setOpened(Calendar.getInstance().getTime().after(survey.getStart()));
					surveyDTO.setClosed(Calendar.getInstance().getTime().after(survey.getDeadline()));
					surveyDTO.setAnswered(answerService.hasAnswer(survey, classRoom, user));
					List<Question> questions = new ArrayList<Question>(survey.getQuestions());
					surveyDTO.setQuestions(questions);
					result.add(surveyDTO);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error retrieving all entities.", e);
		} finally {
			session.close();
		}
		return result;
	}

}
