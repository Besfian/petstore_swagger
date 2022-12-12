package ru.mail.besfian.api.services

import com.google.gson.Gson
import io.qameta.allure.Step
import io.restassured.RestAssured
import lombok.Data
import ru.mail.besfian.api.constans.Headers.contentType
import ru.mail.besfian.api.constans.Paths.pet
import ru.mail.besfian.api.model.add_new_pet.request.AddNewPetRequestData
import ru.mail.besfian.api.model.add_new_pet.response.AddNewPetResponseData


class AddNewPetServices {

    val gson = Gson()

    @Step("Создание нового питомца")
    fun addNewPet(body: AddNewPetRequestData): AddNewPetResponseData? {
        val response: String? =
            RestAssured.given().log().all().body(body)
                .contentType(contentType)
                .`when`()
                .post(pet)
                .then().log().all().statusCode(200).extract().response().body.asString()
        return gson.fromJson(response, AddNewPetResponseData::class.java)
    }

    @Step("Поиск питомца по id")
    fun findPetById(id: String): AddNewPetResponseData? {
        val response: String? =
            RestAssured.given().log().all()
                .`when`()
                .get(pet + id)
                .then().log().all().statusCode(200).extract().response().body.asString()
        return gson.fromJson(response, AddNewPetResponseData::class.java)
    }
}