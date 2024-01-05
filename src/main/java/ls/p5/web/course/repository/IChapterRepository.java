package ls.p5.web.course.repository;

import ls.p5.web.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChapterRepository extends JpaRepository<Course, Long> {
}
