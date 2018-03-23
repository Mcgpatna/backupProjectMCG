create table blog
(
  blogid number(5),
  blogName varchar(100),
  blogContent varchar(300),
  loginName varchar(50),
  createDate date,
  likes number(5),
  status varchar2(10)
  )
  
  create sequence myforum_seq start with 1001
  create sequence blgComment_seq start with 1001
  
  create table forum
(
  forumid number(5),
  forumName varchar(100),
  forumContent varchar(300),
  loginName varchar(50),
  createDate date,
  likes number(5),
  status varchar2(10)
  )
  create sequence myforum_seq start with 1001
   create sequence forumComment_seq start with 1001
  
  select * from Forum
  select * from blog
  select * from blogComment
  select * from forumComment
  select * from userdetail
  
  
  
  