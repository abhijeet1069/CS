# DBMS Topics for Interviews (Backend Focus)

## 🎯 Core High-ROI Topics

### 1. Data Modeling & Normalization
- ER Diagrams → Tables
- Primary Key, Foreign Key, Composite Key
- Normal Forms:
  - 1NF
  - 2NF
  - 3NF
  - (BCNF - optional)
- Denormalization (when and why)

### 2. Indexing
- What is an Index?
- B-Tree Index (default)
- Hash Index (concept)
- Clustered vs Non-Clustered Index
- Composite Index (order matters)
- When indexes slow down performance (writes, memory)

### 3. Transactions & ACID
- Atomicity
- Consistency
- Isolation
- Durability
- Commit / Rollback
- Auto-commit vs Manual transactions

### 4. Isolation Levels
- Read Uncommitted
- Read Committed
- Repeatable Read
- Serializable

#### Anomalies:
- Dirty Read
- Non-repeatable Read
- Phantom Read


### 5. Concurrency Control
- Why locking is needed
- Shared Lock vs Exclusive Lock
- Deadlocks (what + prevention)
- MVCC (basic idea)


### 6. Query Execution Basics
- Full Table Scan vs Index Scan
- Join execution (high-level)
- Query optimization basics
- Why queries become slow


### 7. Constraints & Data Integrity
- NOT NULL
- UNIQUE
- CHECK
- FOREIGN KEY
- Cascading (ON DELETE / UPDATE)

### 8. Scaling Basics
- Vertical Scaling
- Horizontal Scaling
- Read Replicas
- Sharding (concept)
- Caching (DB vs Redis)

## ⚡ Must-Know SQL Concepts (you’re already practicing)
- SELECT, WHERE
- JOINs (INNER, LEFT, RIGHT)
- GROUP BY, HAVING
- Subqueries
- Index usage in queries


## 🚫 Low ROI (Skip or skim)
- Advanced Normal Forms (4NF, 5NF)
- Relational Algebra (deep theory)
- XML Databases
- Deep storage engine internals


## 🧠 Interview Focus

Be able to answer:
- Why is this query slow?
- What index would you add?
- How do transactions work?
- What isolation level would you use?
- How do you design a database for a system?

## 🔥 Core Focus Summary

Indexing + Transactions + Isolation + Basic Design


## 💡 Golden Rule

> SQL solves problems  
> DBMS concepts explain *why your solution works*