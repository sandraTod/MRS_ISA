insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (1, "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "admin@gmail.com","Jovan","Jovic","Adresa123","Novi Sad","Srbija","064/123-456",true,"ADMIN")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (2, "$2a$12$xk5MpChhW8jj0bWgoE2hkeYmlgvxPVcAzlJckE5js3c3G/VhwuFqe", "pera@gmail.com","Pera","Peric","Adresa456","Sabac","Srbije","065/456-789",true,"CLIENT")
insert into user(id, password,username,name,lastname,address,city,state,phone_num,enabled,role) value (3, "$2a$12$xk5MpChhW8jj0bWgoE2hkeYmlgvxPVcAzlJckE5js3c3G/VhwuFqe", "zika@gmail.com","Zika","Zikic","Adresa789","Beograd","Srbija","063/963-852",true,"COTTAGE_OWNER")

--RESURSI(vikendica, brod, avantura)

insert into reservable_resource(id,name, address, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (1,"Vikendica 1", "Adresa 1", "Vikendica na Tari",100.0,4.5,"Besplatan parking, spa, teretana","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (2,"Vikendica 2", "Adresa 2", "Vikendica na Zlataru",80.0,4.0,"Besplatan parking","Besplatno otkazivanje")
insert into reservable_resource(id,name, address, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (3,"Vikendica 3", "Adresa 3", "Vikendica na Srebrnom jezeru", 50.0, 4.5, "Teretana", "Besplatno otkazivanje najkasnije 3 dana pre pocetka rezervacije")
insert into reservable_resource(id,name, address, description, price_per_day, avg_grade,additional_services,cancellation_condition) values (4,"Vikendica 4", "Adresa 4", "Vikendica na Divcibarima",120.0,4.5,"Besplatan parking, spa, teretana","Besplatno otkazivanje")


--VLASNICI VIKENDICE

insert into cottage_owner(id) values (3)


--VIKENDICE

insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (1,4,2,3)
insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (2,3,1,3)
insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (3,2,1,3)
insert into cottage(id,num_of_beds, num_of_rooms,owner_id) values (4,1,1,3)

