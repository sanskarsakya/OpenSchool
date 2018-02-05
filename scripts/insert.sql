--select queries
select * from tbl_parents;
select * from tbl_relations;
select * from tbl_exams;
select * from tbl_student_statuses;
select * from tbl_subjects;
select * from tbl_classes;
select * from tbl_times;
select * from tbl_teachers;
select * from tbl_students;
select * from tbl_parent_relation_students;
select * from tbl_routines;
select * from tbl_attendances;
select * from tbl_class_subjects;
select * from tbl_reports;

--insert into tbl_parents
insert into tbl_parents(first_name,last_name,contact_no,username,password,street,city) values ('sumit','duwal','98123123','sumitduwal','password123','sanepa','lalitpur');
insert into tbl_parents(first_name,last_name,contact_no,username,password,street,city) values ('kamal','khanal','98497123','kkhanal','kamalkhanal123','kaushaltar','bhaktapur');
insert into tbl_parents(first_name,last_name,contact_no,username,password,street,city) values ('nishesh','wyanju','98123123','nisheshw','nisheshwyanju123','suryabinayak','bhaktapur');
insert into tbl_parents(first_name,last_name,contact_no,username,password,street,city) values ('puzan','sakya','98123123','puzansakya','password123','maitidevi','kathmandu');

--insert into tbl_student_statuses
insert into tbl_student_statuses (status) values ('passout'),('left'),('active'),('transferred');

--insert into tbl_relations
insert into tbl_relations(relation) values ('father'),('mother'),('gaurdian'),('grandfather'),('grandmother');

--insert into tbl_exams
insert into tbl_exams(exam_title,exam_date) values ('first term','2018-02-04 17:59:31.060852'),('second term','2018-02-04 17:59:31.060852'),('third term','2018-02-04 17:59:31.060852');

--insert into tbl_subjects
insert into tbl_subjects(subject_name) values ('math'),('science'),('social studies'),('english'),('nepali');

--insert into tbl_classes
insert into tbl_classes(class_name) values ('one'),('two'),('three');

--insert into tbl_times
insert into tbl_times (time_name) values ('10:00 - 3:00'),('12:00 - 12:00');

--insert into tbl_teachers
insert into tbl_teachers (first_name,last_name,city,street,email,username,password) values ('puzan','sakya','katmandu','maitidevi','puzansakya@gmail.com','puzansakya','password123');
insert into tbl_teachers (first_name,last_name,city,street,email,username,password) values ('kamal','khanal','bhaktapur','kaushaltar','kamalkhanal@gmail.com','kamalkhanal','password123');
insert into tbl_teachers (first_name,last_name,city,street,email,username,password) values ('nisesh','wyanju','bhaktapur','suryabinayak','nisheshw@gmail.com','nisheshwyanju','password123');

--insert into tbl_students
insert into tbl_students(first_name,last_name,email,contact_no,username,password,street,city,class_id,status_id) values ('kamal','khanal','kkhanal@gmail.com','98123123','kamalkhnal','password123','kaushaltar','bhaktapar',1,1);
insert into tbl_students(first_name,last_name,email,contact_no,username,password,street,city,class_id,status_id) values ('sumit','duwal','sumitduwal@gmail.com','98123123','sumitduwal','password123','kaushaltar','bhaktapar',1,1);
insert into tbl_students(first_name,last_name,email,contact_no,username,password,street,city,class_id,status_id) values ('nishesh','wyanju','nisheshwyanju@gmail.com','98123123','kamalkhnal','password123','kaushaltar','bhaktapar',1,1);
insert into tbl_students(first_name,last_name,email,contact_no,username,password,street,city,class_id,status_id) values ('puzan','sakya','puzansakya@gmail.com','9849799166','kamalkhnal','password123','kaushaltar','bhaktapar',2,1);

--insert into tbl_parent_relation_students
insert into tbl_parent_relation_students(student_id,parent_id,relation_id) values (1,1,1);

--insert into tbl_routines
insert into tbl_routines(class_id,teacher_id,subject_id,time_id) values (1,1,1,1);
insert into tbl_routines(class_id,teacher_id,subject_id,time_id) values (2,2,2,2);

--insert into tbl_attendances
insert into tbl_attendances (student_id,attendance_date,attendance_status)values(1,'2018-02-04 18:36:05.624663',true);

--insert into tbl_class_subjects
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(1,1,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(1,2,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(1,3,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(1,4,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(1,5,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(2,1,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(2,2,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(2,3,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(2,4,100,30);
insert into tbl_class_subjects(class_id,subject_id,full_marks,pass_marks) values(2,5,100,30);


--insert into tbl_reports
insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,1,1,14);
insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,1,2,14);
insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,1,3,14);
insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,1,4,14);
insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,1,5,14);
-- insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,2,1,14);
-- insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,3,1,14);
-- insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(1,4,1,14);
-- insert into tbl_reports (exam_id,student_id,class_subject_id,marks_obtained) values(2,4,2,14);

