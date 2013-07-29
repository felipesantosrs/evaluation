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

import java.util.List;

import br.edu.infnet.evaluation.dto.SurveyDTO;
import br.edu.infnet.evaluation.entity.Survey;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.SurveyService;
import br.edu.infnet.evaluation.service.SurveyServiceImpl;

/**
 * Class that implements all methods to handle survey.
 * 
 * @author Renan T. Pinzon
 */
public class SurveyEJBServiceBean implements SurveyEJBService {

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.bean.SurveyEJBService#find(br.edu.infnet.evaluation.entity.User)
	 */
	@Override
	public List<SurveyDTO> find(User user) {
		SurveyService surveyService = new SurveyServiceImpl(Survey.class);
		return surveyService.find(user);
	}

}
