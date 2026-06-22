# SQL JOINs

- INNER → only intersection

- LEFT OUTER → full left circle

- RIGHT OUTER → full right circle

- FULL OUTER → both circles

## Cartesian Product

```sql
sqlite> select * from student;
┌────┬──────────┐
│ id │   name   │
├────┼──────────┤
│ 1  │ Abhijeet │
│ 2  │ Samay    │
│ 3  │ Alice    │
└────┴──────────┘

sqlite> select * from university;
┌────────┬─────────────┐
│ ugc_id │    name     │
├────────┼─────────────┤
│ ISM    │ ISM Dhanbad │
│ IIT    │ IIT Bombay  │
└────────┴─────────────┘

sqlite> select * from student,university; -- 3*2 = 6 rows
┌────┬──────────┬────────┬─────────────┐
│ id │   name   │ ugc_id │    name     │
├────┼──────────┼────────┼─────────────┤
│ 1  │ Abhijeet │ ISM    │ ISM Dhanbad │
│ 1  │ Abhijeet │ IIT    │ IIT Bombay  │
│ 2  │ Samay    │ ISM    │ ISM Dhanbad │
│ 2  │ Samay    │ IIT    │ IIT Bombay  │
│ 3  │ Alice    │ ISM    │ ISM Dhanbad │
│ 3  │ Alice    │ IIT    │ IIT Bombay  │
└────┴──────────┴────────┴─────────────┘

sqlite> select * from university,student;
┌────────┬─────────────┬────┬──────────┐
│ ugc_id │    name     │ id │   name   │
├────────┼─────────────┼────┼──────────┤
│ ISM    │ ISM Dhanbad │ 1  │ Abhijeet │
│ ISM    │ ISM Dhanbad │ 2  │ Samay    │
│ ISM    │ ISM Dhanbad │ 3  │ Alice    │
│ IIT    │ IIT Bombay  │ 1  │ Abhijeet │
│ IIT    │ IIT Bombay  │ 2  │ Samay    │
│ IIT    │ IIT Bombay  │ 3  │ Alice    │
└────────┴─────────────┴────┴──────────┘

```