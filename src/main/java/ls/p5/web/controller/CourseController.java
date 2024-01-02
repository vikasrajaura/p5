package ls.p5.web.controller;

import jakarta.validation.Valid;
import ls.p5.web.entity.Course;
import ls.p5.web.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class CourseController {

    /* Messages constants */
    public static final String MSG_ERROR = "ERROR_MSG", MSG_SUCCESS = "SUCCESS_MSG";
    public static final String ENTITY_SUCCESSFULLY_SAVED = "Course successfully Saved";
    public static final String ENTITY_SUCCESSFULLY_UPDATED = "Course successfully Updated";
    public static final String ENTITY_SUCCESSFULLY_DELETED = "Course successfully deleted";

    public static final String ENTITY_NOT_FOUND = "Course not found";

    public static final String C_ENTITY = "Course", C_ENTITIES = "Courses", S_ENTITY = "course", S_ENTITIES = "courses";
    public static final String ENTITY_ID = "courseId";
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

    @RequestMapping(value = { ADD_ENTITY }, method = RequestMethod.GET)
    public ModelAndView newEntityForm(@ModelAttribute Course entity) {
        ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
        mv.addObject(S_ENTITY, entity);
        return mv;
    }

    @RequestMapping(value = { SAVE_ENTITY }, method = RequestMethod.POST)
    public ModelAndView saveEntity(@Valid @ModelAttribute Course entity, BindingResult result) {
        ModelAndView mv = new ModelAndView(VW_ADD_ENTITY_FORM);
        if (result.hasErrors()) {
            mv.addObject(MSG_ERROR, result);
            return mv;
        }

        courseService.save(entity);
        mv = new ModelAndView(VW_VIEW_ENTITY);
        mv.addObject(MSG_SUCCESS, ENTITY_SUCCESSFULLY_SAVED);
        mv.addObject(S_ENTITY, entity);

        return mv;
    }

    @RequestMapping(value = { EDIT_ENTITY }, method = RequestMethod.GET)
    public ModelAndView editEntityForm(@PathVariable(ENTITY_ID) Long id) {
        ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
        Optional<Course> entity = courseService.findById(id);
        if(entity.isPresent())
            mv.addObject(S_ENTITY, entity);
        else mv.addObject(MSG_ERROR, ENTITY_NOT_FOUND);
        return mv;
    }

    @RequestMapping(value = { UPDATE_ENTITY }, method = RequestMethod.POST)
    public ModelAndView updateEntity(@Valid @ModelAttribute Course entity, BindingResult result) {
        ModelAndView mv = new ModelAndView(VW_EDIT_ENTITY_FORM);
        if (result.hasErrors()) {
            mv.addObject(MSG_ERROR, result);
            return mv;
        }

        entity = courseService.update(entity);
        mv = new ModelAndView(VW_VIEW_ENTITY);
        mv.addObject(MSG_SUCCESS, ENTITY_SUCCESSFULLY_UPDATED);
        mv.addObject(S_ENTITY, entity);

        return mv;
    }

    @RequestMapping(value = { EDIT_ENTITIES }, method = RequestMethod.GET)
    public ModelAndView editEntitiesForm() {
        ModelAndView mv = new ModelAndView(VW_EDIT_ENTITIES_FORM);
        return mv;
    }

    @RequestMapping(value = { UPDATE_ENTITIES }, method = RequestMethod.POST)
    public ModelAndView updateEntities() {
        ModelAndView mv = new ModelAndView(VW_VIEW_ENTITIES);
        return mv;
    }

    @RequestMapping(value = { VIEW_ENTITY }, method = RequestMethod.GET)
    public ModelAndView viewEntity(@PathVariable(ENTITY_ID) Long id) {
        ModelAndView mv = new ModelAndView(VW_VIEW_ENTITY);
        Optional<Course> entity = courseService.findById(id);
        if(entity.isPresent())
            mv.addObject(S_ENTITY, entity);
        else mv.addObject(MSG_ERROR, ENTITY_NOT_FOUND);

        return mv;
    }

    @RequestMapping(value = { VIEW_ENTITIES }, method = RequestMethod.GET)
    public ModelAndView viewEntities() {
        ModelAndView mv = new ModelAndView(VW_VIEW_ENTITIES);
        List<Course> entities = courseService.findAll();
        mv.addObject(S_ENTITIES, entities);
        return mv;
    }

    @RequestMapping(value = { DELETE_ENTITY }, method = RequestMethod.GET)
    public ModelAndView deleteEntity(@PathVariable(ENTITY_ID) Long id) {
        ModelAndView mv = new ModelAndView(VW_VIEW_ENTITY);

        Optional<Course> entity = courseService.findById(id);
        if(entity.isPresent()) {
            courseService.deleteById(id);
            mv.addObject(MSG_SUCCESS, ENTITY_SUCCESSFULLY_DELETED);
        }
        else {
            mv.addObject(MSG_ERROR, ENTITY_NOT_FOUND);
        }
        return mv;
    }

    @RequestMapping(value = { DELETE_ENTITIES }, method = RequestMethod.GET)
    public ModelAndView deleteEntities() {
        ModelAndView mv = new ModelAndView(VW_VIEW_ENTITY);
        return mv;
    }
}
