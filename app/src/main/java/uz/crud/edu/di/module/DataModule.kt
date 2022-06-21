package uz.crud.edu.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.crud.edu.data.repository.CourseRepositoryImpl
import uz.crud.edu.data.repository.EduCenterRepositoryImpl
import uz.crud.edu.domain.repository.CourseRepository
import uz.crud.edu.domain.repository.EduCenterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindEduCenterRepository(
        eduCenterRepositoryImpl: EduCenterRepositoryImpl
    ): EduCenterRepository

    @Binds
    @Singleton
    fun bindCourseRepository(courseRepositoryImpl: CourseRepositoryImpl): CourseRepository
}