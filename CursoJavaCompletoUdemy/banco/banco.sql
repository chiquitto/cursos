DROP TABLE seller;
DROP TABLE department;

CREATE TABLE department (
  Id INTEGER PRIMARY KEY AUTOINCREMENT,
  Name TEXT DEFAULT NULL
);

CREATE TABLE seller (
  Id INTEGER PRIMARY KEY AUTOINCREMENT,
  Name TEXT NOT NULL,
  Email TEXT NOT NULL,
  BirthDate INTEGER NOT NULL,
  BaseSalary REAL NOT NULL,
  DepartmentId INTEGER NOT NULL,
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com',strftime('%s', '1998-04-21 00:00:00'),1000,1),
  ('Maria Green','maria@gmail.com',strftime('%s', '1979-12-31 00:00:00'),3500,2),
  ('Alex Grey','alex@gmail.com',strftime('%s', '1988-01-15 00:00:00'),2200,1),
  ('Martha Red','martha@gmail.com',strftime('%s', '1993-11-30 00:00:00'),3000,4),
  ('Donald Blue','donald@gmail.com',strftime('%s', '2000-01-09 00:00:00'),4000,3),
  ('Alex Pink','bob@gmail.com',strftime('%s', '1997-03-04 00:00:00'),3000,2);