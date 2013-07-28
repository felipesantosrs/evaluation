SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(64) NOT NULL ,
  `email` VARCHAR(128) NOT NULL ,
  `password` VARCHAR(32) NOT NULL ,
  `type` TINYINT NOT NULL ,
  `enabled` BIT NOT NULL ,
  `blocked` BIT NOT NULL ,
  `num_attempt` INT NOT NULL ,
  `last_login` DATETIME NULL ,
  PRIMARY KEY (`id_user`) ,
  UNIQUE INDEX `ds_email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`course`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`course` (
  `id_course` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(32) NOT NULL ,
  `description` VARCHAR(128) NOT NULL ,
  `type` TINYINT NOT NULL ,
  PRIMARY KEY (`id_course`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`subject`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`subject` (
  `id_subject` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(32) NOT NULL ,
  `description` VARCHAR(128) NOT NULL ,
  PRIMARY KEY (`id_subject`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`course_subject`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`course_subject` (
  `id_course` INT NOT NULL ,
  `id_subject` INT NOT NULL ,
  PRIMARY KEY (`id_course`, `id_subject`) ,
  INDEX `fk_course_has_subject_subject1_idx` (`id_subject` ASC) ,
  INDEX `fk_course_has_subject_course1_idx` (`id_course` ASC) ,
  CONSTRAINT `fk_course_has_subject_course1`
    FOREIGN KEY (`id_course` )
    REFERENCES `mydb`.`course` (`id_course` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_has_subject_subject1`
    FOREIGN KEY (`id_subject` )
    REFERENCES `mydb`.`subject` (`id_subject` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`class`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`class` (
  `id_class` INT NOT NULL AUTO_INCREMENT ,
  `id_course` INT NOT NULL ,
  `id_subject` INT NOT NULL ,
  `id_user` INT NOT NULL ,
  PRIMARY KEY (`id_class`) ,
  INDEX `fk_class_course_subject1_idx` (`id_course` ASC, `id_subject` ASC) ,
  INDEX `fk_class_user1_idx` (`id_user` ASC) ,
  CONSTRAINT `fk_class_course_subject1`
    FOREIGN KEY (`id_course` , `id_subject` )
    REFERENCES `mydb`.`course_subject` (`id_course` , `id_subject` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_class_user1`
    FOREIGN KEY (`id_user` )
    REFERENCES `mydb`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_class`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user_class` (
  `id_user` INT NOT NULL ,
  `id_class` INT NOT NULL ,
  PRIMARY KEY (`id_user`, `id_class`) ,
  INDEX `fk_user_has_class_class1_idx` (`id_class` ASC) ,
  INDEX `fk_user_has_class_user1_idx` (`id_user` ASC) ,
  CONSTRAINT `fk_user_has_class_user1`
    FOREIGN KEY (`id_user` )
    REFERENCES `mydb`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_class_class1`
    FOREIGN KEY (`id_class` )
    REFERENCES `mydb`.`class` (`id_class` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`question`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`question` (
  `id_question` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(128) NOT NULL ,
  `enabled` BIT NOT NULL ,
  PRIMARY KEY (`id_question`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`survey`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`survey` (
  `id_survey` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(128) NOT NULL ,
  `enabled` BIT NOT NULL ,
  `start` DATETIME NOT NULL ,
  `deadline` DATETIME NOT NULL ,
  PRIMARY KEY (`id_survey`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`survey_question`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`survey_question` (
  `id_survey` INT NOT NULL ,
  `id_question` INT NOT NULL ,
  PRIMARY KEY (`id_survey`, `id_question`) ,
  INDEX `fk_survey_has_question_question1_idx` (`id_question` ASC) ,
  INDEX `fk_survey_has_question_survey1_idx` (`id_survey` ASC) ,
  CONSTRAINT `fk_survey_has_question_survey1`
    FOREIGN KEY (`id_survey` )
    REFERENCES `mydb`.`survey` (`id_survey` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_survey_has_question_question1`
    FOREIGN KEY (`id_question` )
    REFERENCES `mydb`.`question` (`id_question` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`survey_class`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`survey_class` (
  `id_survey` INT NOT NULL ,
  `id_class` INT NOT NULL ,
  PRIMARY KEY (`id_survey`, `id_class`) ,
  INDEX `fk_survey_has_class_class1_idx` (`id_class` ASC) ,
  INDEX `fk_survey_has_class_survey1_idx` (`id_survey` ASC) ,
  CONSTRAINT `fk_survey_has_class_survey1`
    FOREIGN KEY (`id_survey` )
    REFERENCES `mydb`.`survey` (`id_survey` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_survey_has_class_class1`
    FOREIGN KEY (`id_class` )
    REFERENCES `mydb`.`class` (`id_class` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`answer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`answer` (
  `id_survey` INT NOT NULL ,
  `id_class` INT NOT NULL ,
  `id_user` INT NOT NULL ,
  `id_question` INT NOT NULL ,
  `value` TINYINT NULL ,
  PRIMARY KEY (`id_survey`, `id_class`, `id_user`, `id_question`) ,
  INDEX `fk_answer_class1_idx` (`id_class` ASC) ,
  INDEX `fk_answer_user1_idx` (`id_user` ASC) ,
  INDEX `fk_answer_question1_idx` (`id_question` ASC) ,
  CONSTRAINT `fk_answer_survey1`
    FOREIGN KEY (`id_survey` )
    REFERENCES `mydb`.`survey` (`id_survey` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_class1`
    FOREIGN KEY (`id_class` )
    REFERENCES `mydb`.`class` (`id_class` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_user1`
    FOREIGN KEY (`id_user` )
    REFERENCES `mydb`.`user` (`id_user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_question1`
    FOREIGN KEY (`id_question` )
    REFERENCES `mydb`.`question` (`id_question` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
