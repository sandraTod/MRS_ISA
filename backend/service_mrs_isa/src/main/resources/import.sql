insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (1, "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "admin@gmail.com","Jovan","Jovic","Adresa123","Novi Sad","Srbija","064/123-456",true,"ADMIN")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (2, "$2a$12$xk5MpChhW8jj0bWgoE2hkeYmlgvxPVcAzlJckE5js3c3G/VhwuFqe", "pera@gmail.com","Pera","Peric","Adresa456","Sabac","Srbije","065/456-789",true,"CLIENT")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (3, "$2a$12$xk5MpChhW8jj0bWgoE2hkeYmlgvxPVcAzlJckE5js3c3G/VhwuFqe", "zika@gmail.com","Zika","Zikic","Adresa789","Beograd","Srbija","063/963-852",true,"COTTAGE_OWNER")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (4, "$2y$10$k/oMA5N7weh8HafHK3VfhuEAed8qyQNLgnrMUDDHuyZ3w05kW/4dK", "ivan@gmail.com","Ivan","Ivetic","Adresa7891","Beograd","Srbija","063/963-852",true,"SHIP_OWNER")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (5, "$2y$10$k/oMA5N7weh8HafHK3VfhuEAed8qyQNLgnrMUDDHuyZ3w05kW/4dK", "ivan1@gmail.com","Ivan","Ivetic","Adresa255","Beograd","Srbija","063/963-852",true,"FISHING_INSTRUCTOR")

insert into client(id) values(2)

--RESURSI(vikendica, brod, avantura)

insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (1,"Vikendica 1", "Adresa 1","Novi Sad","Vikendica na Tari",100.0,4.5,"Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (2,"Vikendica 2", "Adresa 2","Novi Sad", "Vikendica na Zlataru",80.0,4.0,"Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (3,"Vikendica 3", "Adresa 3", "Novi Sad","Vikendica na Srebrnom jezeru", 50.0, 4.5, "Besplatno otkazivanje najkasnije 3 dana pre pocetka rezervacije")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (4,"Vikendica 4", "Adresa 4", "Beograd", "Vikendica na Divcibarima",120.0,4.5,"Besplatno otkazivanje")

insert into resource_additional_services(resource_id, additional_services) value (1,"Besplatan parking")
insert into resource_additional_services(resource_id, additional_services) value (1,"Spa")
insert into resource_additional_services(resource_id, additional_services) value (1,"Teretana")

insert into resource_additional_services(resource_id, additional_services) value (2,"Besplatan parking")

insert into resource_additional_services(resource_id, additional_services) value (3,"Teretana")

insert into resource_additional_services(resource_id, additional_services) value (4,"Besplatan parking")
insert into resource_additional_services(resource_id, additional_services) value (4,"Spa")
insert into resource_additional_services(resource_id, additional_services) value (4,"Teretana")

insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (5,"Brod 1", "Adresa 1", "Beograd", "opis broda",120.0,4.1,"Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (6,"Brod 2", "Adresa 2", "Sabac", "Krstarenje Savom hahaha",200.0,4.1,"Otkazivanje najkasnije 3 dana pred polazak")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (7,"Brod 3", "Adresa 3", "Sabac", "opis broda",170.0,3.7,"Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (8,"Brod 4", "Adresa 4", "Beograd", "opis broda",155.0,4.1,"Besplatno otkazivanje")

insert into resource_additional_services(resource_id, additional_services) value (5,"Skiper")
insert into resource_additional_services(resource_id, additional_services) value (5,"wi-fi")
insert into resource_additional_services(resource_id, additional_services) value (5,"Nocna voznja")

insert into resource_additional_services(resource_id, additional_services) value (6,"Skiper")

insert into resource_additional_services(resource_id, additional_services) value (7,"wi-fi")


insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (9,"Avantura 1", "Adresa 123", "Beograd", "opis avanture",60.0,4.1,"Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (10,"Avantura 2", "Adresa321", "Beograd", "opise avanure 2 ",70.0,4.3,"Besplatno otkazivanje najksanije 2 dana pre pocetka")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (11,"Avantura 3 ", "Adresa654", "Beograd", "planinarenje",110.0,4.1,"Besplatno otkazivanje")
insert into reservable_resource(id,name, address, city, description, price_per_day, avg_grade,cancellation_condition) values (12,"Avantura 4 ", "Adresa987", "Novi Sad", "eskurzija",120.0,4.4,"Besplatno otkazivanje najkasnije 2 dana pre")

insert into resource_additional_services(resource_id, additional_services) value (9,"Fotografisanje")
insert into resource_additional_services(resource_id, additional_services) value (9,"Obuka za pocetnike")
insert into resource_additional_services(resource_id, additional_services) value (9,"Osiguranje")

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


--- DOSTUPNI PERIODI

insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (1, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,1 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (2, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,2 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (3, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,3 )


insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (4, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,5 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (5, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,6 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (6, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,7 )


insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (7, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,9 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (8, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,10 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (9, '2026-07-01 10:00', '2026-07-15 12:00', 0, false, 0.0,0,false,11)

--BRZE REZERVACIJE

insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (10, '2026-04-15 10:00', '2026-04-20 12:00', 700, true, 500,4,false,3 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (11, '2026-04-8 10:00', '2026-04-11 12:00', 540, true, 400,4,false,1 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (12, '2026-04-15 10:00', '2026-04-20 12:00', 700, true, 500,7,false, 7 )
insert into availability_period(id,available_from, available_to,price, is_fast_reservation,discount_price,max_people, is_reserved, resource_id) values (13, '2026-04-15 10:00', '2026-04-20 12:00', 700, true, 500,2,false, 11)



