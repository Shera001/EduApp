package uz.crud.edu.presentation.course_listing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import uz.crud.edu.R
import uz.crud.edu.ui.theme.DarkBlue

@Composable
fun CourseListingScreen(
    eduCenterId: String,
    viewModel: CourseListingViewModel = hiltViewModel()
) {
    viewModel.getEduCenter(eduCenterId)
    viewModel.getCourses(eduCenterId)
    val state = viewModel.state
    val eduCenter = viewModel.eduCenter
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(16.dp)
    ) {

        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(eduCenter.image)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .build()
        )
        Image(
            painter = painter,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "Original edu center picture"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = eduCenter.name.toString(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = eduCenter.number.toString(),
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = eduCenter.address.toString(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = eduCenter.link.toString(),
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = eduCenter.info.toString(),
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.courses.size) { index: Int ->
                val course = state.courses[index]
                CourseItem(
                    course = course, modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp)
                )
                if (index < state.courses.size) {
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