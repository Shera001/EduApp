package uz.crud.edu.domain.model

class EduCenterListing {

    var id: Int?
    var name: String
    var number: String
    var address: String
    var image: String
    var info: String
    var link: String

    constructor(
        id: Int?,
        name: String,
        number: String,
        address: String,
        image: String,
        info: String,
        link: String
    ) {
        this.id = id
        this.name = name
        this.number = number
        this.address = address
        this.image = image
        this.info = info
        this.link = link
    }
}
