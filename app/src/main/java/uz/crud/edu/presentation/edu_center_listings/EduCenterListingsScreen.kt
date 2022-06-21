package uz.crud.edu.presentation.edu_center_listings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun EduCenterListingsScreen(
    navController: NavHostController,
    viewModel: EduCenterListingViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = viewModel.state.searchQuery,
            onValueChange = {
                viewModel.searchEduCenter(EduCenterListingsEvent.OnSearchQueryChange(query = it))
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Search...")
            },
            maxLines = 1,
            singleLine = true
        )

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
//                        navController.navigate(Screen.Second(data = eduCenter))
//                        navController.navigate("courses", bundleOf("EDU_CENTER" to eduCenter))
                            navController.navigate("courses/${eduCenter.id}")
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
}