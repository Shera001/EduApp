package uz.crud.edu.data.firebase

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.crud.edu.domain.model.EduCenterListing
import javax.inject.Inject

class EduCenterDataSource @Inject constructor() {

    suspend fun getEduCenters(): Flow<List<EduCenterListing>> = callbackFlow {
        Log.e("TAG", "getEduCenters: ")
        val databaseReference = FirebaseDatabase.getInstance().getReference("educenter")
        val list = ArrayList<EduCenterListing>()
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                snapshot.children.forEach { child: DataSnapshot ->
                    child.getValue(EduCenterListing::class.java)?.let { list.add(it) }
                }
                this@callbackFlow.trySend(list).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        })

        awaitClose { databaseReference }
    }
}