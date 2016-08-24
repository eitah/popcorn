use popcorn;

set FOREIGN_KEY_CHECKS = 0;
# truncate table actors;
truncate table movies;
# truncate table actors_movies;
truncate table studios;
set FOREIGN_KEY_CHECKS = 1;

insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-03-11', 'MGM', '2016-08-22', 0);
insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-04-12', 'Fox', '2016-08-22', 0);
insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-05-13', 'Universal', '2016-08-22', 0);
insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-06-14', 'WB', '2016-08-22', 0);
insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-07-15', 'Paramount', '2016-08-22', 0);

INSERT INTO `popcorn`.`movies` (`version`, `name`, `released`, `created_at`, `updated_at`, `genre`, `rating`, `studio_id`)
VALUES
  ('0', 'The Matrix', '1999-03-15', '2001-01-11', '2001-01-11', 'scifi', 'r', '1'),
  ('0', 'Avatar', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
  ('0', 'Star Wars I', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
  ('0', 'Harry Potter', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
  ('0', 'Lord of the Rings', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
  ('0', 'Titantic', '1997-03-15', '2001-01-11', '2001-01-11', 'action', 'pg', '2');

INSERT INTO `popcorn`.`actors` (`version`, `name`, `birthday`, `created_at`, `updated_at`, `gender`)
VALUES
  ('0', 'Keanu Reeves', '1952-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Tom Cruise', '1953-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Jessica Chastain', '1954-03-15', '2001-01-11', '2001-01-11', 'f'),
  ('0', 'Halley Berry', '1955-03-15', '2001-01-11', '2001-01-11', 'f'),
  ('0', 'Jake Gyllenhaal', '1956-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Maggie Gyllenhall', '1957-03-15', '2001-01-11', '2001-01-11', 'f'),
  ('0', 'Liam Nieson', '1958-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Matt Damon', '1959-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Leo DiCaprio', '1960-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Abby Winters', '1961-03-15', '2001-01-11', '2001-01-11', 'f'),
  ('0', 'Jennifer Harris', '1962-03-15', '2001-01-11', '2001-01-11', 'f'),
  ('0', 'Margret Robb', '1963-03-15', '2001-01-11', '2001-01-11', 'f'),
  ('0', 'Ben Travis', '1964-03-15', '2001-01-11', '2001-01-11', 'm'),
  ('0', 'Patrick Stewart', '1965-03-15', '2001-01-11', '2001-01-11', 'm');

INSERT INTO `popcorn`.`actors_movies` (`actor_id`, `movie_id`)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 2),
  (6, 2),
  (7, 2),
  (8, 3),
  (9, 4),
  (10, 4),
  (11, 4),
  (12, 4),
  (13, 4),
  (14, 4),
  (1, 4),
  (2, 4),
  (3, 4),
  (4, 4),
  (5, 4),
  (6, 5),
  (7, 5),
  (8, 5),
  (9, 5),
  (10, 5),
  (11, 5),
  (12, 5),
  (13, 5),
  (14, 5),
  (1, 5),
  (2, 6),
  (3, 6),
  (4, 6),
  (5, 6),
  (6, 6),
  (7, 6),
  (8, 6),
  (9, 6),
  (10, 6),
  (11, 6),
  (12, 6);
