#1
select person.name, company.name 
from person 
join company on person.company_id = company.id 
where company_id != 5;

#2
select company.name, count(person.company_id) 
from person join company on person.company_id = company.id
group by company.id
having count(person.company_id) in (
	select COUNT(company_id)
	from person
	group by company_id
	order by count(company_id) DESC
	LIMIT 1);

