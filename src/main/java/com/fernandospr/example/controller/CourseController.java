package com.fernandospr.example.controller;

import com.fernandospr.example.model.Course;
import com.fernandospr.example.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "api/courses")
public class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getCourses() {
        LOGGER.info("/courses [GET]");
        return this.courseService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public Course createCourse(@RequestBody @Valid Course course) {
        LOGGER.info("/courses [POST]: {}", course);
        return this.courseService.save(course);
    }

}
