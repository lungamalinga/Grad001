
CREATE TABLE WasteCategories (
    category_id int auto_increment PRIMARY KEY not null,
    name VARCHAR(100) UNIQUE NOT NULL,
    description varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--
CREATE TABLE DisposalGuidelines (
    guideline_id int auto_increment PRIMARY KEY not null,
    category_id int not null,
    instructions varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES WasteCategories(category_id)
);
--
CREATE TABLE RecyclingTips (
    tip_id int auto_increment PRIMARY KEY not null,
    category_id int not null,
    tip_description varchar(255) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES WasteCategories(category_id)
);
