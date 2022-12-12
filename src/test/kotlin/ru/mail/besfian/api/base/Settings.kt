package ru.mail.besfian.api.base

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import ru.mail.besfian.api.constans.Paths.baseUrl

open class Settings() {

    @BeforeEach
    fun setup() {
        RestAssured.baseURI = baseUrl
    }
}