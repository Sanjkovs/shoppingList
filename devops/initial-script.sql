CREATE schema if not exists dbproductlist default character set utf8;
use dbproductlist;

CREATE TABLE IF NOT EXISTS product
(
    id      BIGINT not null AUTO_INCREMENT,
    name    varchar(100) not null,
    price   DECIMAL not null,
    category varchar(100) null,
    discount DECIMAL null,
    description varchar(100) null,
    user_id BIGINT null,
    created  timestamp default CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)
    engine = InnoDB
    AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS users
(
    id       BIGINT not null AUTO_INCREMENT,
    login    varchar(100) not null,
    password varchar(100) not null,
    created  timestamp default CURRENT_TIMESTAMP,
    PRIMARY KEY (id)

)
    engine = InnoDB
    AUTO_INCREMENT = 1000;

ALTER table product add constraint user_product_fk foreign key (user_id) references users(id);

Create table if not exists orders
(
    id         BIGINT not null AUTO_INCREMENT,
    product_id BIGINT not null,
    user_id    BIGINT not null,
    created    timestamp default CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)
    engine = InnoDB
    AUTO_INCREMENT = 1000;

Alter table orders
    add constraint orders_users_fk FOREIGN KEY (user_id) references users (id);

Alter table orders
    add constraint orders_product_fk foreign key (product_id) references product (id);

insert into PRODUCT (name, price, category, discount, description, id) values ('apple',200,'none',0,'none',1000);

insert into Product (name, price, category, discount, description) values ('melon',50,'none',0,'none');