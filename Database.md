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


## Stored Procedure
Stored procedure keeps the pre-compiled sql statements in the database, that improve performance and security.

## View 
A view is a virtual table that stores the query logic. It doesn't store data itself, but shows data from one or more tables.

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

SELECT name, salary,
ROW_NUMBER() OVER (ORDER BY salary DESC) AS rn
FROM employee;


### RANK()
Gives the same rank to tied values and skips the next rank.

SELECT name, salary,
RANK() OVER (ORDER BY salary DESC) AS rnk
FROM employee;


### Dense_Rank()
Gives the same rank to tied values and doesn't skip ranks.

SELECT name, salary,
DENSE_RANK() OVER (ORDER BY salary DESC) AS drnk
FROM employee;


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



## Partition By
Divides rows into groups (like GROUP By but keeps rows).

## Order By
Defines row order inside the window.

## Rows / Range
Controls how many rows are included in the window frame.






# Quries

## Update Query 
UPDATE employee
SET name = 'abc'
WHERE id = 123;

UPDATE table_name
SET column1 = value1, 
    column2 = value2, 
    column3 = value3
WHERE condition;

## Create Table
CREATE TABLE Products (
    ProductID int PRIMARY KEY,
    ProductName varchar(50),
    Price decimal(10, 2),
    StockQuantity int
);


## Insert 
INSERT INTO Products (ProductID, ProductName, Price, StockQuantity)
VALUES (1, 'Laptop', 999.99, 10),
       (2, 'Mouse', 25.00, 50);


## Delete 
DELETE FROM Products 
WHERE ProductID = 2;


### Highest-scoring subject for each student
(like Krishna -> math 98, Alok -> eng 73)

```sql 
SELECT s.name, s.subject, s.mark FROM std s WHERE s.mark = (SELECT MAX(mark) FROM std WHERE name = s.name);
```
