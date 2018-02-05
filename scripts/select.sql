--select queries

select 
	s.student_id,
    s.first_name,
    s.last_name,
    css.class_name,
    json_build_object(
        'exam', e.exam_title,
        'examDate', e.exam_date
    ) as exams,
    r.marks_obtained,
    css.subject_name
	from tbl_reports r
    INNER JOIN tbl_students s on r.student_id = s.student_id
    INNER JOIN (select cs.class_subject_id,s.subject_name,c.class_name from tbl_class_subjects cs INNER JOIN tbl_subjects s on cs.subject_id = s.subject_id INNER JOIN tbl_classes c on cs.class_id = c.class_id)css on r.class_subject_id = css.class_subject_id
	INNER JOIN tbl_exams e ON r.exam_id = e.exam_id;



select 
	s.student_id,
	s.first_name,
    s.last_name, 
    s.class_name, 
    json_build_object('exam', e.exam_title,'examDate', e.exam_date) as exams,    
    (select json_agg(json_build_object('subject',subject.subject_name,'full_marks',cs.full_marks,'pass_marks',cs.pass_marks)) as subjects from tbl_class_subjects cs
		INNER JOIN tbl_classes c on cs.class_id = c.class_id
		INNER JOIN tbl_subjects subject on cs.subject_id = subject.subject_id where cs.class_id = s.class_id)
    as subjects
    from tbl_reports r
	INNER JOIN (select 
        tbl_students.student_id,
        tbl_students.first_name,
        tbl_students.last_name,
        tbl_classes.class_name,
        tbl_classes.class_id
    from tbl_students 
    inner join tbl_classes  
    on tbl_students.class_id = tbl_classes.class_id) s 
    on r.student_id = s.student_id
INNER JOIN tbl_exams e ON r.exam_id = e.exam_id
where r.student_id = 1 and r.exam_id = 1;






select * from tbl_exams;
select * from tbl_reports;
select * from tbl_students;
select * from tbl_class_subjects;
select * from tbl_subjects;
select * from tbl_classes;
