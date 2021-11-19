
/**
 * Author:  S541906
 * Created: Nov 17, 2021
 */
CREATE TABLE public.developers(
DeveloperId varchar(100) Primary Key,
FullName varchar(100),
EmailAddress varchar(100),
Goals varchar(1000),
Skills varchar(100),
LinkedInURL varchar(150),
GitHubURL varchar(150),
Image text
);
 CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(50),
    password text,
    loggedin boolean,
    confirmpassword text
);
CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;