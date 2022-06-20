package uz.crud.edu.presentation.course_listing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.crud.edu.domain.model.EduCenter
import uz.crud.edu.domain.repository.CourseRepository
import javax.inject.Inject

@HiltViewModel
class CourseListingViewModel @Inject constructor(
    private val repository: CourseRepository
) : ViewModel() {

    var state by mutableStateOf(CourseListingState())
    var eduCenter by mutableStateOf(EduCenter())

    fun getEduCenter(id: String) {
        viewModelScope.launch {
            repository.getEduCenter(id).collect {
                eduCenter = it
            }
        }
    }

    fun getCourses(id: String) {
        viewModelScope.launch {
            repository.getCourses(id).collect {
                state = state.copy(courses = it)
            }
        }
    }
}