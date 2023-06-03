INSERT INTO APP_USER (USERNAME, PASSWORD, ROLE)
VALUES ('admin', 'admin123', 'ADMIN');

INSERT INTO TRAVELER (USERNAME, PASSWORD, ROLE)
VALUES ('uoc_traveler', 'traveler123', 'TRAVELER');

INSERT INTO COMPANY (ID, USERNAME, PASSWORD, ROLE, CIF, NAME, ADDRESS, DESCRIPTION, PHONE, EMAIL)
VALUES ('uoc_company', 'company123', 'COMPANY', '123456789', 'ABC Company', '123 Main Street', 'Travel agency specializing in adventure tours', '123456789', 'uoc_company@example.com');

INSERT INTO DIVE_DIARY (DATE, TIME, SPOT, MAX_DEPTH, TEMPERATURE, VISIBILITY, O2_PERCENTAGE, AIR_IN, AIR_OUT, COMMENT, TRAVELER_ID)
VALUES ('2023-05-10', '09:30:00', 'Great Barrier Reef', 25.6, 28.5, 15, 32, 2000, 500, 'Amazing dive with abundant marine life!', 1),
       ('2023-06-15', '14:45:00', 'Blue Hole', 42.2, 26.8, 20, 30, 1800, 600, 'Deep dive with stunning rock formations.', 1),
       ('2023-07-20', '08:00:00', 'Cenote Dos Ojos', 12.8, 24.5, 25, 28, 2200, 400, 'Incredible cavern dive experience.', 1);

INSERT INTO FAVOURITE_SEARCH (START_DATE, END_DATE, DESTINATION_ID, TRAVELER_ID)
VALUES ('2023-08-15', '2023-08-25', 1, 1),
       ('2023-09-10', '2023-09-20', 2, 1),
       ('2023-10-05', '2023-10-15', 3, 1);