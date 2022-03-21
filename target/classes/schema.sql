
/**
 * Author:  S541906
 * Created: Nov 17, 2021
 */
CREATE TABLE public.developers(
DeveloperId text Primary Key,
FullName text,
EmailAddress text,
Goals text,
Skills text,
LinkedInURL text,
GitHubURL text,
Image text
);
 CREATE TABLE public.users (
    id integer NOT NULL,
    username text,
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