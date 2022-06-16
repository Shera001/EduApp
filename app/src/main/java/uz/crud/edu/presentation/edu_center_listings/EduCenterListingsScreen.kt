package uz.crud.edu.presentation.edu_center_listings

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
//@Destination(start = true)
fun EduCenterListingsScreen(
//    navigator: DestinationsNavigator,
    viewModel: EduCenterListingViewModel = hiltViewModel()
) {
    Log.e("TAG", "EduCenterListingsScreen: ")
    val state = viewModel.state
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.eduCenters.size) { index: Int ->
            val eduCenter = state.eduCenters[index]
            EduCenterItem(
                eduCenter = eduCenter,
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        //TODO Navigate to courses screen
                    }
            )
            if (index < state.eduCenters.size) {
                Divider(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    )
                )
            }
        }
    }
}