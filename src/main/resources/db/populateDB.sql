DELETE
FROM meals;
DELETE
FROM user_roles;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, description, date_time, calories)
VALUES (100000, 'Завтрак', '2022-Oct-23 08:00'::timestamp, 500),
       (100001, 'Обед',    '2022-Oct-23 14:00'::timestamp, 1000),
       (100001, 'Ужин',    '2022-Oct-24 20:00'::timestamp, 790);
