CREATE TABLE west3.tab_perfil (

  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  pagina_dashboard VARCHAR(255) NOT NULL,
  
  PRIMARY KEY (id)
);

CREATE TABLE west3.tab_perfil_usuario (

  usuario_id BIGINT UNSIGNED NOT NULL,
  perfil_id BIGINT UNSIGNED NOT NULL,
  
  PRIMARY KEY (usuario_id, perfil_id),
  
  CONSTRAINT fk_perfil_usuario_perfil FOREIGN KEY fk_perfil_usuario_perfil (perfil_id)
    REFERENCES tab_perfil (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  
    CONSTRAINT fk_perfil_usuario_usuario FOREIGN KEY fk_perfil_usuario_usuario (usuario_id)
    REFERENCES tab_usuario (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

INSERT INTO west3.tab_perfil(nome, pagina_dashboard) VALUES('corretor','dashboard_corretor.xhtml');
INSERT INTO west3.tab_perfil(nome, pagina_dashboard) VALUES('recepcionista','dashboard_recepcionista.xhtml');
INSERT INTO west3.tab_perfil(nome, pagina_dashboard) VALUES('supervisor','dashboard_supervisor.xhtml');