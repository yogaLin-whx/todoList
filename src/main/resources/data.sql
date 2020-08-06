DROP Table IF  EXISTS  item;
create  table  item(
    id  int(255)  not null  primary key,
    content  varchar(255),
    status  tinyint(1)
);