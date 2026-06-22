# Relationship

In SQL databases, relationships define how data in different tables connect to ensure
data integrity.

## One to One (1:1)

Person--||-----0|--Passport

In Person table, a person is created initially without a passport.
In Passport table, we cannot have 1 passport pointing to 2 people.
1 passport can point only to 1 person in DB

```sql
-- implemented in sqlite3

PRAGMA foreign_keys = ON;

CREATE TABLE Person(
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL
) STRICT;

CREATE TABLE Passport(
    passport_id INTEGER PRIMARY KEY,
    person_id INTEGER UNIQUE,
    number TEXT UNIQUE NOT NULL,
    FOREIGN KEY(person_id) REFERENCES Person(id)
) STRICT;

```

## One to Many (1:N)

** Foreign key does on many's side. ** 

Author-||-----0< Book

```sql
PRAGMA foreign_keys = ON;

CREATE TABLE Author(
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL
) STRICT;

CREATE TABLE Book(
    id INTEGER PRIMARY KEY,
    title TEXT NOT NULL,
    author_id INTEGER NOT NULL,
    FOREIGN KEY(author_id) REFERENCES Author(id)
        ON DELETE CASCADE
) STRICT;

insert into Author(name) values('Charles Dickens');
insert into Author(name) values('William Shakespeare');

insert into Book(title,author_id) values('David Copperfield', 1);
insert into Book(title,author_id) values('Christas Carrol', 1);
insert into Book(title,author_id) values('As you Like it', 2);
insert into Book(title,author_id) values('Macbeth', 2);

-- if you delete Charles Dickens his books automatically get deleted thanks to DELETE CASCADE
-- if you dont apply DELETE CASCASE you cant delete Charles Dickens, unless you first delete his books
```

## Many to One (N:1)

Its same as One to Many viewed from other direction.

## Many to Many (M:N)

Done using 2 One to many relationship

```sql
PRAGMA foreign_keys = ON;

CREATE TABLE User(
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL
) STRICT;

CREATE TABLE Role(
    id INTEGER PRIMARY KEY,
    role_name TEXT UNIQUE NOT NULL
) STRICT;

CREATE TABLE User_Role(
    user_id INTEGER,
    role_id INTEGER,
    PRIMARY KEY(user_id, role_id),
    FOREIGN KEY(user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY(role_id) REFERENCES Role(id) ON DELETE CASCADE
) STRICT;
```