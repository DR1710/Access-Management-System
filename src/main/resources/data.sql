-- user with admin role -> /users
-- user@test.com / test123

-- user with admin, employee role -> /users OR /employees/list
-- sunil@test.com / test123

-- user with admin, manager role -> /users OR /managers
-- john@test.com / test123


-- Insert roles
INSERT INTO ROLES(ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLES(ID, NAME) VALUES (2, 'ROLE_EMPLOYEE');
INSERT INTO ROLES(ID, NAME) VALUES (3, 'ROLE_MANAGER');

-- Admin Role
INSERT INTO `users` VALUES 
(1,'user@test.com','user test','$2a$10$V0soF2GSbvqQKDPdLfqWmOfU3mQVD2ZaVa0fBI4hOGUxTQ6ihbcYC');
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (1, 1);

-- Manager Role 
INSERT INTO `users` VALUES 
(2,'john@test.com','john test','$2a$10$V0soF2GSbvqQKDPdLfqWmOfU3mQVD2ZaVa0fBI4hOGUxTQ6ihbcYC');
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (2, 3);

-- EMPLOYEE Role 
INSERT INTO `users` VALUES 
(3,'sunil@test.com','sunil test','$2a$10$V0soF2GSbvqQKDPdLfqWmOfU3mQVD2ZaVa0fBI4hOGUxTQ6ihbcYC');
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (3, 1);
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (3, 2);






