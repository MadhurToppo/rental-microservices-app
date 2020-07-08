SET sql_mode = '';

CREATE TABLE if NOT EXISTS rent (
  id mediumint(8) unsigned NOT NULL auto_increment,
  customerId mediumint default NULL,
  productId mediumint default NULL,
  rentFrom varchar(255),
  rentTill varchar(255),
  location varchar(255) default NULL,
  PRIMARY KEY (id)
) AUTO_INCREMENT=1 engine=innodb;