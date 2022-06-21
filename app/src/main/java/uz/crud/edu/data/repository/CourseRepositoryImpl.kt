package uz.crud.edu.data.repository

import kotlinx.coroutines.flow.Flow
import uz.crud.edu.data.firebase.CoursesDataSource
import uz.crud.edu.domain.model.Course
import uz.crud.edu.domain.model.EduCenter
import uz.crud.edu.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val coursesDataSource: CoursesDataSource
) : CourseRepository {

    override suspend fun getCourses(id: String): Flow<List<Course>> =
        coursesDataSource.getCoursesByEduCenterId(id)

    override suspend fun getEduCenter(id: String): Flow<EduCenter> =
        coursesDataSource.getEduCenterById(id)
}