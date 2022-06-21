package uz.crud.edu.data.repository

import kotlinx.coroutines.flow.Flow
import uz.crud.edu.data.firebase.EduCenterDataSource
import uz.crud.edu.domain.model.EduCenter
import uz.crud.edu.domain.repository.EduCenterRepository
import javax.inject.Inject

class EduCenterRepositoryImpl @Inject constructor(
    private val dataSource: EduCenterDataSource
) : EduCenterRepository {

    override suspend fun getEduCenterListing(): Flow<List<EduCenter>> =
        dataSource.getEduCenters()

    override suspend fun searchEduCenter(query: String): Flow<List<EduCenter>> =
        dataSource.searchEduCenter(query)
}