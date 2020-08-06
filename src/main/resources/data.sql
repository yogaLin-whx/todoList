DROP Table IF  EXISTS  item;
create  table  item(
    id  int  AUTO_INCREMENT  primary key,
    content  varchar(255),
    status   boolean
);