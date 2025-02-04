CREATE TABLE students (
                          id INT PRIMARY KEY NOT NULL,
                          name VARCHAR(100),
                          address VARCHAR(255)
);

INSERT INTO students (
    id,
    name,
    address
) VALUES (
             1,
             'sandrine',
             '25 rue des plantes Niort'
         ), (
             2,
             'Elise',
             '52 rue du pont Poitiers'
         ), (
             3,
             'Clémence',
             '12 rue du port La Rochelle'
         );