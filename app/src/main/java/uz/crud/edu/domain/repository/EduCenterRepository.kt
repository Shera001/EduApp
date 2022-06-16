package uz.crud.edu.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.crud.edu.domain.model.EduCenterListing

interface EduCenterRepository {

    suspend fun getEduCenterListing(): Flow<List<EduCenterListing>>
}