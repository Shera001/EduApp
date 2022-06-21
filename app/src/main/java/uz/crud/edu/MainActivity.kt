package uz.crud.edu

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.crud.edu.presentation.course_listing.CourseListingScreen
import uz.crud.edu.presentation.edu_center_listings.EduCenterListingsScreen
import uz.crud.edu.ui.theme.EduTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EduTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController: NavHostController = rememberNavController()
                    NavHost(navController = navController, startDestination = "edu") {
                        composable(route = "edu") {
                            Log.e("TAG", "onCreate: edu")
                            EduCenterListingsScreen(navController)
                        }
                        composable(route = "courses/{userId}") {
                            it.arguments?.getString("userId")
                                ?.let { it1 -> CourseListingScreen(it1) }
                        }
                    }
                }
            }
        }
    }
}