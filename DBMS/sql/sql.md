# SQL

## Create and modify structure (DDL)

```sql
-- create table
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  age INT
);

-- change table
ALTER TABLE users ADD COLUMN email VARCHAR(255);

-- remove table
DROP TABLE users;
```

## Insert data

```sql
INSERT INTO users (name, age)
VALUES ('Satyam', 25);
```

## Read data

```sql
SELECT * FROM users;

SELECT name, age FROM users;

SELECT * FROM users WHERE age > 20;

SELECT * FROM users ORDER BY age DESC;

SELECT * FROM users LIMIT 5;
```

## Update data

```sql
UPDATE users
SET age = 26
WHERE name = 'Satyam';
```

## Delete data

```sql
DELETE FROM users
WHERE age < 18;
```

## Joins

```sql
SELECT u.name, o.amount
FROM users u
JOIN orders o ON u.id = o.user_id;
```

## Aggregation

```sql
SELECT COUNT(*) FROM users;

SELECT AVG(age) FROM users;

SELECT age, COUNT(*)
FROM users
GROUP BY age;
```

## Filtering groups

```sql
SELECT age, COUNT(*)
FROM users
GROUP BY age
HAVING COUNT(*) > 2;
```

## Index

```sql
CREATE INDEX idx_users_name ON users(name);
```

## Constraints

```sql
CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
```