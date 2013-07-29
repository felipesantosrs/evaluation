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

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.infnet.evaluation.entity.Answer;
import br.edu.infnet.evaluation.entity.ClassRoom;
import br.edu.infnet.evaluation.entity.Survey;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.util.BaseServiceImpl;
import br.edu.infnet.evaluation.util.HibernateUtils;

/**
 * Class that implements all methods to handle answers.
 * 
 * @author Renan T. Pinzon
 */
public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements AnswerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnswerServiceImpl.class);

	/**
	 * Default constructor.
	 * 
	 * @param clazz the class of the entity
	 */
	public AnswerServiceImpl(Class<Answer> clazz) {
		super(clazz);
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.AnswerService#hasAnswer(br.edu.infnet.evaluation.entity.Survey, br.edu.infnet.evaluation.entity.ClassRoom, br.edu.infnet.evaluation.entity.User)
	 */
	@Override
	public Boolean hasAnswer(Survey survey, ClassRoom classRoom, User user) {
		boolean hasAnswer = false;
		try {
			session = HibernateUtils.getSession();
			Criteria criteria = session.createCriteria(Answer.class);
			criteria.add(Restrictions.eq("id.survey.id", survey.getId()));
			criteria.add(Restrictions.eq("id.classRoom.id", classRoom.getId()));
			criteria.add(Restrictions.eq("id.user.id", user.getId()));
			hasAnswer = !criteria.list().isEmpty();
		} catch (Exception e) {
			LOGGER.error("Error verifying if the user already answered a survey.", e);
		} finally {
			session.close();
		}
		return hasAnswer;
	}

}
