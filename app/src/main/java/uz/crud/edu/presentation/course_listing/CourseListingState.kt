package uz.crud.edu.presentation.course_listing

import uz.crud.edu.domain.model.Course

data class CourseListingState(
    val courses: List<Course> = emptyList(),
    val isLoading: Boolean = false
)
