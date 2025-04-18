# Schema

In SQL, the database schema is what describes the structure of each table, and the datatypes that each column of the table can contain.

## Insert

Add data to the table

```sql
INSERT INTO boxoffice
(movie_id, rating, sales_in_millions)
VALUES (1, 9.9, 283742034 / 1000000);
```

## Update

Update data in table

```sql
UPDATE mytable
SET column = value_or_expr, 
    other_column = another_value_or_expr, 
    …
WHERE condition;
```

## Delete

Delete rows from table

```sql
DELETE FROM mytable
WHERE condition;
```

## Create Table

```sql
CREATE TABLE IF NOT EXISTS mytable (
    column DataType TableConstraint DEFAULT default_value,
    another_column DataType TableConstraint DEFAULT default_value,
    …
);
```
### Table Data types

- INTEGER, BOOLEAN : The integer datatypes can store whole integer values like the count of a number or an age. In some implementations, the boolean value is just represented as an integer value
                      of just 0 or 1.
- FLOAT, DOUBLE, REAL : The floating point datatypes can store more precise numerical data like measurements or fractional values. Different types can be used depending on the floating point
                          precision required for that value.
- CHARACTER(num_chars), VARCHAR(num_chars), TEXT : The text based datatypes can store strings and text in all sorts of locales. The distinction between the various types generally amount to
                                                   underlaying efficiency of the database when working with these columns.
- DATE, DATETIME : 	SQL can also store date and time stamps to keep track of time series and event data. They can be tricky to work with especially when manipulating data across timezones.
- BLOB : Finally, SQL can store binary data in blobs right in the database. These values are often opaque to the database, so you usually have to store them with the right metadata to requery them.

## Table constraints

- PRIMARY KEY : This means that the values in this column are unique, and each value can be used to identify a single row in this table.
- AUTOINCREMENT : For integer values, this means that the value is automatically filled in and incremented with each row insertion. Not supported in all databases.
- UNIQUE : This means that the values in this column have to be unique, so you can't insert another row with the same value in this column as another row in the table. Differs from the
              PRIMARY KEY in that it doesn't have to be a key for a row in the table.
- NOT NULL : This means that the inserted value can not be NULL.
- CHECK (expression) : This allows you to run a more complex expression to test whether the values inserted are valid. For example, you can check that values are positive, or greater than
                         a specific size, or start with a certain prefix, etc.
- FOREIGN KEY : This is a consistency check which ensures that each value in this column corresponds to another value in a column in another table.

## Altering tables

### Add columns

```sql
ALTER TABLE mytable
ADD column DataType OptionalTableConstraint 
    DEFAULT default_value;
```

### Removing columns

```sql
ALTER TABLE mytable
DROP column_to_be_deleted;
```
### Renaming table

```sql
ALTER TABLE mytable
RENAME TO new_table_name;
```

## Dropping tables

Removes the table entirely including all of its data and metadata.

```sql
DROP TABLE IF EXISTS mytable;
```
