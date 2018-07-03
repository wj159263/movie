
drop table if exists categories;

drop table if exists center_loop;

drop table if exists comment;

drop table if exists sub;

drop table if exists user;

drop table if exists video;

drop table if exists video_detil;

/*==============================================================*/
/* Table: categories                                            */
/*==============================================================*/
create table categories
(
   cid                  tinyint not null,
   cname                varchar(10) not null,
   is_parent            tinyint,
   parentid             tinyint not null,
   primary key (cid)
);

/*==============================================================*/
/* Table: center_loop                                           */
/*==============================================================*/
create table center_loop
(
   id                   varchar(32),
   image                varchar(500)
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comm_id              integer,
   id                   varchar(32) comment '被评论的视频id',
   use_id               varchar(32) comment '评论者',
   time                 timestamp,
   state                tinyint comment '0无效，1有效'
);

/*==============================================================*/
/* Table: sub                                                   */
/*==============================================================*/
create table sub
(
   id                   varchar(32),
   vid_id               varchar(32)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(32) not null,
   account              varchar(20) not null,
   parrword             varchar(35) not null,
   username             varchar(10) not null,
   mail                 varchar(50),
   state                tinyint comment '0：无效，1：有效',
   phone                varchar(20),
   image                varchar(100),
   sex                  tinyint,
   birthday             date,
   job                  varchar(15),
   type                 tinyint comment '0:普通用户，1：管理员',
   primary key (id)
);

/*==============================================================*/
/* Table: video                                                 */
/*==============================================================*/
create table video
(
   id                   varchar(32) not null,
   cid                  tinyint,
   name                 varchar(20) not null,
   title                varchar(20),
   introduce            text,
   image                varchar(500),
   playurl              varchar(500) not null comment '播放url',
   show_time            date,
   country              varchar(20) comment '视频所属地区国家',
   playtimes            int default 0,
   score                double,
   state                tinyint comment '0无效，1有效',
   primary key (id)
);

/*==============================================================*/
/* Table: video_detil                                           */
/*==============================================================*/
create table video_detil
(
   id                   varchar(32),
   use_id               varchar(32),
   uptime               timestamp,
   updated              timestamp
);


