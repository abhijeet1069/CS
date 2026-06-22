# SQLITE3

SQLite is an in process library that implements a self contained, serverless, zero-configuration,
transactional SQL database engine. Think of SQLite not as a replacement for oracle but as a
replacement for fopen()

## Basic commands

### Open a db

```sql
sqlite3 mydb.db
```

### Show tables in the DB

```sql
.tables
```

### Show schema of table in DB

```sql
CREATE TABLE person(name TEXT, age INTEGER);
```

### Show results in a box

```sql
.mode box
```

### Output data in CSV file

Outputs data in output.csv

```sql
sqlite> .mode csv
sqlite> .headers on
sqlite> .output output.csv
sqlite> select * from person;
```

### Output data back into terminal

```sql
sqlite> .mode box
sqlite> .output stdout
sqlite> select * from person;
```

### Execute a script

```sql
sqlite3 your_database.db < your_script.sql
or
.read your_script.sql
```

## Storage class

SQLite actually stores values as only 5 types. 
Everything else (VARCHAR, BOOLEAN, DATE) maps to these.

- NULL
- INTEGER
- REAL
- TEXT
- BLOB

Unlike PostgresSQL/MySQL, SQLite does not attach type to column strictly.

> SQLite column type = suggestion, not rule. Unless you use STRICT.

## Design Philosophy

- Embedded not client server
SQLite is meant to be inside your application, not a separate DB server.
Perfect for mobile apps, tools, local storage.

- Zero configuration
	•	No user accounts
	•	No port
	•	No daemon
	•	No config files

Just open a file and run SQL.

- Reliability first
Never corrupt the database.

- Small, Fast, Portable

	•	~1–2 MB library
	•	Runs on phones, TVs, cars, routers
	•	Cross-platform

- Flexible typing

The type belongs to the value, not to the column. When you insert a value, SQLite decides the 
storage type.