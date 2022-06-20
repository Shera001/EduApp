package uz.crud.edu.data.mapper

import uz.crud.edu.data.firebase.dto.EduCenterDto
import uz.crud.edu.domain.model.EduCenter

fun EduCenterDto.toEduCenter(): EduCenter =
    EduCenter(id, name, number, address, image, info, link)