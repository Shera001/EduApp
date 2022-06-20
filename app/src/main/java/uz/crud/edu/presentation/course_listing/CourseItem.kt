package uz.crud.edu.presentation.course_listing

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.crud.edu.domain.model.Course

@Composable
fun CourseItem(
    course: Course,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1F)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = course.name.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.weight(1F)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = course.date.toString(),
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Text(
                text = course.price.toString(),
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}