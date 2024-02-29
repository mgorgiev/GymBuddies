DROP SCHEMA IF EXISTS project CASCADE;
CREATE SCHEMA project;

drop table if exists project.User;
drop table if exists project.Instructor;
drop table if exists project.Member;
drop table if exists project.Payment;
drop table if exists project.Gym;


CREATE TABLE project.User (
    ID SERIAL PRIMARY KEY,
    Username VARCHAR(256) NOT NULL,
    Password VARCHAR(256) NOT NULL,
    FirstName VARCHAR(256) NOT NULL,
    LastName VARCHAR(256) NOT NULL,
    Email VARCHAR(256) NOT NULL,
    PhoneNumber VARCHAR(256),
    Gender VARCHAR(256),
    CONSTRAINT "unique_username" UNIQUE (Username),
    CONSTRAINT "unique_email" UNIQUE (Email)
);

CREATE TABLE project.Instructor (
    ID SERIAL PRIMARY KEY,
    HireDate DATE NOT NULL,
    UserFK INT NOT NULL,
    PricePerWorkout INT NOT NULL,
    CONSTRAINT fk_instructor_user FOREIGN KEY (UserFK) REFERENCES project.User(ID)
);

CREATE TABLE project.Member (
    ID SERIAL PRIMARY KEY,
    RegistrationDate DATE NOT NULL,
    ExpirationDate DATE NOT NULL,
    InstructorFK INT,
    UserFK INT NOT NULL,
    CONSTRAINT fk_member_user FOREIGN KEY (UserFK) REFERENCES project.User(ID),
    CONSTRAINT fk_member_instructor FOREIGN KEY (InstructorFK) REFERENCES project.Instructor(ID)
);

CREATE TABLE project.Gym (
    ID SERIAL PRIMARY KEY,
    Address VARCHAR(256) NOT NULL,
    Name VARCHAR(256) NOT NULL,
    City VARCHAR(256) NOT NULL
);

CREATE TYPE project.WorkoutType AS ENUM (
	        'Cardio',
	        'Push',
	        'Pull',
	        'Legs',
			'Arms',
			'Plyometrics',
			'Aerobics',
			'Calisthenics',
			'CrossFit');

CREATE TABLE project.Workout (
    ID SERIAL PRIMARY KEY,
    DurationInMinutes INT,
    Type project.WorkoutType not NULL,
    Price INT NOT NULL,
    MemberFK INT NOT NULL,
    GymFK INT NOT NULL,
    CONSTRAINT fk_workout_member FOREIGN KEY (MemberFK) REFERENCES project.Member(ID),
    CONSTRAINT fk_workout_gym FOREIGN KEY (GymFK) REFERENCES project.Gym(ID)
);


CREATE TABLE project.Payment (
    ID SERIAL PRIMARY KEY,
    Date DATE NOT NULL,
    Amount INT NOT NULL,
    MemberFK INT NOT NULL,
    InstructorFK INT,
    WorkoutFK INT not NULL,
    GymFK INT not null,
    
    CONSTRAINT fk_payment_gym FOREIGN KEY (GymFK) REFERENCES project.Gym(ID),
    CONSTRAINT fk_payment_member FOREIGN KEY (MemberFK) REFERENCES project.Member(ID),
    CONSTRAINT fk_payment_instructor FOREIGN KEY (InstructorFK) REFERENCES project.Instructor(ID),
    CONSTRAINT fk_payment_workout FOREIGN KEY (WorkoutFK) REFERENCES project.Workout(ID)
);
