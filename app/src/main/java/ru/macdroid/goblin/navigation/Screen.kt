package ru.macdroid.goblin.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
}