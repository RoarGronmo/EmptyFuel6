package no.rogo.emptyfuel6.ui.screen.station

import android.content.Context
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.frames.open
import androidx.compose.unaryPlus
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import no.rogo.emptyfuel6.R
import no.rogo.emptyfuel6.ui.main.VectorImageButton

/**
 * Created by Roar on 09.12.2019.
 * Copyright RoGo Software / Gronmo IT
 */


@Composable
fun StationsScreen(
        openDrawer: () -> Unit
){

    Column {
        TopAppBar(
                title = {
                    Text(
                            text = "Stations"
                    )
                },
                navigationIcon = {
                    VectorImageButton(
                            id = R.drawable.ic_baseline_menu_24,
                            onClick = openDrawer)
                }
        )
        VerticalScroller(
                modifier = Flexible(1f)
        ) {
            Column(
                    modifier = Expanded
            ) {
                for (i in 0 until 10)
                {
                    StationCard()
                }
            }
        }
    }
}


@Composable
fun StationCard()
{

    val image = +imageResource(R.drawable.yx_icon)

    Card(
            modifier = Spacing(
                    all = 4.dp
            ) ,
            color = Color.Green,
            shape = RoundedCornerShape(
                    size = 5.dp
            )
    ) {
        Column {
            Row(){
                Surface(shape = RoundedCornerShape(size = 4.dp),
                        modifier = Spacing(all = 4.dp) ,
                        color = Color.White.copy(alpha = 0.60f)
                ) {
                     DrawImageFitCenter(
                             image = image,
                             modifier = Spacing(all = 4.dp),
                             containerWidth = 40.dp,
                             containerHeight = 40.dp
                     )
                }

                Column(modifier = Flexible(1f) wraps Expanded) {
                    Surface(color = Color.Transparent) {
                        Text(
                                text = "Station Name",
                                style = ((+MaterialTheme.typography()).h6),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                        )
                    }
                    Surface(color = Color.Yellow){
                        Text(
                                text = "Station Address, 0000 Location",
                                style = ((+MaterialTheme.typography()).subtitle2).withOpacity(0.6f),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Column(modifier = Spacing(right = 4.dp) )
                {
                    Surface(color = Color.Transparent, modifier = Gravity.End) {
                        Text(
                                text = "123,3 km",
                                style = ((+MaterialTheme.typography()).caption)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold
                                        )
                        )
                    }
                    /*
                    Surface(color = Color.Red, modifier = Gravity.End) {

                        Text(text = "14d 16h 00min")
                    }*/

                    Surface(color = Color.Transparent) {
                        Button(
                                onClick = {},
                                text = "DETAILS",
                                style = TextButtonStyle()
                        )
                    }

                }

            }
            Divider(modifier = Spacing(left = 4.dp, right = 4.dp))
            Row(){
                Column(modifier = Flexible(1f) wraps Expanded) {
                    Surface(
                            color = Color.White,
                            modifier = Spacing(
                                    left = 4.dp
                            ) wraps Gravity.Start ) {
                        Text(text = "Country average",
                                style = ((+MaterialTheme.typography()).subtitle2)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold
                                        ))
                    }
                }
            }
        }
    }
}

@Composable
fun DrawImageFitCenter(
        modifier: Modifier = Modifier.None,
        image: Image,
        tint: Color? = null,
        containerWidth: Dp,
        containerHeight: Dp
){
    val imageAspect = image.width.dp / image.height.dp
    val containerAspect = containerWidth / containerHeight

    var justWidth: Dp
    var justHeight: Dp

    Container(
            modifier = modifier,
            width = containerWidth,
            height = containerHeight
    ) {
        if(containerAspect>imageAspect)
        {
            justWidth = containerWidth*(imageAspect/containerAspect)
            justHeight = containerHeight
        } else {
            justWidth = containerWidth
            justHeight = containerHeight*(containerAspect/imageAspect)
        }

        Container(width = justWidth, height = justHeight) {
            DrawImage(image = image,
                    tint = tint)

        }
    }
}

@Preview
@Composable
fun PreviewStationsCard()
{
    TemplatePreviewStationsCard()
}

@Composable
fun TemplatePreviewStationsCard(

){
    MaterialTheme() {
        StationCard()
    }
}