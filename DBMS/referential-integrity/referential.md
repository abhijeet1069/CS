# Referential Integrity

If one table refers to another, the reference must always be valid.
- You cannot point to something that doesen't exist
- You cannot break a relationship accidentally

```sql
create table B (
    id int primary key
);

create table A(
    id int primary key,
    b_id int,
    foreign key (b_id) references b(id)
);
```

## Operations

- Insert into B : No restriction
- Insert into A : Inserted values should be present in B
- Update/Delete from B : Depends on constraint, won't allow delete once all incoming connections are removed
- Delete from A : Safe
- Update from A : Updated values should be present in B