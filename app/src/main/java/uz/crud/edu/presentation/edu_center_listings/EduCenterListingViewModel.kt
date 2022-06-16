package uz.crud.edu.presentation.edu_center_listings

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.crud.edu.domain.model.EduCenterListing
import uz.crud.edu.domain.repository.EduCenterRepository
import javax.inject.Inject

@HiltViewModel
class EduCenterListingViewModel @Inject constructor(
    private val repository: EduCenterRepository
) : ViewModel() {

    var state by mutableStateOf(EduCenterListingState())

    init {
        Log.e("TAG", "init: ")
        getEduCenterListings()
    }

    private fun getEduCenterListings() {
        viewModelScope.launch {
            repository
                .getEduCenterListing()
                .collect { listings: List<EduCenterListing> ->
                    state = state.copy(eduCenters = listings)
                }
        }
    }
}