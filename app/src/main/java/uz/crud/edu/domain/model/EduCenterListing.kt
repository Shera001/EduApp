package uz.crud.edu.domain.model

class EduCenterListing {

    var id: Int? = null
    var name: String? = null
    var number: String? = null
    var address: String? = null
    var image: String? = null
    var info: String? = null
    var link: String? = null

    constructor(
        id: Int?,
        name: String?,
        number: String?,
        address: String?,
        image: String?,
        info: String?,
        link: String?
    ) {
        this.id = id
        this.name = name
        this.number = number
        this.address = address
        this.image = image
        this.info = info
        this.link = link
    }

    constructor()
}
