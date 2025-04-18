# Introduction to SQL

## Queries with constraints

- =, !=, <, <=, >, >=	        Standard numerical operators
- BETWEEN … AND …	            Number is within range of two values (inclusive)
- NOT BETWEEN … AND …	        Number is not within range of two values (inclusive)
- IN (…)	                    Number exists in a list	col_name IN (2, 4, 6)
- NOT IN (…)	                Number does not exist in a list
- =	                            Case sensitive exact string comparison (notice the single equals)
- != or <>	                    Case sensitive exact string inequality comparison
- LIKE	                        Case insensitive exact string comparison
- NOT LIKE	                    Case insensitive exact string inequality comparison
- %	                            Used anywhere in a string to match a sequence of zero or more characters

## Filtering and sorting results

- DISTINCT      Discard rows that have a duplicate column value
- GROUP BY      Grouping on a certain criteria
- ORDER BY      Each row is sorted alpha-numerically
- LIMIT         Limit number of rows to return
- OFFSET        Specifies where to begin counting the number rows from


## Having clause

SQL applies predicates in the having clause after groups have been formed, so aggregate functions may be used in
the having clause.

```sql
--instead of having we cant use where, as it will give syntax error

select dept_name, avg (salary) as avg_salary
from instructor
group by dept_name
having avg(salary) > 42000;

/*
OP:
"dept_name"     "avg_salary"
"Finance"     85000.000000000000
"History"     61000.000000000000
"Physics"     91000.000000000000
"Comp. Sci." 77333.333333333333
"Biology"     72000.000000000000
"Elec. Eng." 80000.000000000000
*/
```

## Group by

Multiple columns in GROUP BY = group by 1st, then inside that group, group by 2nd, then 3rd, etc.

## Aggregate Functions

- COUNT(*), COUNT(column) : Counts number of rows in the group
- MIN(column) : Smallest numerical value in the specified column
- MAX(column) : Largest numerical value in the specified column
- AVG(column) : Average numerical value in the specified column
- SUM(column) : Largest numerical value in the specified column

## Complete Query

```sql
SELECT DISTINCT column, AGG_FUNC(column_or_expression), …
FROM mytable
    JOIN another_table
      ON mytable.column = another_table.column
    WHERE constraint_expression
    GROUP BY column
    HAVING constraint_expression
    ORDER BY column ASC/DESC
    LIMIT count OFFSET COUNT;
```
