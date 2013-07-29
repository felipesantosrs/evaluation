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

import br.edu.infnet.evaluation.entity.Answer;
import br.edu.infnet.evaluation.entity.ClassRoom;
import br.edu.infnet.evaluation.entity.Survey;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.util.BaseService;

/**
 * Interface that defines all methods to handle answers.
 * 
 * @author Renan T. Pinzon
 */
public interface AnswerService extends BaseService<Answer> {

	/**
	 * Verify whether or not the user has already answered a survey for a
	 * specific class.
	 * 
	 * @param survey the survey
	 * @param classRoom the class
	 * @param user the user that answered
	 * @return {@code true} if and only if the user has already answered
	 */
	Boolean hasAnswer(Survey survey, ClassRoom classRoom, User user);

}
