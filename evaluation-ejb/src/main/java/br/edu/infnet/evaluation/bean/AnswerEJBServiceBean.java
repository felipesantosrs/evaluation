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
package br.edu.infnet.evaluation.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.infnet.evaluation.entity.Answer;
import br.edu.infnet.evaluation.service.AnswerService;
import br.edu.infnet.evaluation.service.AnswerServiceImpl;

/**
 * Class that implements all methods to handle answers.
 * 
 * @author Renan T. Pinzon
 */
@Stateless
@Local(AnswerEJBService.class)
public class AnswerEJBServiceBean implements AnswerEJBService {

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.bean.AnswerEJBService#persist(br.edu.infnet.evaluation.entity.Answer)
	 */
	@Override
	public void persist(Answer answer) {
		AnswerService answerService = new AnswerServiceImpl(Answer.class);
		answerService.persist(answer);
	}

}
