package uz.crud.edu.domain.model

class Course {

    var id: Int? = null
    var date: String? = null
    var name: String? = null
    var price: String? = null
    var type: String? = null

    constructor()
    constructor(
        id: Int,
        date: String?,
        name: String?,
        price: String?,
        type: String?
    ) {
        this.id = id
        this.date = date
        this.name = name
        this.price = price
        this.type = type
    }
}
