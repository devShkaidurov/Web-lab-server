
drop table Task;
drop table Project;

create table if not exists Project 
(
	projectId bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	nameProject CHARACTER VARYING(100),
	descriptionProject CHARACTER VARYING(100),
	startDate DATE,
	finishDate DATE
);

create table if not exists Task 
(

	taskId bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	projectId bigint,
	nameTask  CHARACTER VARYING(100),
	descriptionTask  CHARACTER VARYING(100),
	plannedFinishDate DATE,
	isCompleted boolean,
	FOREIGN KEY (projectId) references Project (projectId)
);

insert into project (project_id, name_project, description_project, start_date, finish_date) values 
(1, 'Work task', 'This project contains working task', '2022-04-04', '2024-07-15');

insert into tasks (task_id, project_id, name_task, description_task, planned_finish_date, is_completed) 
values (2, 1, 'выполнить задачу #2', 'посмотреть редмайн', '2024-03-15', true);

insert into tasks (task_id, project_id, name_task, description_task, planned_finish_date, is_completed) 
values (1, 1, 'выполнить задачу #1', 'посмотреть редмайн', '2024-03-15', true);

select * from task;
select * from project;
