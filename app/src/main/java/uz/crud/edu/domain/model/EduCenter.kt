package uz.crud.edu.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class EduCenter(
    val id: Int? = null,
    val name: String? = null,
    val number: String? = null,
    val address: String? = null,
    val image: String? = null,
    val info: String? = null,
    val link: String? = null
) : Parcelable
