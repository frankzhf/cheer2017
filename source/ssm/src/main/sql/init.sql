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
	last_login DATETIME
) ENGINE=innoDB;

create table tbl_student(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(32),
	stu_no VARCHAR(16),
	sex tinyint(4) comment '0-男，1-女',
	birthday DATE,
	status tinyint(4) comment '0-正常，1-删除',
	created_dt DATETIME
) ENGINE=innoDB;
