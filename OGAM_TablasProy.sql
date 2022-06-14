--Tipos propios
create type full_name as ( 
	fname text,
	lname1 text,
	lname2 text
);

create table category (
	id_cat serial,
	cat varchar(50),
	constraint pk_category primary key (id_cat)
);

--Tablas
create table users (
	id_user varchar(20) not null unique,
	pwd text not null,
	name_usr full_name not null,
	bdate_usr date,
	addr_usr text,
	cel_usr varchar(13),
	tel_usr varchar(13),
	email_usr varchar(100),
	r_acct varchar(3),
	constraint pk_usuarios primary key (id_user)--,
	--foreign key (r_acct) references account (id_acct) on delete cascade
);

create table owners (
	ine varchar(20) not null unique,
	name_ownr text not null,
	bdate_ownr date,
	addr_ownr text,
	cel_ownr varchar(13),
	tel_ownr varchar(13),
	email_ownr varchar(100),
	constraint pk_owners primary key (ine)
);

create table pets (
	id_pet serial,
	name_pet text,
	bdate_pet date,
	specie varchar(50),
	race varchar(50),
	r_sex char(1),
	color varchar(50),
	r_ownr varchar(20),
	other_notes text,
	constraint pk_pets primary key (id_pet),
	foreign key (r_ownr) references owners (ine) on delete cascade
);

create table appointments (
	id_appt serial,
	r_user varchar(20),
	r_owner varchar(20),
	r_pet int,
	address text,
	date_appt date,
	in_hour time,
	r_sector char(1),
	notes text,
	constraint pk_appointments primary key (id_appt),
	foreign key (r_user) references users (id_user) on delete cascade,
	foreign key (r_owner) references owners (ine) on delete cascade,
	foreign key (r_pet) references pets (id_pet) on delete cascade--,
	--foreign key (r_sector) references sector (id_sector) on delete cascade
);

create table appts_consult (
	r_consult varchar(15),
	addr_ref text,
	diagnosis text,
	procedures text,
	medicaments text--,
	--foreign key (r_consult) references consult (id_consult) on delete cascade
) inherits (appointments);

create table appts_hospital (
	illness text,
	procedures text,
	medicaments text
) inherits (appointments);

create table appts_salon (
	r_service int,
	out_hour time,
	products text--,
	--foreign key (r_service) references service (id_service) on delete cascade
) inherits (appointments);

create table med_updates (
	id_medu serial,
	r_id int,
	med_updated_at timestamp,
	r_user_med varchar(20),
	updates text,
	constraint pk_med_updates primary key (id_medu)--,
	--foreign key (r_id) references appointments (id_appt) on delete cascade
);

create table products (
	id_product varchar(15) not null unique,
	name_prod text,
	description text, 
	in_stock int,
	min_stock int,
	price_in float(2),
	price_out float(2),
	r_category int,
	created_at timestamp,
	updated_at timestamp,
	is_active boolean,
	constraint pk_products primary key (id_product),
	foreign key (r_category) references category (id_cat) on delete cascade
);

create table prod_updates (
	id_produ serial,
	r_prod varchar(15),
	prod_updated_at timestamp,
	r_user_prod varchar(20),
	notes_prod text,
	constraint pk_prod_updates primary key (id_produ),
	--foreign key (r_prod) references products (id_product),
	foreign key(r_user_prod) references users (id_user) on delete cascade
);

INSERT INTO users VALUES
('USER', '12345', row('Olga', 'Alarcon', 'Montero'), null, null, null, null, null, 'ADM');