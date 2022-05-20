create table post(
	id serial primary key,
	title varchar(255),
	text text,
	link text UNIQUE,
	created timestamp
);
