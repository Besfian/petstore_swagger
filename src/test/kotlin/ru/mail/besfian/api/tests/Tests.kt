package ru.mail.besfian.api.tests

import com.github.javafaker.Faker
import io.kotest.matchers.shouldBe
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import ru.mail.besfian.api.base.Settings
import ru.mail.besfian.api.model.add_new_pet.request.AddNewPetRequestData
import ru.mail.besfian.api.model.add_new_pet.request.Category
import ru.mail.besfian.api.model.add_new_pet.request.Tag
import ru.mail.besfian.api.services.AddNewPetServices

class Tests : Settings() {

    var addNewPetServices = AddNewPetServices()

    val addNewPetRequestData = AddNewPetRequestData().apply {
        id = 0
        category = Category().apply {
            id = 0
            name = Faker().name().toString()
        }
        name = "doggie"
        photoUrls = arrayListOf("string")
        tags = arrayListOf(Tag().apply {
            id = 0
            name = Faker().name().toString()
        })
        status = "available"
    }

    @Test
    fun addNewPetTest() {
        addNewPetServices.addNewPet(addNewPetRequestData)
    }

    @Test
    fun findPetById() {
        val response = addNewPetServices.addNewPet(addNewPetRequestData)
        addNewPetServices.findPetById(response!!.id.toString()).apply {
            this!!.id.shouldBe(response.id)
            this.name.shouldBe(response.name)
        }
    }
}