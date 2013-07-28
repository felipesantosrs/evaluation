-- user

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Admin', 'admin@gmail.com', 'admin', 0, true, false, 0);

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Professor1', 'professor1@gmail.com', 'professor', 1, true, false, 0);

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Professor2', 'professor2@gmail.com', 'professor', 1, true, false, 0);

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Aluno1', 'aluno1@gmail.com', 'aluno1', 2, true, false, 0);

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Aluno2', 'aluno2@gmail.com', 'aluno2', 2, true, false, 0);

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Aluno3', 'aluno3@gmail.com', 'aluno3', 2, true, false, 0);

insert into user (name, email, password, type, enabled, blocked, num_attempt)
values ('Aluno4', 'aluno4@gmail.com', 'aluno4', 2, true, false, 0);

-- course

insert into course (name, description, type)
values ('Ciencia da Computação', 'Bacharelado em Ciencia da Computação', 0);

insert into course (name, description, type)
values ('Sistemas de Informação', 'Bacharelado em Sistemas de Informação', 0);

insert into course (name, description, type)
values ('Engenharia de Software', 'Pós-graduação em Engenharia de Software com Java', 1);

insert into course (name, description, type)
values ('Curso de Java', 'Curso de Java', 2);

-- subject

insert into subject (name, description)
values ('Algoritmos I', 'Disciplina de algoritmos I');

insert into subject (name, description)
values ('LAPRO I', 'Disciplina de laboratório de programação I');

insert into subject (name, description)
values ('Sistemas Operacionais', 'Disciplina de sistemas operacionais');

insert into subject (name, description)
values ('Sistemas Distribuídos', 'Disciplina de sistemas distribuidos');

insert into subject (name, description)
values ('Gerência de Projetos', 'Disciplina de gerenciamento de projetos');

insert into subject (name, description)
values ('Métricas de Software', 'Disciplina de métricas de software');

insert into subject (name, description)
values ('Orientação a Objetos', 'Disciplina de introdução a orientação a objetos');

-- course_subject

insert into course_subject (id_course, id_subject) values (1, 3);

insert into course_subject (id_course, id_subject) values (1, 4);

insert into course_subject (id_course, id_subject) values (2, 1);

insert into course_subject (id_course, id_subject) values (2, 2);

insert into course_subject (id_course, id_subject) values (3, 5);

insert into course_subject (id_course, id_subject) values (3, 6);

insert into course_subject (id_course, id_subject) values (4, 7);

-- class

insert into class (id_course, id_subject, id_user) values (1, 3, 2);

insert into class (id_course, id_subject, id_user) values (1, 4, 3);

insert into class (id_course, id_subject, id_user) values (2, 1, 3);

insert into class (id_course, id_subject, id_user) values (2, 2, 3);

insert into class (id_course, id_subject, id_user) values (3, 5, 2);

insert into class (id_course, id_subject, id_user) values (3, 6, 2);

insert into class (id_course, id_subject, id_user) values (4, 7, 3);

-- user_class

insert into user_class (id_user, id_class) values (4, 3);

insert into user_class (id_user, id_class) values (4, 4);

insert into user_class (id_user, id_class) values (5, 1);

insert into user_class (id_user, id_class) values (6, 1);

insert into user_class (id_user, id_class) values (6, 2);

insert into user_class (id_user, id_class) values (7, 1);

insert into user_class (id_user, id_class) values (7, 2);

insert into user_class (id_user, id_class) values (5, 7);

-- question

insert into question (description, enabled)
values ('O professor contribuiu para o meu aprendizado', true);

insert into question (description, enabled)
values ('O professor é atencioso e esteve disponível para tirar dúvidas', true);

insert into question (description, enabled)
values ('Eu adquiri ascompetências propostas para o módulo', true);

insert into question (description, enabled)
values ('A carga horária do módulo foi apropriada', true);

insert into question (description, enabled)
values ('O acervo da biblioteca atendeu as necessidades desse módulo', true);

insert into question (description, enabled)
values ('Até agora, eu indicaria o curso para um amigo', true);

insert into question (description, enabled)
values ('Até agora,minha turma parece proporcionar um networking relevante para a minha carreira', true);

-- survey

insert into survey (description, enabled, start, deadline)
values ('Pesquisa Geral Curso', true, '2013-04-10', '2013-04-31');

insert into survey (description, enabled, start, deadline)
values ('Pesquisa Geral Infra-estrutura', true, '2013-03-23', '2013-04-08');

insert into survey (description, enabled, start, deadline)
values ('Pesquisa Geral Professor', true, '2013-03-10', '2013-03-25');

-- survey_question

insert into survey_question (id_survey, id_question) values (1, 3);
insert into survey_question (id_survey, id_question) values (1, 4);
insert into survey_question (id_survey, id_question) values (1, 6);
insert into survey_question (id_survey, id_question) values (1, 7);

insert into survey_question (id_survey, id_question) values (2, 5);

insert into survey_question (id_survey, id_question) values (3, 1);
insert into survey_question (id_survey, id_question) values (3, 2);

-- survey_class

insert into survey_class (id_survey, id_class) values (1, 1);
insert into survey_class (id_survey, id_class) values (1, 3);

insert into survey_class (id_survey, id_class) values (2, 1);
insert into survey_class (id_survey, id_class) values (2, 7);

insert into survey_class (id_survey, id_class) values (3, 2);
insert into survey_class (id_survey, id_class) values (3, 4);
