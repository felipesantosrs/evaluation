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

import java.util.List;

import br.edu.infnet.evaluation.dto.SurveyDTO;
import br.edu.infnet.evaluation.entity.Survey;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.util.BaseService;

/**
 * Interface that defines all methods to handle users.
 * 
 * @author Felipe Santos da Rocha
 */
public interface SurveyService extends BaseService<Survey> {

	/**
	 * Retrieves all surveys available for an user.
	 * 
	 * @param user the user
	 * @return a list containing all surveys for the given user
	 */
	List<SurveyDTO> find(User user);

}
