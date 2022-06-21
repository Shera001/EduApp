package uz.crud.edu.presentation.edu_center_listings

import uz.crud.edu.domain.model.EduCenter

data class EduCenterListingState(
    val eduCenters: List<EduCenter> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)