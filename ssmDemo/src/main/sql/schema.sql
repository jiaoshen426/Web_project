--���ݿ��ʼ���ű�

--�������ݿ�
CREATE DATABASE seckill;
--ʹ�����ݿ�
use seckill;
--������ɱ����
CREATE TABLE seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
`name` varchar(120) NOT NULL COMMENT '��Ʒ����',
`number` int NOT NULL COMMENT '�������',
`start_time` TIMESTAMP NOT NULL COMMENT '��ɱ��ʼʱ��',
`end_time` TIMESTAMP NOT NULL COMMENT '��ɱ����ʱ��',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='��ɱ����';
--��ʼ������
INSERT INTO seckill(name,number,start_time,end_time)
VALUES
  ('1000Ԫ��ɱiPhoneX',100,'2017-12-10 00:00:00','2017-12-11 00:00:00'),
  ('500Ԫ��ɱiPhone8',200,'2017-12-10 00:00:00','2017-12-11 00:00:00'),
  ('300Ԫ��ɱiPad',300,'2017-12-01 00:00:00','2017-12-11 00:00:00'),
  ('200Ԫ��ɱiPhone7',400,'2017-12-01 00:00:00','2017-12-02 00:00:00');
--��ɱ�ɹ���ϸ��
--�û���¼��֤�����Ϣ
CREATE TABLE success_killed(
`seckill_id` bigint NOT NULL COMMENT '��ɱ��Ʒid',
`user_phone` bigint NOT NULL COMMENT '�û��ֻ���',
`state` tinyint NOT NULL DEFAULT -1 COMMENT '״̬��־��-1����Ч 0���ɹ� 1���Ѹ��� 2���ѷ���',
`create_time` TIMESTAMP NOT NULL COMMENT '����ʱ��',
PRIMARY KEY(seckill_id,user_phone),/*��������*/
KEY idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɱ�ɹ���ϸ��';
--�������ݿ� ������MySQL Workbench