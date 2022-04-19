# university

Summary of design considerations

A university maintains data on professors, departments, courses, and schedules in four tables:
department, professor, course, and schedule.
Build REST end points for the four resources (department, professor, course, and
schedule). Create the example data provided below with these REST endpoints.
Create, Read, Delete Endpoints to be implemented.
Additionally, write a GET REST method(/search) that would query for the names of all
professors and the respective courses they teach. The result should contain the name of the
professor and the names of all the courses he taught or is teaching right now.
The response must contain professor name and the list of the courses he teaches teaches now
or in the past. The professor names may be returned in any order, but the response must not
contain duplicate entries.


Proposed next steps/improvements

- Authentication ,
- Exception handling,
- Logging ,
- Validation,
- Can be improved endpoint response mechanism.
