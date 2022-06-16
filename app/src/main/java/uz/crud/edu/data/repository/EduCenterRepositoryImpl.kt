package uz.crud.edu.data.repository

import kotlinx.coroutines.flow.Flow
import uz.crud.edu.data.firebase.EduCenterDataSource
import uz.crud.edu.domain.model.EduCenterListing
import uz.crud.edu.domain.repository.EduCenterRepository
import javax.inject.Inject

class EduCenterRepositoryImpl @Inject constructor(
    private val dataSource: EduCenterDataSource
) : EduCenterRepository {

    override suspend fun getEduCenterListing(): Flow<List<EduCenterListing>> =
        dataSource.getEduCenters()
}