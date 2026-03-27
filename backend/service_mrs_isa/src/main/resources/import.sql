insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (1, "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "admin@gmail.com","Jovan","Jovic","Adresa123","Novi Sad","Srbija","064/123-456",true,"ADMIN")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (2, "$2a$12$xk5MpChhW8jj0bWgoE2hkeYmlgvxPVcAzlJckE5js3c3G/VhwuFqe", "pera@gmail.com","Pera","Peric","Adresa456","Sabac","Srbije","065/456-789",true,"CLIENT")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (3, "$2a$12$xk5MpChhW8jj0bWgoE2hkeYmlgvxPVcAzlJckE5js3c3G/VhwuFqe", "zika@gmail.com","Zika","Zikic","Adresa789","Beograd","Srbija","063/963-852",true,"COTTAGE_OWNER")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (4, "$2y$10$k/oMA5N7weh8HafHK3VfhuEAed8qyQNLgnrMUDDHuyZ3w05kW/4dK", "ivan@gmail.com","Ivan","Ivetic","Adresa7891","Beograd","Srbija","063/963-852",true,"SHIP_OWNER")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (5, "$2y$10$k/oMA5N7weh8HafHK3VfhuEAed8qyQNLgnrMUDDHuyZ3w05kW/4dK", "ivan1@gmail.com","Ivan","Ivetic","Adresa255","Beograd","Srbija","063/963-852",true,"FISHING_INSTRUCTOR")

--RESURSI(vikendica, brod, avantura)

insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (1,"Vikendica 1", "Adresa 1","Novi Sad","Vikendica na Tari",100.0,4.5,"Besplatan parking, spa, teretana","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (2,"Vikendica 2", "Adresa 2","Novi Sad", "Vikendica na Zlataru",80.0,4.0,"Besplatan parking","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (3,"Vikendica 3", "Adresa 3", "Novi Sad","Vikendica na Srebrnom jezeru", 50.0, 4.5, "Teretana", "Besplatno otkazivanje najkasnije 3 dana pre pocetka rezervacije")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (4,"Vikendica 4", "Adresa 4", "Beograd", "Vikendica na Divcibarima",120.0,4.5,"Besplatan parking, spa, teretana","Besplatno otkazivanje")


insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (5,"Brod 1", "Adresa 1", "Beograd", "opis broda",120.0,4.1,"Nema dodatne usluge","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (6,"Brod 2", "Adresa 2", "Sabac", "Krstarenje Savom hahaha",200.0,4.1,"Nema dodatne usluge","Otkazivanje najkasnije 3 dana pred polazak")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (7,"Brod 3", "Adresa 3", "Sabac", "opis broda",170.0,3.7,"Nema dodatne usluge","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (8,"Brod 4", "Adresa 4", "Beograd", "opis broda",155.0,4.1,"Nema dodatne usluge","Besplatno otkazivanje")


insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (9,"Avantura 1", "Adresa 123", "Beograd", "opis avanture",60.0,4.1,"Nema dodatne usluge","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (10,"Avantura 2", "Adresa321", "Beograd", "opise avanure 2 ",70.0,4.3,"Nema dodatne usluge","Besplatno otkazivanje najksanije 2 dana pre pocetka")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (11,"Avantura 3 ", "Adresa654", "Beograd", "planinarenje",110.0,4.1,"Nema dodatne usluge","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (12,"Avantura 4 ", "Adresa987", "Novi Sad", "eskurzija",120.0,4.4,"Nema dodatne usluge","Besplatno otkazivanje najkasnije 2 dana pre")


--VLASNICI VIKENDICE

insert into cottage_owner(id) values (3)


--VIKENDICE

insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (1,4,2,3)
insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (2,3,1,3)
insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (3,2,1,3)
insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (4,1,1,3)

--VLASNICI BRODA

insert into ship_owner(id) values (4)

--BRODOVI

insert into ship(id,max_capacity,engine_num,engine_power,ship_length,max_speed,ship_type, owner_id) values(5,100, "458m1","450Ks", "50m","200km/h","kruzer",4)
insert into ship(id,max_capacity,engine_num,engine_power,ship_length,max_speed,ship_type, owner_id) values(6,50, "156i7","300Ks", "20m","100km/h","jahta",4)
insert into ship(id,max_capacity,engine_num,engine_power,ship_length,max_speed,ship_type, owner_id) values(7,150, "858m3","450Ks", "60m","250km/h","kruzer",4)
insert into ship(id,max_capacity,engine_num,engine_power,ship_length,max_speed,ship_type, owner_id) values(8,120, "258m1","250Ks", "40m","230km/h","brod",4)


-- INSTRUKTORI PECANJA
insert into fishing_instructor(id,instructor_bio) values (5,"Biografija instruktora")

-- AVANTURE

insert into adventure(id,max_num_people, instructor_id) values (9,10,5)
insert into adventure(id,max_num_people, instructor_id) values (10,5,5)
insert into adventure(id,max_num_people, instructor_id) values (11,8,5)
insert into adventure(id,max_num_people, instructor_id) values (12,12,5)




