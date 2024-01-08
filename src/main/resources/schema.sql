CREATE TYPE sex_enum AS ENUM ('female', 'male', 'unknown');
create table if not exists jbtests.person
(
    id          serial primary key,
    first_name  varchar(36),
    last_name  varchar(36),
    age integer,
    sex sex_enum default 'unknown',
    retired bool default false
    );