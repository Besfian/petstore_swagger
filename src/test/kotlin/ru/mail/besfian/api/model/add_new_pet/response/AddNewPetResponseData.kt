package ru.mail.besfian.api.model.add_new_pet.response

import io.kotest.matchers.nulls.shouldNotBeNull
import java.util.Objects

data class AddNewPetResponseData(
    var category: Category? = null,
    var id: Long? = null,
    var name: String? = null,
    var photoUrls: List<String>? = null,
    var status: String? = null,
    var tags: List<Tag>? = null
)

data class Category(
    var id: Int? = null,
    var name: String? = null
)

data class Tag(
    var id: Int? = null,
    var name: String? = null
)