package com.snn.university.repository;

import com.snn.university.model.Schedule;
import com.snn.university.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query("select new com.snn.university.model.Search(p.name, c.name)  from Schedule s left join Professor p on s.professor.id = p.id left join Course  c on s.course.id = c.id ")
    public List<Search> fetchProfCourseDataLeftJoin();
}
