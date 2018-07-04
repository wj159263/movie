


drop table if exists category;

drop table if exists center_loop;

drop table if exists comment;

drop table if exists sub;

drop table if exists user;

drop table if exists video;

drop table if exists video_detail;


/*==============================================================*/
/* Table: video                                                 */
/*==============================================================*/
create table video
(
   video_id             varchar(32) not null comment '视频id',
   c_id                 tinyint comment '类目id',
   name                 varchar(20) not null comment '视频名字',
   title                varchar(20) comment '视频标题',
   introduce            text comment '剧情简介',
   image                varchar(500) comment '视频图片',
   playurl              varchar(500) not null comment '播放url',
   show_time            date comment '上映时间',
   country              varchar(20) comment '视频所属地区国家',
   playtimes            int default 0 comment '播放次数',
   score                double comment '评分',
   state                tinyint comment '0无效，1有效',
   primary key (video_id)
);

/*==============================================================*/
/* Table: video_detail                                          */
/*==============================================================*/
create table video_detail
(
   video_id             varchar(32) comment '视频id',
   user_id              varchar(32) comment '上传者',
   uptime               timestamp comment '上传时间',
   updated              timestamp comment '更改时间'
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   c_id                 tinyint not null comment '类目id',
   c_name               varchar(10) not null comment '类目名字',
   is_parent            tinyint comment '是否为父类目',
   parent_id            tinyint not null comment '父级类目',
   primary key (c_id)
);

/*==============================================================*/
/* Table: center_loop                                           */
/*==============================================================*/
create table center_loop
(
   video_id             varchar(32) comment '视频id',
   image                varchar(500) comment '视频图片'
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comm_id              integer comment '评论id',
   video_id             varchar(32) comment '被评论的视频id',
   user_id              varchar(32) comment '评论者',
   time                 timestamp comment '评论时间',
   state                tinyint comment '0无效，1有效'
);

/*==============================================================*/
/* Table: sub                                                   */
/*==============================================================*/
create table sub
(
   user_id              varchar(32) comment '用户id',
   video_id             varchar(32) comment '视频_视频id'
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(32) not null comment '用户id',
   account              varchar(20) not null comment '账号',
   parrword             varchar(35) not null comment '密码',
   nick_name            varchar(10) not null comment '用户昵称',
   mail                 varchar(50) comment '邮箱',
   state                tinyint comment '0：无效，1：有效',
   phone                varchar(20) comment '手机',
   image                varchar(100) comment '头像',
   sex                  tinyint comment '性别',
   birthday             date comment '生日',
   type                 tinyint comment '0:普通用户，1：管理员',
   primary key (user_id)
);



