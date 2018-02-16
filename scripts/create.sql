--create master entities
--1.create parent table
--2.create student status table
--4.create exam table
--5.create subject table
--6.create class table
--7.create time table
--8.create teacher table
--9.create section table
--10.create exam_type table

--create dependent entities
--1.create student table
--2.create parent relation student table
--3.create routines table
--4.create attendance table
--5.create tbl_class_subjects table
--6.create tbl_reports table
--6.create tbl_marks table

DROP TABLE IF EXISTS tbl_parents cascade;
DROP TABLE IF EXISTS tbl_genders cascade;
DROP TABLE IF EXISTS tbl_classes cascade;
DROP TABLE IF EXISTS tbl_teachers cascade;
DROP TABLE IF EXISTS tbl_sections cascade;
DROP TABLE IF EXISTS tbl_student_statuses cascade;
DROP TABLE IF EXISTS tbl_subjects cascade;
DROP TABLE IF EXISTS tbl_students cascade;
DROP TABLE IF EXISTS tbl_exam_types cascade;
DROP TABLE IF EXISTS tbl_exams cascade;
DROP TABLE IF EXISTS tbl_marks cascade;
-- DROP TABLE IF EXISTS tbl_relations cascade;
-- DROP TABLE IF EXISTS tbl_times cascade;
-- DROP TABLE IF EXISTS tbl_parent_relation_students cascade;
-- DROP TABLE IF EXISTS tbl_routines cascade;
-- DROP TABLE IF EXISTS tbl_teachers cascade;
-- DROP TABLE IF EXISTS tbl_attendances cascade;
-- DROP TABLE IF EXISTS tbl_class_subjects cascade;
-- DROP TABLE IF EXISTS tbl_reports cascade;



--drop dependent entities
DROP TABLE IF EXISTS tbl_parent_relation_students cascade;

--create gender table
create table tbl_genders(
	gender_id serial primary key not null,
    gender varchar(50) not null
);
--create parent table
create table tbl_parents(
    parent_id serial primary key not null,
    first_name varchar (50) not null,
    last_name varchar (50) not null,
    gender_id integer not null,
    username VARCHAR (50) not null,
    password text not null,
    street varchar (50) ,
    city varchar (50),
    contact_no varchar (50) not null,
    social_link text,
    created_date TIMESTAMP default CURRENT_TIMESTAMP,    
    modified_date TIMESTAMP default null,
    status boolean default false,
    CONSTRAINT fk_gender_id_parents FOREIGN KEY (gender_id) REFERENCES tbl_genders(gender_id)
);

--create class table
create table tbl_classes(
    class_id serial primary key not null,
    class_name varchar (50) not null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT NULL,
    status boolean default false
);

--create teacher table
create table tbl_teachers(
    teacher_id serial primary key not null,
    first_name VARCHAR (50) not null,
    last_name VARCHAR (50) not null,
    gender_id integer not null,
    city VARCHAR (50) not null,
    street VARCHAR (50) not null,
    email VARCHAR (50) not null,
    contact_no varchar(50),
    username VARCHAR (50) not null,
    password text not null,
    social_link text ,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT null,
    status boolean default false,
    CONSTRAINT fk_gender_id_teachers FOREIGN KEY (gender_id) REFERENCES tbl_genders(gender_id)
);


--create section table
create table tbl_sections (
    section_id serial primary key not null,
    section_name varchar (15) not null,
    class_id integer not null,
    teacher_id integer not null,
    created_date TIMESTAMP default CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT NULL,
    status boolean default false,
    CONSTRAINT fk_class_id_section FOREIGN KEY (class_id) REFERENCES tbl_classes(class_id),
    CONSTRAINT fk_teacher_id_section FOREIGN KEY (teacher_id) REFERENCES tbl_teachers(teacher_id)    
);

--create student status table
create table tbl_student_statuses(
    student_status_id serial primary key not null,
    status varchar (50) not null
);

--create subject table
create table tbl_subjects (
    subject_id serial primary key not null,
    subject_name varchar(50) not null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    teacher_id integer not null,
    class_id integer not null,
    modified_date TIMESTAMP DEFAULT NULL,
    status boolean default false,
    constraint fk_teacher_id_subject FOREIGN KEY (teacher_id) REFERENCES tbl_teachers (teacher_id),
    constraint fk_class_id_subject FOREIGN KEY (class_id) REFERENCES tbl_classes (class_id)
);

--create student table
create table tbl_students(
    student_id serial primary key not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar (100) not null,
    contact_no varchar (50) not null,
    gender_id integer not null,
    parent_id integer not null,
    username VARCHAR (50) not null,
    password text not null,
    street varchar (50) not null,
    city varchar (50) not null,
    created_date TIMESTAMP default CURRENT_TIMESTAMP,
    modified_date TIMESTAMP default null,
    class_id integer not null,
    status_id integer not null,
    CONSTRAINT fk_status_id_student FOREIGN KEY (status_id) REFERENCES tbl_student_statuses (student_status_id),
    CONSTRAINT fk_parent_id_student FOREIGN KEY (parent_id) REFERENCES tbl_parents (parent_id),
    CONSTRAINT fk_class_id_student FOREIGN KEY (class_id) REFERENCES tbl_classes (class_id),
    CONSTRAINT fk_gender_id_student FOREIGN KEY (gender_id) REFERENCES tbl_genders (gender_id)
);

--10 create exam type table
create table tbl_exam_types(
    exam_type_id serial primary key not null,
    exam_type varchar (50) not null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP default null,
    status boolean default false
);

--4.create exam table
create table tbl_exams (
    exam_id serial primary key not null,
    subject_id integer not null,
    exam_type_id integer not null,    
    exam_date TIMESTAMP DEFAULT NULL,
    full_mark float,
    pass_mark float,
    class_id integer not null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT NULL,
    CONSTRAINT fk_exam_type_id_exams FOREIGN KEY (exam_type_id) REFERENCES tbl_exam_types (exam_type_id),
    CONSTRAINT fk_subject_id_exams FOREIGN KEY (subject_id) REFERENCES tbl_subjects (subject_id),
    CONSTRAINT fk_class_id_exams FOREIGN KEY (class_id) REFERENCES tbl_classes (class_id)
);

--create marks table
create table tbl_marks (
    mark_id serial primary key not null,
    student_id integer not null,
    exam_id integer not null,
    obtained_mark float,
    CONSTRAINT fk_exam_id_marks foreign key (exam_id) REFERENCES tbl_exams (exam_id),
    CONSTRAINT fk_student_id_marks foreign key (student_id) REFERENCES tbl_students (student_id)
);

--create relation table
-- create table tbl_relations(
--     relation_id serial primary key not null,
--     relation varchar(50) not null
-- );


--7.create time table
-- create table tbl_times (
--     time_id serial primary key not null,
--     time_name varchar (15) not null,
--     created_date TIMESTAMP default CURRENT_TIMESTAMP,
--     modified_date TIMESTAMP DEFAULT NULL,
--     status boolean default false
-- );


-- -- --8 crete teacher table
-- -- create table tbl_teachers(
-- --     teacher_id serial primary key not null,
-- --     first_name VARCHAR (50) not null,
-- --     last_name VARCHAR (50) not null,
-- --     city VARCHAR (50) not null,
-- --     street VARCHAR (50) not null,
-- --     email VARCHAR (50) not null,
-- --     contact_no varchar(50),
-- --     username VARCHAR (50) not null,
-- --     password text not null,
-- --     created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
-- --     modified_date TIMESTAMP DEFAULT null,
-- --     status boolean default false
-- -- );


-- --create dependent entities
-- --1.create student table

-- --2.create parent relation student table
-- create table tbl_parent_relation_students (
--     primary key(student_id,parent_id),
--     student_id integer not null,
--     parent_id integer not null,
--     relation_id integer not null,
--     created_date TIMESTAMP default CURRENT_TIMESTAMP,
--     modified_date TIMESTAMP DEFAULT null,
--     status boolean default false,
--     CONSTRAINT fk_parent_id_parent_relation_student FOREIGN KEY (parent_id) REFERENCES tbl_parents (parent_id),
--     CONSTRAINT fk_student_id_parent_relation_student FOREIGN KEY (student_id) REFERENCES tbl_students (student_id),
--     CONSTRAINT fk_relation_id_parent_relation_student FOREIGN KEY (relation_id) REFERENCES tbl_relations (relation_id)
-- );


-- --3. create routine table
-- create table tbl_routines(
--     routine_id serial primary key not null,
--     class_id integer not null,
--     teacher_id integer not null,
--     subject_id integer not null,
--     time_id integer not null,
--     created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     modified_date TIMESTAMP DEFAULT null,
--     status  boolean DEFAULT false,
--     CONSTRAINT fk_class_id_class_teacher FOREIGN KEY (class_id) REFERENCES tbl_classes (class_id),
--     CONSTRAINT fk_time_id_class_teacher FOREIGN KEY (time_id) REFERENCES tbl_times (time_id),
--     CONSTRAINT fk_teacher_id_class_teacher FOREIGN KEY (teacher_id) REFERENCES tbl_teachers (teacher_id),
--     CONSTRAINT fk_subject_id_class_teacher FOREIGN KEY (subject_id) REFERENCES tbl_subjects (subject_id)
-- );

-- --4.create attendance table
-- create table tbl_attendances (
--     attendance_id serial primary key not null,
--     student_id integer not null,
--     attendance_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     attendance_status boolean default false,
--     CONSTRAINT fk_student_id_class_attendances FOREIGN KEY (student_id) REFERENCES tbl_students (student_id)
-- );

-- --5.create class subject table
-- create table tbl_class_subjects(
--     class_subject_id serial primary key not null,
--     class_id integer not null,
--     subject_id integer not null,
--     full_marks float,
--     pass_marks float,
--     CONSTRAINT fk_class_id_class_subjects FOREIGN KEY (class_id) REFERENCES tbl_classes (class_id),
--     CONSTRAINT fk_subject_id_class_subjects FOREIGN KEY (subject_id) REFERENCES tbl_subjects (subject_id)
-- );

-- --6.create report table
-- create table tbl_reports (
--     report_id serial primary key not null,
--     exam_id integer not null,
--     student_id integer not null,
--     class_subject_id integer not null,
--     marks_obtained float,
--     CONSTRAINT fk_exam_id_reports FOREIGN KEY (exam_id) REFERENCES tbl_exams (exam_id),
--     CONSTRAINT fk_student_id_reports FOREIGN KEY (student_id) REFERENCES tbl_students (student_id),
--     CONSTRAINT fk_class_subject_id_reports FOREIGN KEY (class_subject_id) REFERENCES tbl_class_subjects (class_subject_id)
-- );



