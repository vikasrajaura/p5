package ls.p5.web.course.service;

import ls.p5.web.course.entity.Course;
import ls.p5.web.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("courseService")
//@Transactional(value = "jpaTxMgr", readOnly = false)
public class CourseService implements ICourseService {
	
	@Autowired
	private ICourseRepository courseRepository;

	@Override
	public Course save(Course course){
		return courseRepository.save(course);
	}

	@Override
	public List<Course> saveAll(List<Course> courses){
		return courseRepository.saveAll(courses);
	}

	@Override
	public Course persist(Course course){
		return courseRepository.save(course);
	}

	@Override
	public Course update(Course course){
		return courseRepository.save(course);
		// return courseRepository.getOne(course.getCourseId());
	}

	@Override
	public Collection<Course> updateAll(Collection<Course> courses){
		Set<Long> courseIds = new HashSet<>();
		courses.forEach(e -> courseIds.add(e.getCourseId()));
		return courseRepository.findAllById(courseIds);
	}

	@Override
	public void delete(Course course){
		courseRepository.delete(course);
	}

	@Override
	public void deleteAll(List<Course> courses){
		courseRepository.deleteAll(courses);
	}

	@Override
	public void deleteById(Long id){
		courseRepository.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids){
		ids.forEach(id -> courseRepository.deleteById(id));
	}

	@Override
	public Optional<Course> findById(Long id){
		return courseRepository.findById(id);
	}

	@Override
	public List<Course> findAll(){
		return courseRepository.findAll();
	}

	@Override
	public List<Course> findByIds(List<Long> ids){
		return courseRepository.findAllById(ids);
	}

}
