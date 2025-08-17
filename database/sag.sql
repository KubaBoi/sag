-- ** Database generated with pgModeler (PostgreSQL Database Modeler).
-- ** pgModeler version: 1.2.0
-- ** PostgreSQL version: 17.0
-- ** Project Site: pgmodeler.io
-- ** Model Author: ---
-- object: sag | type: ROLE --
-- DROP ROLE IF EXISTS sag;
CREATE ROLE sag WITH 
	LOGIN;
-- ddl-end --


-- ** Database creation must be performed outside a multi lined SQL file. 
-- ** These commands were put in this file only as a convenience.

-- object: sag | type: DATABASE --
-- DROP DATABASE IF EXISTS sag;
CREATE DATABASE sag
	OWNER = sag;
-- ddl-end --


SET search_path TO pg_catalog,public;
-- ddl-end --

-- object: public.driver_type | type: TYPE --
-- DROP TYPE IF EXISTS public.driver_type CASCADE;
CREATE TYPE public.driver_type AS
ENUM ('http');
-- ddl-end --
ALTER TYPE public.driver_type OWNER TO sag;
-- ddl-end --

-- object: public.role_type | type: TYPE --
-- DROP TYPE IF EXISTS public.role_type CASCADE;
CREATE TYPE public.role_type AS
ENUM ('admin','user');
-- ddl-end --
ALTER TYPE public.role_type OWNER TO sag;
-- ddl-end --

-- object: public.service | type: TABLE --
-- DROP TABLE IF EXISTS public.service CASCADE;
CREATE TABLE public.service (
	id uuid NOT NULL,
	prefix text NOT NULL,
	name text NOT NULL,
	version text NOT NULL,
	driver_type public.driver_type NOT NULL,
	port integer NOT NULL,
	source text,
	description text,
	icon text,
	account_id uuid NOT NULL,
	CONSTRAINT service_pk PRIMARY KEY (id),
	CONSTRAINT unique_prefix UNIQUE (prefix),
	CONSTRAINT unique_port UNIQUE (port)
);
-- ddl-end --
ALTER TABLE public.service OWNER TO sag;
-- ddl-end --

-- object: public.account | type: TABLE --
-- DROP TABLE IF EXISTS public.account CASCADE;
CREATE TABLE public.account (
	id uuid NOT NULL,
	user_name text NOT NULL,
	email text NOT NULL,
	role public.role_type NOT NULL,
	password_hash text,
	public_key bytea,
	CONSTRAINT account_pk PRIMARY KEY (id),
	CONSTRAINT unique_user_name UNIQUE (user_name),
	CONSTRAINT unique_email UNIQUE (email)
);
-- ddl-end --
ALTER TABLE public.account OWNER TO sag;
-- ddl-end --

-- object: account_fk | type: CONSTRAINT --
-- ALTER TABLE public.service DROP CONSTRAINT IF EXISTS account_fk CASCADE;
ALTER TABLE public.service ADD CONSTRAINT account_fk FOREIGN KEY (account_id)
REFERENCES public.account (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


