# *ACID Properties*

| Property      | Description                                              | Example Use Case                                      |
|--------------|----------------------------------------------------------|------------------------------------------------------|
| Atomicity    | All parts of a transaction must complete, or none do     | Ensures funds transfer happens only if both accounts are updated |
| Consistency  | Transaction moves database from one valid state to another | Enforces balance and business rules in banking transactions |
| Isolation    | Transactions execute independently of each other         | Prevents interference in concurrent transactions     |
| Durability   | Committed transactions are permanently saved             | Guarantees data persistence even after system crash  |


# Indexing
A technique used to make data search faster in a database, like an index page in a book. 

# **Key**

### Super Key
A set of columns that can uniquely identify a row, even if it has extra columns.
columns : one or more

### Composite Key
A key made using two or more columns together to uniquely identify a row. 
columns : more than one (must)

### Candidate Key
Any column or set of columns that can become a primary key.

### Primary Key
A column that uniquely identified each row in a table and cannot be null.

### Alternate Key
A candidate key that is not chosen as the primary key.

### Unique Key 
A column that ensures all values are unique, but can allow one null value.

### Foreign Key
A column that links one table to another tables's primary key. 


# **Joins**

### Inner Join
Returns only matching records from both tables.

### Outer Join
Return all the records records from both the tables.

### Left Join 
Returns all records from left table and matching records from the right tables.

### Right Join 
Returns all the records from right table and matching records from the left table.

### Cross Join
Return every possible combination of rows from both tables.

### Self Join
A table is joined with itself to compare rows within the same table.


# Stored Procedure
Stored procedure keeps the pre-compiled sql statements in the database, that improve performance.

# View 
A view is a virtual table that stores the query logic. 

### Materialized View
Materialized view stores the result of the query.


# Optimized
by using proper indexing then using stored procedure to encapsulate the logic. if results are expensive and frequently reused, I would also consider caching or materialized views.


# Normalization
it's the process of organizing data to remove duplication and improve data consistency.

**1NF** : Each column must have single value. 

❌ Not in 1NF
| Student | Subjects      |
| ------- | ------------- |
| A       | Math, Science |

✅ In 1NF
| Student | Subject |
| ------- | ------- |
| A       | Math    |
| A       | Science |


# Denormalization
It's the process of adding duplicate data to improve query performance.


# Window Function
Window function perform calculations in rows without grouping them into one row.

## Rank Window Function
### ROW_NUMBER()
Gives  a unique sequence number to each row(no duplicate).

### RANK()
Gives the same rank to tied values and skips the next rank.

### Dense_Rank()
Gives the same rank to tied values and doesn't skip ranks.

## Aggregate Window Functions
It's like normal aggregates, but they don't reduce rows.

sum(), avg(), count(), min(),max()

## Value Window Functions

**LAG()** : Access the previous row's value.

**LEAD()** : Access the next row's value.

**FIRST_VALUE() / LAST_VALUE()** : Returns the first and last values in the windows respectively.

## Union
Union combines results of multiple queries into one result set and removes duplicates.

## SQL Injection
It's a security attack where malicious SQL code is inserted through user input to access or damage the database.





