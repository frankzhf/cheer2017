create table tbl_user(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(32),
	credits INT,
	password VARCHAR(64),
	last_login DATETIME,
	last_ip VARCHAR(16)
) ENGINE=innoDB;

create table tbl_user_log(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT,
	ip VARCHAR(16),
	last_login DATETIME,
) ENGINE=innoDB;