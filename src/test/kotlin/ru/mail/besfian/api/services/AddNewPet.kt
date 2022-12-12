package ru.mail.besfian.api.services

import com.google.gson.Gson
import io.restassured.RestAssured
import io.restassured.response.Response
import org.hamcrest.MatcherAssert.assertThat
import ru.mail.besfian.api.constans.Headers.contentType
import ru.mail.besfian.api.constans.Paths.pet
import ru.mail.besfian.api.model.add_new_pet.request.AddNewPetRequestData
import ru.mail.besfian.api.model.add_new_pet.response.AddNewPetResponseData
import ru.mail.besfian.utils.Utils.fd
import ru.mail.besfian.utils.Utils.serialization


class AddNewPetServices {

    val gson = Gson()

    fun addNewPet(body: AddNewPetRequestData): AddNewPetResponseData? {
        val response: String? =
            RestAssured.given().log().all().body(body)
                .contentType(contentType)
                .`when`()
                .post(pet)
                .then().log().all().statusCode(200).extract().response().body.asString()
        return gson.fromJson(response, AddNewPetResponseData::class.java)
    }

    fun findPetById(id: String): AddNewPetResponseData? {
        val response: String? =
            RestAssured.given().log().all()
                .`when`()
                .get(pet + id)
                .then().log().all().statusCode(200).extract().response().body.asString()
        return gson.fromJson(response, AddNewPetResponseData::class.java)

    }
}