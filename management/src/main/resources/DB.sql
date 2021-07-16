CREATE TABLE public.user_info
(
    id integer NOT NULL DEFAULT nextval('user_info_id_seq'::regclass),
    login_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default",
    role character varying(20) COLLATE pg_catalog."default" NOT NULL,
    delete_flg integer NOT NULL,
    registration_date date,
    expiration_date date,
    CONSTRAINT user_info_pkey PRIMARY KEY (id),
    CONSTRAINT user_info_login_id_key UNIQUE (login_id)
)

-- ユーザー名:test@crossware.co.jp
-- パスワード: password
INSERT INTO public.user_info(login_id, name, password, role, delete_flg, registration_date, expiration_date)
	   VALUES ('test@crossware.co.jp', 'テスト', '$2a$10$F9PClZY7wQBuNHRzqI55rug.3mN55lH6M1.BRYT.rat1hQeij/TJ6', 'ROLE_ADMIN', 0,'2021-07-16', '2022-07-16');

CREATE TABLE public.task_management
(
    id integer NOT NULL DEFAULT nextval('task_management_id_seq'::regclass),
    user_id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    status integer NOT NULL,
    deadline date NOT NULL,
    version integer NOT NULL DEFAULT 0,
    CONSTRAINT task_management_pkey PRIMARY KEY (id)
)

CREATE TABLE public.task_name
(
    name character varying(100) COLLATE pg_catalog."default" NOT NULL
)

CREATE TABLE public.task_number
(
    id integer NOT NULL DEFAULT nextval('task_number_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT task_number_pkey PRIMARY KEY (id)
)

CREATE TABLE public.test_insert
(
    id integer NOT NULL DEFAULT nextval('test_insert_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default"
)

CREATE TABLE public.test_insert2
(
    id integer NOT NULL DEFAULT nextval('test_insert2_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL
)