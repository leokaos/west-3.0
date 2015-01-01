CREATE TABLE west3.tab_imovel (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  data_angariacao DATETIME NOT NULL,
  
  PRIMARY KEY (id)
);

CREATE TABLE west3.tab_imovel_usuario (

  usuario_id BIGINT UNSIGNED NOT NULL,
  imovel_id BIGINT UNSIGNED NOT NULL,
  
  PRIMARY KEY (usuario_id, imovel_id),
  
  CONSTRAINT fk_imovel_usuario_imovel FOREIGN KEY fk_imovel_usuario_imovel (imovel_id)
    REFERENCES tab_imovel (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  
    CONSTRAINT fk_imovel_usuario_usuario FOREIGN KEY fk_imovel_usuario_usuario (usuario_id)
    REFERENCES tab_usuario (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);