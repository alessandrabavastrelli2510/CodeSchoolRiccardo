package org.generation.italy.codSchool.model;

import java.util.Comparator;

public class CourseComparatorById implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getId()-o2.getId();
    }

}
