CREATE SCHEMA IF NOT EXISTS USERS;

SET SEARCH_PATH = 'USERS';

CREATE TABLE IF NOT EXISTS APP_USER (
	ID SERIAL PRIMARY KEY,
	USERNAME VARCHAR(20) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	ROLE VARCHAR(20) NOT NULL CHECK (ROLE IN ('TRAVELER', 'COMPANY', 'ADMIN'))
);

CREATE TABLE IF NOT EXISTS TRAVELER (
    DIVING_CERTIFICATION_ID INTEGER,
    DIVING_INSURANCE_ID INTEGER,
    MEDICAL_CERTIFICATE_ID INTEGER,
) INHERITS (APP_USER);

CREATE TABLE IF NOT EXISTS COMPANY (
	CIF VARCHAR(9) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	ADDRESS VARCHAR(255) NOT NULL,
	DESCRIPTION TEXT,
	PHONE VARCHAR(9),
	EMAIL VARCHAR(50)
) INHERITS (APP_USER);

CREATE TABLE IF NOT EXISTS DIVE_DIARY (
  ID SERIAL PRIMARY KEY,
  DATE DATE NOT NULL,
  TIME TIME NOT NULL,
  SPOT VARCHAR(50) NOT NULL,
  DURATION INTEGER,
  MAX_DEPTH DOUBLE PRECISION,
  TEMPERATURE DOUBLE PRECISION,
  VISIBILITY INTEGER,
  O2_PERCENTAGE INTEGER,
  AIR_IN INTEGER,
  AIR_OUT INTEGER,
  COMMENT TEXT,
  TRAVELER_ID BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS FAVOURITE_SEARCH(
    ID SERIAL PRIMARY KEY,
    START_DATE DATE,
    END_DATE DATE,
    DESTINATION_ID BIGINT,
    TRAVELER_ID BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS DIVE_DIARY_IMAGE (
    DIVE_DIARY_ID INTEGER NOT NULL,
    IMAGE_ID INTEGER NOT NULL
);

ALTER TABLE DIVE_DIARY_IMAGE ADD CONSTRAINT PK_DIVE_DIARY_IMAGE PRIMARY KEY (DIVE_DIARY_ID, IMAGE_ID);
ALTER TABLE DIVE_DIARY_IMAGE ADD CONSTRAINT FK_DIVE_DIARY_IMAGE_TRAVELER FOREIGN KEY (DIVE_DIARY_ID) REFERENCES DIVE_DIARY(ID);