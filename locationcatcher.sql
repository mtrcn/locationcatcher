CREATE TABLE testdb (
    id bigserial NOT NULL,
    username character varying(255),
    message character varying(255),
    lat double precision,
    lng double precision,
    "time" time without time zone
);


ALTER TABLE ONLY testdb
    ADD CONSTRAINT testdb_pk PRIMARY KEY (id);

