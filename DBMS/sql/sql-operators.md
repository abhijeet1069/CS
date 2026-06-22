# Operators in SQL

## Substring 

SUBSTR(string_expression, start_position, [length])


```sql
-- This query is better than like clause where lot of ‘OR’ will be there
SELECT distinct city from station WHERE
substr(city,1,1) in ('a','e','i','o','u');

-- Left and right operators in java

SELECT LEFT('HelloWorld', 5);  -- returns 'Hello'
SELECT RIGHT('HelloWorld', 5); -- returns 'World'
```

## CASE

```sql
-- In SQL, try to copy the values, I misspelt ‘Isosceles’ and it throwed an error.

SELECT
CASE
  WHEN (a+b<=c) or (b+c<=a) or (c+a<=b) THEN 'Not A Triangle'
  WHEN a=b and b=c THEN 'Equilateral'
  WHEN a=b or b=c or c=a THEN 'Isosceles'
  ELSE 'Scalene'
END AS triangle_type
from triangles;
```

## GROUP BY

```sql
select concat(name,'(',left(occupation,1),')') 
from occupations 
order by name;

select concat('There are a total of ',COUNT(*),' ',
lower(occupation),'s.')
from occupations 
group by occupation
order by COUNT(*), occupation;

```

Learn SQL derived tables, also date functions
ORDER BY and GROUP BY