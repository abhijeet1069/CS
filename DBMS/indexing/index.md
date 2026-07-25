# SQL Index

Indexes in SQL are special database structures that improve query performance by allowing faster access to data instead of scanning the entire table. They help retrieve records efficiently and enhance overall database performance.

By default many DBs use balanced trees in index. It's like a tree of sorted values.

```sh
# A B-tree holding the keys 1 through 9

                  [ 4 ]
                 /     \
           [ 2 ]       [ 6 | 8 ]
          /    \       /    |    \
      [ 1 ]  [ 3 ]  [ 5 ] [ 7 ] [ 9 ]

```

## Quick Checklist

* ✅ Is this column frequently used in WHERE?
* ✅ Is it used in JOIN conditions?
* ✅ Is it used in ORDER BY or GROUP BY?
* ✅ Does it have many distinct values (high cardinality)?
* ✅ Is the table large enough to benefit?
* ❌ Is there already a PRIMARY KEY or UNIQUE index?
* ❌ Am I adding unnecessary write overhead?

# Rules to follow

## Index column used in WHERE

```sql
-- if you frequently run such query
SELECT *
FROM employee
WHERE email = 'abc@gmail.com';

-- then create index on column using where
CREATE INDEX idx_email
ON employee(email);

```

## Index columns used in JOINs

```sql

SELECT *
FROM orders o
JOIN customer c
ON o.customer_id = c.id;

-- create index leads to huge performance improvements
orders.customer_id

```

## Index columns used in order by or group by

```sql
SELECT *
FROM employee
ORDER BY salary;

-- creating index avoids sorting by Postgres
CREATE INDEX idx_salary
ON employee(salary);
```

## Don't index everything

Each index must be updated on
- INSERT
- UPDATE
- DELETE

So, updates on indexed column are more expensive.

## Composite index are powerful

```sql
-- for such queries its better to have a composite index
SELECT *
FROM employee
WHERE department='IT'
AND salary>100000;

CREATE INDEX idx_dept_salary
ON employee(department, salary);
```

## For composite index column order matters

This is called the leftmost prefix rule: PostgreSQL can efficiently use the index starting from the 
leftmost indexed column(s)

```sql
-- suppose an index on
(department, salary)

-- works well
WHERE department='IT'

-- works well
WHERE department='IT'
AND salary>50000

-- doesen't work well, because the index is ordered by department first.
-- 
WHERE salary>50000
```

## Don't duplicate index

Indexes consume disk space, a table of size 5 GB might have an index of 2 GB

```sql
PRIMARY KEY(id)

-- index duplicated, primary key already has one
CREATE INDEX idx_id
ON employee(id);

```

## Foreign keys are not automatically indexed

```sql
-- here child references parent
customer_id REFERENCES customer(id)

-- index created on child table orders
CREATE INDEX idx_customer
ON orders(customer_id);

```

## Measure before adding index

```sql
EXPLAIN ANALYZE
SELECT ...
```

## Large tables benefit the most

Large tables benefit the most, for tables with 50 rows, no need for indexes.

For tables with 10 million rows, the difference is between milliseconds and seconds.

# General topics

- Clustered Index : A clustered index determines how the actual table rows are physically stored.

- Non-clustered index : Here rows are not physically sorted. Only pointer to the rows is sorted