-- Вметни податоци во табелата project.User
INSERT INTO project.User (Username, Password, FirstName, LastName, Email, PhoneNumber, Gender)
VALUES 
('user1', 'password1', 'John', 'Doe', 'john.doe@hotmail.com', '123456789', 'Male'),
('user2', 'password2', 'Jane', 'Smith', 'jane.smith@outlook.com', '987654321', 'Female'),
('user3', 'password3', 'Mike', 'Gorgi', 'miki.gorgi@gmail.com', '075644848', 'Male'),
('user4', 'password4', 'Nane', 'Gorgi', 'drg@gmail.com', '075420105', 'Female'),
('user5', 'password5', 'Jordan', 'Lazov', 'jocolazov@yahoo.com', '077512003', 'Male'),
('user6', 'password6', 'Sofija', 'Stoimenova', 'sofi@yahoo.com', '075100200', 'Female'),
('user7', 'password7', 'Zive', 'Gligorov', 'zicogligorov@icloud.com', '077522455', 'Male'),
('user8', 'password8', 'Aneta', 'Gjorgjieva', 'anegorgieva@gmail.com', '077522917', 'Female');

-- Вметни податоци во табелата project.Instructor
INSERT INTO project.Instructor (HireDate, PricePerWorkout, UserFK)
VALUES 
('2023-01-01', 1000, 3), -- Внеси инструктор со ID 1
('2023-02-01', 1300, 4),
('2023-02-01', 800, 6); -- Внеси инструктор со ID 2

-- Вметни податоци во табелата project.Member
INSERT INTO project.Member (RegistrationDate, ExpirationDate, InstructorFK, UserFK)
VALUES 
('2023-01-01', '2023-12-31', 1, 1), -- Внеси член со ID 1 и инструктор со ID 1
('2023-02-01', '2023-12-31', 2, 2), -- Внеси член со ID 2 и инструктор со ID 2
('2023-02-01', '2023-12-31', 3, 5), -- Внеси член со ID 2 и инструктор со ID 2
('2023-02-01', '2023-12-31', 1, 7), -- Внеси член со ID 2 и инструктор со ID 2
('2023-02-01', '2023-12-31', 2, 8); -- Внеси член со ID 2 и инструктор со ID 2

-- Вметни податоци во табелата project.Gym
INSERT INTO project.Gym (Address, Name, City)
VALUES 
('123 Main St', 'Popaj', 'Negotino'),
('456 Oak St', 'Spiro', 'Timjanik');

-- Вметни податоци во табелата project.Workout
INSERT INTO project.Workout (DurationInMinutes, Type, Price, MemberFK, GymFK)
VALUES 
(60, 'Push', 200, 1, 1), 
(45, 'Pull', 200, 2, 2), 
(60, 'Legs', 200, 3, 1), 
(60, 'Cardio', 200, 4, 1), 
(60, 'Aerobics', 250, 5, 2), 
(60, 'Calisthenics', 300, 1, 1), 
(60, 'Plyometrics', 350, 2, 2),
(60, 'Arms', 150, 3, 2), 
(60, 'CrossFit', 400, 4, 2), 
(60, 'Plyometrics', 500, 5, 1), 
(60, 'CrossFit', 400, 3, 2), 
(60, 'Aerobics', 250, 5, 1); 


-- Вметни податоци во табелата project.Payment
INSERT INTO project.Payment (Date, Amount, MemberFK, WorkoutFK, InstructorFK,GymFK)
VALUES 
('2023-02-15', 1200, 1, 1, 1,1), 
('2023-02-15', 200, 2, 2, null,1), 
('2023-02-15', 1000, 3, 3, 3,1), 
('2023-02-15', 1000, 4, 4, null,1),
('2023-02-15', 1550, 5, 5, 2,1), 
('2023-02-15', 300, 1, 6, null,1), 
('2023-02-15', 350, 2, 7, null,2), 
('2023-02-15', 950, 3, 8, 3,1), 
('2023-02-15', 1400, 4, 9, 1,2), 
('2023-02-15', 1300, 5, 10, 3,1), 
('2023-02-15', 1400, 3, 11, 1,1), 
('2023-02-15', 250, 5, 12, null,2);





