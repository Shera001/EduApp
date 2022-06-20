package uz.crud.edu.presentation.edu_center_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import uz.crud.edu.R
import uz.crud.edu.domain.model.EduCenter

@Composable
fun EduCenterItem(
    eduCenter: EduCenter,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(eduCenter.image)
                .placeholder(R.drawable.ic_baseline_downloading)
                .error(R.drawable.ic_baseline_downloading)
                .build()
        )
        Image(
            painter = painter,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            contentDescription = "Edu center picture"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
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
//            Text(
//                text = eduCenter.link.toString(),
//                fontWeight = FontWeight.Light,
//                fontSize = 16.sp,
//                color = MaterialTheme.colors.onBackground
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = eduCenter.info.toString(),
//                fontWeight = FontWeight.Light,
//                fontSize = 16.sp,
//                color = MaterialTheme.colors.onBackground
//            )
        }
    }
}