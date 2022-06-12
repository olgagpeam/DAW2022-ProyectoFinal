--Tipos propios
create type full_name as ( 
	fname text,
	lname1 text,
	lname2 text
);

--create type pet_id as (
--	owner_ine char(4),
--	pet_name text
--);

--Catalogos
create table account(
	id_acct varchar(3),
	type_acct varchar(50),
	constraint pk_account primary key (id_acct)
);

--create table sex (
--	id_sex char(1),
--	sex varchar(10),
--	constraint pk_sex primary key (id_sex)
--);

create table consult (
	id_consult serial,
	consult varchar(20),
	constraint pk_consult primary key (id_consult)
);

create table service (
	id_service serial,
	service varchar(20),
	constraint pk_service primary key (id_service)
);

create table sector (
	id_sector char(1),
	sector varchar(20),
	constraint pk_sector primary key (id_sector)
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
	constraint pk_usuarios primary key (id_user),
	foreign key (r_acct) references account (id_acct)
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
	foreign key (r_sex) references sex (id_sex),
	foreign key (r_ownr) references owners (ine)
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
	foreign key (r_user) references users (id_user),
	foreign key (r_owner) references owners (ine),
	foreign key (r_pet) references pets (id_pet),
	foreign key (r_sector) references sector (id_sector)
);

create table appts_consult (
	r_consult int,
	addr_ref text,
	diagnosis text,
	procedures text,
	medicaments text,
	foreign key (r_consult) references consult (id_consult)

) inherits (appointments);

create table appts_hospital (
	illness text,
	procedures text,
	medicaments text
) inherits (appointments);

create table appts_salon (
	r_service int,
	out_hour time,
	products text,
	foreign key (r_service) references service (id_service)
) inherits (appointments);

create table med_updates (
	id_medu serial,
	r_id int,
	med_updated_at timestamp,
	r_user_med varchar(20),
	updates text,
	constraint pk_med_updates primary key (id_medu),
	foreign key (r_id) references appointments (id_appt),
	foreign	key (r_user_med) references users (id_user)
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
	foreign key (r_category) references category (id_cat)
);

create table prod_updates (
	id_produ serial,
	r_prod varchar(15),
	prod_updated_at timestamp,
	r_user_prod varchar(20),
	constraint pk_prod_updates primary key (id_produ),
	foreign key (r_prod) references products (id_product),
	foreign key(r_user_prod) references users (id_user)
);


insert into users values ('OLGA', '12345', row('Olga Guadalupe', 'Alarcon', 'Montero'), '1998-03-26', 'Nicolas Blanco', '2281816634', null, 'olgagpeam@gmail.com')
delete from owners
select * from owners where ine = 'AAMO'
select * from pets
select * from sex
insert into sex values ('F', 'Hembra'), ('M', 'Macho');


	
	<%if (owner.getIne().equals(res[6])) {%> selected <%}%>