-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.38-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para mydb
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;

-- Copiando estrutura para tabela mydb.aluno
CREATE TABLE IF NOT EXISTS `aluno` (
  `aluno_id` int(11) NOT NULL,
  `ra` varchar(45) NOT NULL,
  PRIMARY KEY (`aluno_id`),
  UNIQUE KEY `ra_UNIQUE` (`ra`),
  CONSTRAINT `fk_Aluno_Usuario1` FOREIGN KEY (`aluno_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.atividade
CREATE TABLE IF NOT EXISTS `atividade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tema_id` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `formato_entrega` varchar(45) DEFAULT NULL,
  `dt_inicio` datetime DEFAULT CURRENT_TIMESTAMP,
  `dt_fim` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_atividade_tema1_idx` (`tema_id`),
  CONSTRAINT `fk_atividade_tema1` FOREIGN KEY (`tema_id`) REFERENCES `tema` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.avaliacao
CREATE TABLE IF NOT EXISTS `avaliacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entrega_id` int(11) NOT NULL,
  `turma_aluno_id` int(11) NOT NULL,
  `nota` decimal(4,2) DEFAULT NULL,
  `dt_avaliacao` datetime DEFAULT CURRENT_TIMESTAMP,
  `comentarios` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Avaliacao_entregas1_idx` (`entrega_id`),
  KEY `fk_Avaliacao_Aluno_has_turma1_idx` (`turma_aluno_id`),
  CONSTRAINT `fk_Avaliacao_Aluno_has_turma1` FOREIGN KEY (`turma_aluno_id`) REFERENCES `turma_aluno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avaliacao_entregas1` FOREIGN KEY (`entrega_id`) REFERENCES `entrega` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.banca
CREATE TABLE IF NOT EXISTS `banca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grupo_id` int(11) NOT NULL,
  `data` datetime DEFAULT CURRENT_TIMESTAMP,
  `sala` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_banca_grupo1_idx` (`grupo_id`),
  CONSTRAINT `fk_banca_grupo1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.entrega
CREATE TABLE IF NOT EXISTS `entrega` (
  `grupo_id` int(11) NOT NULL,
  `atividade_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_grupo_has_entregas_entregas1_idx` (`atividade_id`),
  KEY `fk_grupo_has_entregas_grupo1_idx` (`grupo_id`),
  KEY `idx_grupo_ativ` (`grupo_id`,`atividade_id`),
  CONSTRAINT `fk_grupo_has_entregas_entregas1` FOREIGN KEY (`atividade_id`) REFERENCES `atividade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_has_entregas_grupo1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.grupo
CREATE TABLE IF NOT EXISTS `grupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orientador_id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grupo_Professor1_idx` (`orientador_id`),
  CONSTRAINT `fk_grupo_Professor1` FOREIGN KEY (`orientador_id`) REFERENCES `professor` (`professor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.professor
CREATE TABLE IF NOT EXISTS `professor` (
  `professor_id` int(11) NOT NULL,
  `administrador` int(11) DEFAULT '0',
  `matricula` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`professor_id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_Professor_Usuario_idx` (`professor_id`),
  CONSTRAINT `fk_Professor_Usuario` FOREIGN KEY (`professor_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.professores_banca
CREATE TABLE IF NOT EXISTS `professores_banca` (
  `banca_id` int(11) NOT NULL,
  `Professor_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avaliacao` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_banca_has_Professor_Professor1_idx` (`Professor_id`),
  KEY `fk_banca_has_Professor_banca1_idx` (`banca_id`),
  KEY `idx_banca_prof` (`banca_id`,`Professor_id`),
  CONSTRAINT `fk_banca_has_Professor_Professor1` FOREIGN KEY (`Professor_id`) REFERENCES `professor` (`professor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_has_Professor_banca1` FOREIGN KEY (`banca_id`) REFERENCES `banca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.tema
CREATE TABLE IF NOT EXISTS `tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt_cadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  `titulo` varchar(100) NOT NULL,
  `introducao` varchar(250) DEFAULT NULL,
  `requisitos` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.turma
CREATE TABLE IF NOT EXISTS `turma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semestre_letivo` int(11) DEFAULT NULL,
  `ano_letivo` int(11) DEFAULT NULL,
  `sigla` varchar(45) DEFAULT NULL,
  `tema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uk_sigla_ano_semestre` (`semestre_letivo`,`ano_letivo`,`sigla`),
  KEY `fk_turma_tema1_idx` (`tema_id`),
  CONSTRAINT `fk_turma_tema1` FOREIGN KEY (`tema_id`) REFERENCES `tema` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.turma_aluno
CREATE TABLE IF NOT EXISTS `turma_aluno` (
  `Aluno_id` int(11) NOT NULL,
  `turma_id` int(11) NOT NULL,
  `grupo_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_Aluno_has_turma_turma1_idx` (`turma_id`),
  KEY `fk_Aluno_has_turma_Aluno1_idx` (`Aluno_id`),
  KEY `fk_Aluno_has_turma_grupo1_idx` (`grupo_id`),
  KEY `idx_aluno_turma` (`Aluno_id`,`turma_id`),
  CONSTRAINT `fk_Aluno_has_turma_Aluno1` FOREIGN KEY (`Aluno_id`) REFERENCES `aluno` (`aluno_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_turma_grupo1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_turma_turma1` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela mydb.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `identificador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
