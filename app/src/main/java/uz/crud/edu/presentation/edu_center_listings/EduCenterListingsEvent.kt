package uz.crud.edu.presentation.edu_center_listings

sealed class EduCenterListingsEvent {
    data class OnSearchQueryChange(val query: String): EduCenterListingsEvent()
}