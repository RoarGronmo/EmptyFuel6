package no.rogo.emptyfuel6.ui.main

import androidx.compose.Model

/**
 * Created by Roar on 09.12.2019.
 * Copyright RoGo Software / Gronmo IT
 */

sealed class Screen{
    object Stations: Screen()
}

@Model
object EmptyFuel6Status{
    var currentScreen: Screen = Screen.Stations
}

fun navigateTo(destination: Screen){
    EmptyFuel6Status.currentScreen = destination
}