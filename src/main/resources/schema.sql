create table if not exists station_passenger_history
(
	use_date VARCHAR(10) not null,
	line_number VARCHAR(50) not null,
	station_name VARCHAR(50) not null,
	boarded_number int not null,
	alighted_number int not null,
	created_at TIMESTAMP not null,
	updated_at TIMESTAMP not null,
	primary key (use_date, line_number, station_name)
);