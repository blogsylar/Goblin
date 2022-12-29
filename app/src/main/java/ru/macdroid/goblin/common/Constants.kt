package ru.macdroid.goblin.common

object Constants {
    const val PROD_API_URL: String = "https://api.saures.ru"
    const val TEST_API_URL: String = "https://testapi.saures.ru"

    const val BASE_URL: String = TEST_API_URL

    private const val API_PREFIX = "1.0"
    const val END_POINT_LOGIN: String = "/login"
    const val END_POINT_USER_PROFILE: String = "$API_PREFIX/user/profile"


    const val USER_LOGIN = "USER_LOGIN"
    const val USER_PASSWORD = "USER_PASSWORD"
    const val SID = "SID"
    const val TELEGRAM = "TELEGRAM"
    const val ROLE = "ROLE"
    const val API = "API"

    const val ROUTE_LOGIN_SCREEN = "login_screen"
    const val ROUTE_DASHBOARD_SCREEN = "dashboard_screen"
}