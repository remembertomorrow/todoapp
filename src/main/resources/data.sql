/*
jdbc:h2:mem:testdb
select * from task;
select * from status;
*/

-- //TASKS
INSERT INTO task (title, description, due_date, create_date, modify_date, priority)
VALUES
  ('Create task managing app for Yordex',
   'The goal of this task is to create a simple TODO application, which helps with managing tasks. It is a part of recruitment process at Yordex',
    '2019-07-07 00:00:00.000',
    '2018-10-29 00:00:00.000',
    null,
    'HIGHEST'
    );

INSERT INTO task (title, description, due_date, create_date, modify_date, priority)
VALUES
('Buy a birthday present for mum',
 'She likes anything which relates to France and French language, she likes reading and going out',
 '2019-07-07 00:00:00.000',
 '2018-10-29 00:00:00.000',
 null,
 'HIGH'
);

-- //STATUSES
INSERT INTO status (status, start_date, finish_date, task_id)
VALUES
  ( 'OPEN',
    '2019-07-07 00:00:00.000',
    null,
    (select task_id from task where task_id = 1));

INSERT INTO status (status, start_date, finish_date, task_id)
VALUES
( 'COMPLETED',
  '2019-07-01 00:00:00.000',
  null,
  (select task_id from task where task_id = 2));
