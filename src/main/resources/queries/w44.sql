--a)
select subject_id,
count(subject_id) as students
from student_enrolled
group by subject_id
order by students desc
limit 1;

--b);
select name as subject_name,
count(student_id)
from subject s
left join student_enrolled se on s.id = se.subject_id
group by subject_name;

select t.name,
count(se.student_id)
from subject s
join teacher t on s.teacher_id = t.id
join student_enrolled se on s.id = se.subject_id
group by t.id  ;

--c)
select id,
name from student s
where name like'Ivan';

--d)
select distinct name,
count(name) name_count
from student s
group by name;