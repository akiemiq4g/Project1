-- 1 Write a SQL query to display all the documents in the collection restaurants.

-- <DONE> SELECT * FROM restaurant;

-- 2 Write a SQL query to display the fields restaurant_id, name, borough and cuisine for all the documents in the collection restaurant.
-- <DONE> SELECT restaurant_id, "name", borough, cuisine FROM restaurant;

-- 3 Write a SQL query to display the fields restaurant_id, name, borough and cuisine, but exclude the field _id for all the documents in the collection restaurant.
-- 

-- 4. Write a SQL query to display the fields restaurant_id, name, borough and zip code, but exclude the field _id for all the documents in the collection restaurant.

-- 5. Write a SQL query to display all the restaurant which is in the borough Bronx.
-- <DONE> SELECT * FROM restaurant WHERE borough = "Bronx"; 

-- 6. Write a SQL query to display the first 5 restaurant which is in the borough Bronx.
-- <DONE> SELECT * FROM restaurant WHERE borough = "Bronx" limit 5 ; 

-- 7.Write a SQL query to display the next 5 restaurants after skipping first 5 which are in the borough Bronx.
-- <DONE> SELECT * FROM restaurant WHERE borough = "Bronx" limit 5,5  ;

-- 8. Write a SQL query to find the restaurants who achieved a score more than 90.
-- SELECT sum(("grades/0/score" + "grades/1/score" + "grades/2/score" + "grades/3/score" + "grades/4/score" + "grades/5/score" + "grades/6/score" + "grades/7/score")/7 * 100) FROM restaurant HAVING sum(("grades/0/score" + "grades/1/score" + "grades/2/score" + "grades/3/score" + "grades/4/score" + "grades/5/score" + "grades/6/score" + "grades/7/score")/7 * 100) > 90;

-- 9. Write a SQL query to find the restaurants that achieved a score, more than 80 but less than 100.

-- 10. Write a SQL query to find the restaurants which locate in latitude value less than -95.754168.Go to the editor

-- 11. Write a SQL query to find the restaurants that do not prepare any cuisine of 'American' and their grade score more than 70 and latitude less than -65.754168.

-- 12. Write a SQL query to find the restaurants which do not prepare any cuisine of 'American' and achieved a score more than 70 and located in the longitude less than -65.754168.
-- Note : Do this query without using $and operator.

-- 13. Write a SQL query to find the restaurants which do not prepare any cuisine of 'American ' and achieved a grade point 'A' not belongs to the borough Brooklyn. The document must be displayed according to the cuisine in descending order.

-- 14. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'Wil' as first three letters for its name.

-- 15. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'ces' as last three letters for its name.

-- 16. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'Reg' as three letters somewhere in its name.

-- 17. Write a SQL query to find the restaurants which belong to the borough Bronx and prepared either American or Chinese dish.

-- 18. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which belong to the borough Staten Island or Queens or Bronx or Brooklyn.

-- 19. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which are not belonging to the borough Staten Island or Queens or Bronxor Brooklyn.

-- 20. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which achieved a score which is not more than 10.

-- 21. Write a SQL query to find the restaurant Id, name, borough and cuisine for those restaurants which prepared dish except 'American' and 'Chinees' or restaurant's name begins with letter 'Wil'.

-- 22. Write a SQL query to find the restaurant Id, name, and grades for those restaurants which achieved a grade of "A" and scored 11 on an ISODate "2014-08-11T00:00:00Z" among many of survey dates..

-- 23. Write a SQL query to find the restaurant Id, name and grades for those restaurants where the 2nd element of grades array contains a grade of "A" and score 9 on an ISODate "2014-08-11T00:00:00Z".

-- 24. Write a SQL query to find the restaurant Id, name, address and geographical location for those restaurants where 2nd element of coord array contains a value which is more than 42 and upto 52..

-- 25. Write a SQL query to arrange the name of the restaurants in ascending order along with all the columns.
SELECT * FROM restaurant order by name;

-- 26. Write a SQL query to arrange the name of the restaurants in descending along with all the columns.

-- 27. Write a SQL query to arranged the name of the cuisine in ascending order and for that same cuisine borough should be in descending order.

-- 28. Write a SQL query to know whether all the addresses contains the street or not.

-- 29. Write a SQL query which will select all documents in the restaurants collection where the coord field value is Double.

-- 30. Write a SQL query which will select the restaurant Id, name and grades for those restaurants which returns 0 as a remainder after dividing the score by 7.

-- 31. Write a SQL query to find the restaurant name, borough, longitude and attitude and cuisine for those restaurants which contains 'mon' as three letters somewhere in its name.

-- 32. Write a SQL query to find the restaurant name, borough, longitude and latitude and cuisine for those restaurants which contain 'Mad' as first three letters of its name.



