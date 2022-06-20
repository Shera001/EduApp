package uz.crud.edu.data.firebase

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.crud.edu.data.firebase.dto.EduCenterDto
import uz.crud.edu.data.mapper.toEduCenter
import uz.crud.edu.domain.model.Course
import uz.crud.edu.domain.model.EduCenter
import javax.inject.Inject

class CoursesDataSource @Inject constructor() {

    suspend fun getCoursesByEduCenterId(id: String): Flow<List<Course>> = callbackFlow {
        val databaseReference = FirebaseDatabase.getInstance().getReference("course")
        val list = ArrayList<Course>()
        databaseReference.child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                snapshot.children.forEach { child: DataSnapshot ->
                    child.getValue(Course::class.java)?.let { list.add(it) }
                }
                this@callbackFlow.trySend(list).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        })

        awaitClose { databaseReference }
    }

    suspend fun getEduCenterById(id: String): Flow<EduCenter> = callbackFlow {
        Log.e("TAG", "getEduCenters: ")
        val databaseReference = FirebaseDatabase.getInstance().getReference("educenter")
        databaseReference.child(id).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val eduCenterDto: EduCenterDto? = snapshot.getValue(EduCenterDto::class.java)
                eduCenterDto?.toEduCenter()?.let { this@callbackFlow.trySend(it).isSuccess }
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        })

        awaitClose { databaseReference }
    }
}