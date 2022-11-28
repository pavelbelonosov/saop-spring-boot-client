CREATE TABLE country (
  id UUID PRIMARY KEY,
  iso_code VARCHAR(64) NOT NULL,
  name VARCHAR(64) NOT NULL,
  capital_city VARCHAR(64) NOT NULL,
  phone_code VARCHAR(64) NOT NULL,
  continent_code VARCHAR(64) NOT NULL,
  currency_iso_code VARCHAR(64) NOT NULL,
  country_flag_link VARCHAR(128) NOT NULL
 );
