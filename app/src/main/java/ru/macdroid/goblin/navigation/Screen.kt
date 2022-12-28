package ru.macdroid.goblin.navigation

import ru.macdroid.goblin.common.Constants

sealed class Screen(val route: String) {
    object Login : Screen(Constants.ROUTE_LOGIN_SCREEN)
    object Dashboard : Screen(Constants.ROUTE_DASHBOARD_SCREEN)
}