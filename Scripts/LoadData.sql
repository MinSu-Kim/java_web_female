create table if not exists post (
zipcode CHAR(5) NULL,
sido VARCHAR(20) NULL,
sigungu VARCHAR(20) NULL,
eupmyeon varchar(20) NULL,
doro VARCHAR(80) NULL,
building1 int(5) NULL,
building2 int(5) NULL
);

load data local INFILE'D:/workspace-proj/java_web_female/DataFiles/대구광역시.txt' into table post
character set'euckr'
fields terminated by'|'
ignore 1 lines
(@zipcode,@sido,@d,@sigungu,@d,@eupmyeon,@d,@d,@doro,@d,@d,@building1,@building2,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, eupmyeon=@eupmyeon, doro=@doro, building1=@building1, building2=@building2

create index idx_post_sido on post(sido);
create index idx_post_doro on post(doro);

select *
from post 
where doro ='태전로7길'
order by building1, building2;