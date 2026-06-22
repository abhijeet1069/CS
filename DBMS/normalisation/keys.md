# Key in DB

A keys is a column (or set of columns) used to:

- Identify rows
- Enforce Uniqueness
- Create relationship

## Primary Key

Uniquely identifies each row.

- Unique
- Not null
- One per table

```sql
CREATE TABLE User(
    id INTEGER PRIMARY KEY,
    name TEXT
);
```
### Multiple primary keys

For multiple primary keys, uniqueness is checked on the pair, not individually.

```sql
drop table if exists name;

create table name(
     first_name text, 
     last_name text,
     weight INTEGER not null,
     PRIMARY KEY (first_name, last_name)
     )strict;

┌────────────┬───────────┬────────┐
│ first_name │ last_name │ weight │
├────────────┼───────────┼────────┤
│ abhijeet   │ kumar     │ 90     │
│ abhijeet   │ kushwaha  │ 90     │
│ abhijeet   │ kush      │ 90     │
└────────────┴───────────┴────────┘

```

## Foreign key

Connects two tables, here book belongs to author

```sql
CREATE TABLE Book(
    id INTEGER PRIMARY KEY,
    author_id INTEGER,
    FOREIGN KEY(author_id) REFERENCES Author(id)
);
```

## Unique key

Prevents duplicate values. Not identity of row, just uniqueness

```sql
email TEXT UNIQUE
```

### Multiple Unique keys

```sql
create table name(
     first_name text, 
     last_name text,
     weight INTEGER not null,
     UNIQUE (first_name, last_name)
     )strict;

┌────────────┬───────────┬────────┐
│ first_name │ last_name │ weight │
├────────────┼───────────┼────────┤
│ abhijeet   │ kushwaha  │ 90     │
│ abhijeet   │ kush      │ 90     │
└────────────┴───────────┴────────┘

-- unqiue checked on pair
sqlite> insert into name values('abhijeet','kushwaha',90);
Runtime error: UNIQUE constraint failed: name.first_name, name.last_name (19)

-- multiple times null value can be inserted, and unique doesnt bother
sqlite> insert into name values(null,null,90);
sqlite> insert into name values(null,null,90);
sqlite> insert into name values(null,null,90);

-- single unqiue is not checked, only pair is checked
sqlite> insert into name (first_name,weight) values ('abhijeet',90);
sqlite> insert into name (first_name,weight) values ('abhijeet',90);
sqlite> insert into name (first_name,weight) values ('abhijeet',90);
sqlite> select * from name;
┌────────────┬───────────┬────────┐
│ first_name │ last_name │ weight │
├────────────┼───────────┼────────┤
│ abhijeet   │           │ 90     │
│ abhijeet   │           │ 90     │
│ abhijeet   │           │ 90     │
└────────────┴───────────┴────────┘
```

## Composite Key

Key made from multiple columns.

```sql
PRIMARY KEY(user_id, role_id)
```

## Candidate Key

Any column that could be primary key. We choose one as primary key.

## Surrogate key

Artificial key like id.

## Natural key

Real-world value used as PK.

Examples:
	•	Aadhaar number
	•	Country code
	•	ISBN

Rare in modern systems.

## Alternate key

Candidate keys not chosen as PK


