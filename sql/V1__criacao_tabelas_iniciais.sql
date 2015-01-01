CREATE TABLE west3.tab_usuario (

  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome varchar(30) NOT NULL DEFAULT '',
  senha varchar(40) NOT NULL,
  status tinyint(1) NOT NULL,
  nome_completo varchar(255) NOT NULL,
  bloqueado tinyint(1) NOT NULL DEFAULT '0',
  cor varchar(11) DEFAULT '255,255,255',
  email varchar(50) DEFAULT NULL,
  fake tinyint(1) NOT NULL,
  duplica_recado tinyint(1) NOT NULL,
  telefone varchar(45) NOT NULL,
  
  PRIMARY KEY (id)
);

CREATE TABLE west3.tab_parametro (
 param_name VARCHAR(255) NOT NULL,
 param_tipo VARCHAR(50) NOT NULL,
 param_valor VARCHAR(255) NOT NULL,
 param_descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (param_name)
);

CREATE TABLE west3.tab_recados (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(255) NOT NULL,
  data_entrada DATETIME NOT NULL,
  data_leitura DATETIME NOT NULL,
  id_usuario BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_recado_usuario FOREIGN KEY fk_recado_usuario (id_usuario)
    REFERENCES tab_usuario (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

ALTER TABLE west3.tab_recados MODIFY COLUMN data_leitura DATETIME DEFAULT NULL;

--PARAMETROS INICIAIS

INSERT INTO west3.tab_parametro (param_name,param_tipo,param_valor,param_descricao) VALUES 
 ('dataSite','DATE','17/01/2014','Data inicial do export do Site.'),
 ('dataVivaReal','DATE','01/01/2014','Data inicial do export do Viva Real.'),
 ('emailSuper','STRING','enio@westguerra.com.br','Email do supervisor que receberá avisos de cunho administrativo.'),
 ('periodoIndiceImovel','INTEGER','10','Período em dias para exibir no dashboard.');
