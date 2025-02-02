
CREATE TABLE waste_categories (
    category_id int auto_increment PRIMARY KEY not null,
    name VARCHAR(100) NOT NULL,
    description varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
----
CREATE TABLE disposal_guidelines (
    guideline_id int auto_increment PRIMARY KEY not null,
    category_id int not null,
    instructions varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--    FOREIGN KEY (category_id) REFERENCES waste_categories(category_id)
);
----
CREATE TABLE recycling_tips (
    tip_id int auto_increment PRIMARY KEY not null,
    category_id int not null,
    tip_description varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--    FOREIGN KEY (category_id) REFERENCES waste_categories(category_id)
);
