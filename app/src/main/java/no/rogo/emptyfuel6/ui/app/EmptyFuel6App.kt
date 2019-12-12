package no.rogo.emptyfuel6.ui.app

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Expanded
import androidx.ui.layout.Spacing
import androidx.ui.material.DrawerState
import androidx.ui.material.DrawerState.Closed
import androidx.ui.material.DrawerState.Opened
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ModalDrawerLayout
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import no.rogo.emptyfuel6.ui.main.EmptyFuel6Status
import no.rogo.emptyfuel6.ui.main.Screen
import no.rogo.emptyfuel6.ui.screen.station.StationsScreen

/**
 * Created by Roar on 09.12.2019.
 * Copyright RoGo Software / Gronmo IT
 */

@Composable
fun EmptyFuel6App()
{
    val (drawerState, onDrawerStateChange) = +state{ Closed }

    ModalDrawerLayout(
            drawerState = drawerState,
            onStateChange = onDrawerStateChange,
            gesturesEnabled = drawerState == Opened,
            drawerContent = {
                AppDrawer(
                        closeDrawer = {
                            onDrawerStateChange(Closed)
                        }
                )
            },
            bodyContent = {
                AppContent(
                        openDrawer = {
                            onDrawerStateChange(Opened)
                        }
                )
            }
    )
}


@Composable
private fun AppContent(
        openDrawer: () -> Unit
){
    Crossfade(current = EmptyFuel6Status.currentScreen) { screen: Screen ->
        Surface {
            when(screen){
                is Screen.Stations -> StationsScreen( openDrawer = openDrawer)
            }
        }

    }
}

@Composable
private fun AppDrawer(
        //currentScreen: Screen,
        closeDrawer: () -> Unit
){
    Column(
            modifier = Expanded
    ) {
        Surface {
            Column(modifier = Expanded) {
                Text(text = "Empty Fuel 6", modifier = Spacing(all = 8.dp))
                Text(text = "https://www.fuelpump.no", modifier = Spacing(all = 8.dp))
            }
        }
    }
}
