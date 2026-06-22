# Normalisation

Normalization helps in data integrity. Normalized tables are:

- Easier to understand
- Easier to enhance and extend
- Protected from
    - insertion anomalies
    - update anomalies
    - deletion anomalies

## First normal form

- Each column must have atomic values
- Each column contains values of a single type
- Each row must be uniquely identifiable
- No repeating groups or arrays in any row
- Using row order to convey information is not permitted

```sql

-- bad design : phones are having multiple values
user_id | name | phones
1       | Sam  | 123456,987654

-- correct design
id | name
1  | Sam

id | user_id | phone
1  | 1       | 123456
2  | 1       | 987654

```

```sql
-- terrible design as repeating groups of data items is on a single row
Player_ID |   Inventory
jdog21    |  2 amulets, 4 rings
gila19    |  18 copper coins
trev73    |  5 arrows, 30 copper coins, 7 rings

Player_ID | Quantity_1 | Item_Type_1 | Quantity_2 | Item_Type_2 | Quantity 3 | Item_Type_3
jdog21    | 2          | amulets     | 4          | rings       
```

## Second normal form

- Table should be in 1NF
- Each non key attribute must depend on the entire primary key

## Third normal form

- Table should be in 2NF 
- Should not contain any transitive dependencies
or Each non key attribute in the table must depend on the key, the whole key and nothing but the key.

A->B->C (transtive depedency)

## Fourth normal form

A table should not contain two or more independent multi-valued facts about the same key.

## Fifth normal form

A table should not contain data that can be reconstructed from smaller tables via joins.