-- DUMP GERADO A PARTIR DO DER:
    
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema saturno
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema saturno
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `saturno` DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
-- -----------------------------------------------------
-- Schema saturno
-- -----------------------------------------------------
USE `saturno` ;

-- -----------------------------------------------------
-- Table `saturno`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Usuario` (
  `id_usuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `handle` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `count_amigos` INT UNSIGNED NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `handle_UNIQUE` (`handle` ASC) VISIBLE)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Dados Pessoais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Dados Pessoais` (
  `id_dados_pessoais` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL COMMENT '		',
  `nascimento` DATE NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `url_foto_perfil` VARCHAR(100) NOT NULL,
  `genero` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `CPF` BIGINT(11) ZEROFILL UNSIGNED NULL,
  `cartao_credito` BIGINT(16) UNSIGNED NULL,
  PRIMARY KEY (`id_dados_pessoais`),
  CONSTRAINT `fk_DadosPessoais_Usuario`
    FOREIGN KEY (`id_dados_pessoais`)
    REFERENCES `saturno`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Amigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Amigo` (
  `id_usuario` INT NOT NULL,
  `id_amigo` INT NOT NULL,
  `id_solicitante` INT NOT NULL,
  `id_solicitado` INT NOT NULL,
  `hash_da_amizade` BIGINT(20) NOT NULL,
  `eh_amigo` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_usuario`, `id_amigo`),
  UNIQUE INDEX `id_amigo_UNIQUE` (`id_amigo` ASC) VISIBLE,
  UNIQUE INDEX `hash_da_amizade_UNIQUE` (`hash_da_amizade` ASC) VISIBLE,
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC) VISIBLE)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Post` (
  `id_post` INT UNSIGNED NOT NULL,
  `texto` TEXT(5000) NOT NULL,
  `url_video` VARCHAR(45) NULL,
  `url_foto` VARCHAR(45) NULL,
  `id_usuario` INT UNSIGNED NULL,
  PRIMARY KEY (`id_post`),
  INDEX `fk_id_usuario_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `saturno`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Notificacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Notificacao` (
  `id_notificacao` INT UNSIGNED NOT NULL,
  `id_usuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_notificacao`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `saturno`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Reacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Reacao` (
  `id_reacao` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_post` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_reacao`),
  INDEX `fk_id_post_idx` (`id_post` ASC) VISIBLE,
  CONSTRAINT `fk_id_post`
    FOREIGN KEY (`id_post`)
    REFERENCES `saturno`.`Post` (`id_post`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Comentario` (
  `id_comentario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_post` INT UNSIGNED NOT NULL,
  INDEX `fk_Comentario_Post1_idx` (`id_post` ASC) VISIBLE,
  PRIMARY KEY (`id_comentario`),
  CONSTRAINT `fk_Comentario_Post1`
    FOREIGN KEY (`id_post`)
    REFERENCES `saturno`.`Post` (`id_post`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET utf8;

/*
-- -----------------------------------------------------
-- Table `saturno`.`Chat`		-- Ainda vai ser implementado !!!
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Chat` (
)
ENGINE = InnoDB DEFAULT CHARSET utf8;
*/

-- -----------------------------------------------------
-- Table `saturno`.`SolicitacaoDeAmizade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`SolicitacaoDeAmizade` (
  `hash_solicitacao` INT UNSIGNED NOT NULL,
  `id_solicitante` INT UNSIGNED NOT NULL,
  `id_solicitado` INT UNSIGNED NOT NULL,
  `status` ENUM('enviada', 'aceita', 'recusada') NOT NULL DEFAULT 'enviada',
  PRIMARY KEY (`hash_solicitacao`),
  INDEX `fk_SolicitacaoDeAmizade_Usuario_idx` (`id_solicitante` ASC, `id_solicitado` ASC) VISIBLE,
  CONSTRAINT `fk_SolicitacaoDeAmizade_Usuario`
    FOREIGN KEY (`id_solicitante` , `id_solicitado`)
    REFERENCES `saturno`.`Usuario` (`id_usuario` , `id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET utf8;


-- -----------------------------------------------------
-- Table `saturno`.`Amizade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saturno`.`Amizade` (
  `hash_amizade` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `amigo1` INT UNSIGNED NOT NULL,
  `amigo2` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`hash_amizade`, `amigo2`, `amigo1`),
  INDEX `fk_Usuario_has_Usuario_Usuario2_idx` (`amigo2` ASC) VISIBLE,
  INDEX `fk_Usuario_has_Usuario_Usuario1_idx` (`amigo1` ASC, `amigo2` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_has_Usuario_Usuario1`
    FOREIGN KEY (`amigo1` , `amigo2`)
    REFERENCES `saturno`.`Usuario` (`id_usuario` , `id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Usuario_Usuario2`
    FOREIGN KEY (`amigo2`)
    REFERENCES `saturno`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT uk_amizade					-- 2 usuários ñ podem ser amigos 2x.
    UNIQUE KEY (`amigo2`, `amigo1`),	-- a ordem dos fatores importa ou não? 	
  CONSTRAINT `amigo1_diferente_de_amigo2_CHK`
    CHECK (`amigo1` <> `amigo2`)		-- restrição onde o valor na coluna 1 ñ pode ser igual ao da 2 (<> é !=)    
    )
ENGINE = InnoDB DEFAULT CHARSET utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
