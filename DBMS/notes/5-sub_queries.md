# Sub Queries

```sql
SELECT *
FROM sales_associates
WHERE salary > 
   (SELECT AVG(revenue_generated)
    FROM sales_associates);
```

## Correlated Sub Queries

A more powerful type of subquery is the correlated subquery in which the inner query references, and is dependent on, a column 
or alias from the outer query.

```sql
SELECT *
FROM employees
WHERE salary > 
   (SELECT AVG(revenue_generated)
    FROM employees AS dept_employees
    WHERE dept_employees.department = employees.department);
```

## Existence Tests

```sql
SELECT *, …
FROM mytable
WHERE column
    IN/NOT IN (SELECT another_column
               FROM another_table);
```
