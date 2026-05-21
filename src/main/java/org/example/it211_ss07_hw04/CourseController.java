package org.example.it211_ss07_hw04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public String getCourse(@PathVariable Long id) {

        return courseService.getCourseById(id);

    }
}
