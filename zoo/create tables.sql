CREATE table userLogin (
	userID int(10) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    PRIMARY KEY (userID)
);

INSERT INTO userLogin VALUES
(1, "manager", "qwerty");

CREATE table animal (
	animalID int(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    species VARCHAR(100),
    location VARCHAR(100),
    feedingtime VARCHAR(10),
    caretaker VARCHAR(30),
    vetHistory VARCHAR(300),
    specialNeeds VARCHAR(300),
    PRIMARY KEY (animalID)
);

INSERT INTO animal VALUES
(1, "Jerry", "Mouse", "Area 4", "10:20", "Cristina Blake", "Vaccinated 12/2/2017", "None"),
(2, "Miri", "Parrot", "Area 2", "9:10", "Andrew Fox", "Medical Examination on 11/1/2017", "To be vaccinated on 5/6/17")
;

