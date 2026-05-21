package org.example.it211_ss07_hw04;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    public String getCourseById(Long id) {

        throw new ResourceNotFoundException(
                "Không tìm thấy khóa học với id = " + id
        );

    }
}
