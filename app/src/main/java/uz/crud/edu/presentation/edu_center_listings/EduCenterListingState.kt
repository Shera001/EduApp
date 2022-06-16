package uz.crud.edu.presentation.edu_center_listings

import uz.crud.edu.domain.model.EduCenterListing

data class EduCenterListingState(
    val eduCenters: List<EduCenterListing> = emptyList(),
    val isLoading: Boolean = false
)