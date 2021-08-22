insert into address(id, street, suburb, state, post_code) values (address_seq.nextVal, '1 Garnett Street', 'Rouse Hill', 'NSW', '2146');
insert into address(id, street, suburb, state, post_code) values (address_seq.nextVal, 'i Garnett Street', 'Rouse Hill', 'NSW', '2146');
insert into address(id, street, suburb, state, post_code) values (address_seq.nextVal, '5 Mognolia Street', 'Westmead', 'NSW', '2147');
insert into address(id, street, suburb, state, post_code) values (address_seq.nextVal, '5 Mognolia Street', 'Westmead', 'NSW', '2147');
insert into contact(id, first_name, last_name, birth_date, email, address_id) values (contact_seq.nextVal, 'Ajeet', 'Kumar', to_date('11/04/1981', 'DD/MM/YYYY'), 'ajeet@gmail.com', 1);
insert into contact(id, first_name, last_name, birth_date, email, address_id) values (contact_seq.nextVal, 'Archana', 'Kumari', to_date('07/04/1986', 'DD/MM/YYYY'), 'archana_kumari@mymail.com', 2);
insert into contact(id, first_name, last_name, birth_date, email, address_id) values (contact_seq.nextVal, 'Sonu', 'Roy', to_date('24/08/1980', 'DD/MM/YYYY'), 'sonu.roy@tiwari.com', 3);
insert into contact(id, first_name, last_name, birth_date, email, address_id) values (contact_seq.nextVal, 'Kanchan', 'Roy', to_date('24/08/1983', 'DD/MM/YYYY'), 'k.roy@somemail.com', 4);
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 1, 'Home', '02-236-905-28');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 1, 'Work', '02-888-977-01');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 1, 'Mobile', '0406-234-999');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 1, 'India', '091-840-990-0775');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 2, 'Home', '02-236-905-28');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 2, 'Work', '02-222-343-61');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 2, 'Mobile', '0406-111-222');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 3, 'Home', '02-705-210-45');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 3, 'Mobile', '0404-772-451');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 4, 'Home', '02-705-210-45');
insert into phone(id, contact_id, phone_type, phone_number) values (phone_seq.nextVal, 4, 'Mobile', '0408-411-311');