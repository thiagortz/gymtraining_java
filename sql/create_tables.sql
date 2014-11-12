CREATE TABLE Usuarios (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  nome varchar(80) NOT NULL DEFAULT '',
  email varchar(50) NOT NULL DEFAULT '',
  data_nascimento datetime DEFAULT NULL,
  data_criacao datetime NOT NULL,
  data_modificacao datetime DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY usuario_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;