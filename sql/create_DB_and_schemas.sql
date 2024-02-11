create table if not exists Project 
(
  nameProject CHARACTER VARYING(100) PRIMARY KEY ,
  descriptionProject CHARACTER VARYING(100),
  startDateTime timestamp,
  finishDateTime timestamp
);

create table if not exists Task 
(
  nameTask  CHARACTER VARYING(100) PRIMARY KEY,
  nameProject CHARACTER VARYING(100),
  descriptionTask  CHARACTER VARYING(100),
  plannedFinishDateTime timestamp,
  isComplited boolean,
  FOREIGN KEY (nameProject) references Project (nameProject)
);