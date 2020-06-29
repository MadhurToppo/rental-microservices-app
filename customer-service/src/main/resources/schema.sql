SET sql_mode = '';

CREATE TABLE if NOT EXISTS customer (
  id mediumint(8) unsigned NOT NULL auto_increment,
  firstName varchar(255) default NULL,
  lastName varchar(255) default NULL,
  idNumber varchar(11) default NULL,
  address varchar(255) default NULL,
  phoneNumber varchar(100) default NULL,
  PRIMARY KEY (id)
) AUTO_INCREMENT=1 engine=innodb;