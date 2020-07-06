SET sql_mode = '';

CREATE TABLE if NOT EXISTS product (
  id mediumint(8) unsigned NOT NULL auto_increment,
  make varchar(255) default NULL,
  model varchar(255) default NULL,
  type varchar(255) default NULL,
  category varchar(255) default NULL,
  year varchar(255) default NULL,
  PRIMARY KEY (id)
) AUTO_INCREMENT=1 engine=innodb;