--liquibase formatted sql

--changeset kovacskr:0002 context:local
--comment: insert data for use in local environment

INSERT INTO clients (client_name, address, zip_code, city, phone, email)
VALUES
('Alza.hu', 'Róbert Károly körút 54-58.', '1134', 'Budapest', '06 1 701 1111', 'receipt.budapest@alza.hu'),
('Media Markt Soroksár telephely', 'Bevásárló utca 4.', '1239', 'Budapest', '06 1 358 6600', 'mmsoroksar@mediamarkt.hu'),
('Kovács Krisztián', 'Csontváry u. 63. 5. emelet 13.', '1181', 'Budapest', '06 20 412 0911', 'kovacs.krisztian911@gmail.com'),
('Szabó János', 'Kossuth Lajos u. 9.', '2090', 'Nagykovácsi', '06 70 111 2233', 'szabo.janos@gmail.com');


INSERT INTO parcels (sender_id, receiver_id, parcel_no)
VALUES
((SELECT id FROM clients WHERE client_name = 'Alza.hu'), (SELECT id FROM clients WHERE client_name = 'Kovács Krisztián'), '50139-241016-001'),
((SELECT id FROM clients WHERE client_name = 'Alza.hu'), (SELECT id FROM clients WHERE client_name = 'Kovács Krisztián'), '50139-241016-002'),
((SELECT id FROM clients WHERE client_name = 'Media Markt Soroksár telephely'), (SELECT id FROM clients WHERE client_name = 'Kovács Krisztián'),'50139-241016-013'),
((SELECT id FROM clients WHERE client_name = 'Media Markt Soroksár telephely'), (SELECT id FROM clients WHERE client_name = 'Szabó János'),'50139-241016-045'),
((SELECT id FROM clients WHERE client_name = 'Kovács Krisztián'), (SELECT id FROM clients WHERE client_name = 'Szabó János'),'CLFOX-241016-145');

INSERT INTO events (event_name)
VALUES
('Csomagod elkészült (feladásra vár)'),
('Automatában (feladva)'),
('Felvéve (beszállítás folyamatban)'),
('Raktárban'),
('Kiszállítás folyamatban'),
('Automatában (kézbesítve)'),
('Átvéve');

INSERT INTO trackings (parcel_id, event_date, event_id)
VALUES
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-001'), '2024-10-16 06:00:00', (SELECT id FROM events WHERE event_name = 'Csomagod elkészült (feladásra vár)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-002'), '2024-10-16 06:01:00', (SELECT id FROM events WHERE event_name = 'Csomagod elkészült (feladásra vár)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-013'), '2024-10-16 06:10:00', (SELECT id FROM events WHERE event_name = 'Csomagod elkészült (feladásra vár)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-045'), '2024-10-16 06:11:00', (SELECT id FROM events WHERE event_name = 'Csomagod elkészült (feladásra vár)')),
((SELECT id FROM parcels WHERE parcel_no = 'CLFOX-241016-145'), '2024-10-16 07:50:00', (SELECT id FROM events WHERE event_name = 'Automatában (feladva)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-001'), '2024-10-16 10:00:00', (SELECT id FROM events WHERE event_name = 'Felvéve (beszállítás folyamatban)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-002'), '2024-10-16 10:01:00', (SELECT id FROM events WHERE event_name = 'Felvéve (beszállítás folyamatban)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-013'), '2024-10-16 10:10:00', (SELECT id FROM events WHERE event_name = 'Felvéve (beszállítás folyamatban)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-045'), '2024-10-16 10:11:00', (SELECT id FROM events WHERE event_name = 'Felvéve (beszállítás folyamatban)')),
((SELECT id FROM parcels WHERE parcel_no = 'CLFOX-241016-145'), '2024-10-16 11:50:00', (SELECT id FROM events WHERE event_name = 'Felvéve (beszállítás folyamatban)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-001'), '2024-10-16 13:00:00', (SELECT id FROM events WHERE event_name = 'Raktárban')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-002'), '2024-10-16 13:01:00', (SELECT id FROM events WHERE event_name = 'Raktárban')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-013'), '2024-10-16 13:10:00', (SELECT id FROM events WHERE event_name = 'Raktárban')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-045'), '2024-10-16 13:11:00', (SELECT id FROM events WHERE event_name = 'Raktárban')),
((SELECT id FROM parcels WHERE parcel_no = 'CLFOX-241016-145'), '2024-10-16 14:50:00', (SELECT id FROM events WHERE event_name = 'Raktárban')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-013'), '2024-10-16 18:10:00', (SELECT id FROM events WHERE event_name = 'Kiszállítás folyamatban')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-045'), '2024-10-16 18:11:00', (SELECT id FROM events WHERE event_name = 'Kiszállítás folyamatban')),
((SELECT id FROM parcels WHERE parcel_no = 'CLFOX-241016-145'), '2024-10-16 19:50:00', (SELECT id FROM events WHERE event_name = 'Kiszállítás folyamatban')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-013'), '2024-10-17 05:10:00', (SELECT id FROM events WHERE event_name = 'Automatában (kézbesítve)')),
((SELECT id FROM parcels WHERE parcel_no = '50139-241016-045'), '2024-10-17 05:11:00', (SELECT id FROM events WHERE event_name = 'Automatában (kézbesítve)')),
((SELECT id FROM parcels WHERE parcel_no = 'CLFOX-241016-145'), '2024-10-17 06:50:00', (SELECT id FROM events WHERE event_name = 'Automatában (kézbesítve)')),
((SELECT id FROM parcels WHERE parcel_no = 'CLFOX-241016-145'), '2024-10-17 07:50:00', (SELECT id FROM events WHERE event_name = 'Átvéve'));