package ls.p5.web.restapi;

import jakarta.validation.Valid;
import ls.p5.web.entity.Course;
import ls.p5.web.excepion.ResourceNotFoundException;
import ls.p5.web.service.ICourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseControllerRest {

	/* Common used symbols */
	public static final String UNDERSCORE = "_", HYPHEN = "_", DOT = ".", SLASH = "/";

	/* Common modes */
	public static final String MODE_ADD = "add", MODE_EDIT = "edit", MODE_VIEW = "view", MODE_DELETE = "delete";

	public static final String ADD = "add", SAVE = "save", EDIT = "edit", UPDATE = "update", VIEW = "view", DELETE = "delete";

	/* Messages constants */
	public static final String MSG_ERROR = "ERROR_MSG", MSG_SUCCESS = "SUCCESS_MSG";


	public static final String SLASH_ADD = SLASH + ADD, SLASH_SAVE = SLASH + SAVE, SLASH_EDIT = SLASH + EDIT;
	public static final String SLASH_UPDATE = SLASH + UPDATE, SLASH_VIEW = SLASH + VIEW, SLASH_DELETE = SLASH + DELETE;


	public static final String C_ENTITY = "Course", C_ENTITIES = "Courses", S_ENTITY = "course", S_ENTITIES = "courses";

	public static final String _S_ENTITY = UNDERSCORE + S_ENTITY, _S_ENTITIES = UNDERSCORE + S_ENTITIES, ENTITY_SLASH = S_ENTITY + SLASH;
	public static final String ENTITY_ID = S_ENTITY + "Id";

	public static final String URI_ID = "/{courseId}";

	/* URIs of course controller */
	public static final String ADD_ENTITY = "/addCourse";
	public static final String SAVE_ENTITY = "/saveCourse";
	public static final String EDIT_ENTITY = "/editCourse/{courseId}";
	public static final String UPDATE_ENTITY = "/updateCourse";
	public static final String EDIT_ENTITIES = "/editCourses";
	public static final String UPDATE_ENTITIES = "/updateCourses";
	public static final String VIEW_ENTITY = "/viewCourse/{courseId}";
	public static final String VIEW_ENTITIES = "/viewCourses";
	public static final String DELETE_ENTITY = "/deleteCourse/{courseId}";
	public static final String DELETE_ENTITIES = "/deleteCourses";

	/* return view names */
	public static final String VW_ADD_ENTITY_FORM = "course/add_course";
	public static final String VW_EDIT_ENTITY_FORM = "course/edit_course";
	public static final String VW_EDIT_ENTITIES_FORM = "course/edit_courses";
	public static final String VW_VIEW_ENTITIES =  "course/view_courses";
	public static final String VW_VIEW_ENTITY = "course/view_course";


	@Autowired
	ICourseService courseService;

	@GetMapping(URI_ID)
	public ResponseEntity<Course> getEntityById(@PathVariable("courseId") Long courseId) throws ResourceNotFoundException {
		Course course = courseService.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found for courseId::" + courseId));
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(course, headers, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<Course>> getAllEntities() {
		return new ResponseEntity<List<Course>>(courseService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> createEntity(@Valid @RequestBody Course course) {
		return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Course> updateEntity(@Valid @RequestBody Course course) throws ResourceNotFoundException {
		Course corse = courseService.findById(course.getCourseId()).orElseThrow(
				() -> new ResourceNotFoundException("Course not found while updating for courseId::" + course.getCourseId()));

		corse.setName(course.getName());
		corse.setDescription(course.getDescription());
		courseService.save(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@DeleteMapping(URI_ID)
	public ResponseEntity<Course> deleteEntityById(@PathVariable("courseId") Long courseId) throws ResourceNotFoundException {
		Course course = courseService.findById(courseId).orElseThrow(
				() -> new ResourceNotFoundException("Course not found while deleting for courseId::" + courseId));
		courseService.deleteById(courseId);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	
}
