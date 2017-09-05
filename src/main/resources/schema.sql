CREATE TABLE receipts (
  id INT UNSIGNED AUTO_INCREMENT,
  uploaded TIME DEFAULT CURRENT_TIME(),
  merchant VARCHAR(255),
  amount DECIMAL(12,2),
  receipt_type INT UNSIGNED,

  PRIMARY KEY (id)
);

CREATE TABLE tags (
  tid INT UNSIGNED AUTO_INCREMENT,
  receip_id INT,
  tag VARCHAR (250),
  PRIMARY KEY (tid),
);