package uz.crud.edu.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.crud.edu.domain.model.Course
import uz.crud.edu.domain.model.EduCenter

interface CourseRepository {

    suspend fun getCourses(id: String): Flow<List<Course>>

    suspend fun getEduCenter(id: String): Flow<EduCenter>
}