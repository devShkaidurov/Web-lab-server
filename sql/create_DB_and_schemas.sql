
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


insert into project (projectId, nameProject, descriptionProject, startDate, finishDate) values 
(2, 'second proj', 'this is 2', '2001-09-28', '2021-09-28');

select * from project;
