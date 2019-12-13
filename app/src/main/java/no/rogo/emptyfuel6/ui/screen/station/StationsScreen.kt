package no.rogo.emptyfuel6.ui.screen.station

import android.content.Context
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.frames.open
import androidx.compose.unaryPlus
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.engine.geometry.Offset
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.graphics.Shadow
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import no.rogo.emptyfuel6.R
import no.rogo.emptyfuel6.ui.main.VectorImage
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
                //CardGravityTest()
                for (i in 0 until 10)
                {
                    StationCard()
                }
            }
        }
    }
}

@Composable
fun CardGravityTest()
{
    Card(
            modifier = Spacing(all = 4.dp),
            color = Color.LightGray,
            shape = RoundedCornerShape(
                    5.dp
            )
    ){
        Column {
            Row {
                Surface(color = Color.Red,
                        modifier = Spacing(all = 4.dp)) {
                    Text(text = "1 XX")
                }
                Column(modifier = Flexible(1f) wraps Expanded wraps Spacing(4.dp)){
                    Surface(color = Color.Green){
                        Text(text="2 Flexible wraps Expanded(1f) wraps Spacing(4.dp) x x xx xxx xxxx x xx xxx x xxx")
                    }
                    Surface(color = Color.Magenta){
                        Text(text = "3 Second line xxxxx xxx xx xxxxx xxxx")
                    }
                }
                Column(modifier = ExpandedHeight) {
                    Surface(color = Color.DarkGray) {
                        Text(text = "4 Column: OK High on top!")
                    }

                    Row(modifier =Expanded wraps Gravity.End) {

                        Column(modifier = Gravity.Center wraps Expanded) {
                            Surface(color = Color.Yellow,
                                    modifier = Gravity.End){
                                Text(text = "5 Center End me!",
                                        modifier = Gravity.End)
                            }
                        }
                    }


                }
            }

            Divider()

            Row (modifier = Spacing(top = 4.dp)){
                Column (modifier = Flexible(1f) wraps Expanded){
                    Surface(color = Color.Blue, modifier = Gravity.Start) {
                        Text(text = "6 Row spacing top, Column Flexible(1f) wraps Expanded, Surface gravity start")
                    }
                }
                Column(modifier = Flexible(1f) wraps Expanded){
                    Surface(color = Color.Cyan, modifier = Gravity.End) {
                        Text(text = "7 Column Flexible wraps Expanded, Surface gravity end, " +
                                "paragraphstyle TextAlign.end ", paragraphStyle = ParagraphStyle(textAlign = TextAlign.End))
                    }
                }
            }

            Row {
                Surface(modifier = Spacing(all = 4.dp), color = Color.White) {
                    Text(text = "8 on Row")
                }
                Surface(modifier = Spacing(all = 4.dp), color = Color.Green)
                {
                    Text(text = "9 on Row")
                }
                Column(modifier = Gravity.Center wraps Flexible(1f)){
                    Surface(color = Color.Red) {
                        Text(text = "10 col center flex, line 1")
                    }
                    Surface(color = Color.DarkGray)
                    {
                        Text(text = "11 line 2 xxxxxx")
                    }
                }
                Column(modifier = Gravity.Center wraps Expanded) {
                    Surface(color = Color.Magenta, modifier = Gravity.End) {
                        Text(text = "12 col cnt mod end")
                    }
                }
            }


        }
    }
}

@Composable
fun StationCard()
{

    val image = +imageResource(R.drawable.yx_icon)
    val imagekind = +imageResource(R.drawable.ic_empty_kind_24dp_black)

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
            //Station info Row
            Row{
                //Enterprise icon
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
                //Station info
                Column(modifier = Flexible(1f) wraps Expanded) {
                    //Station name
                    Surface(color = Color.Transparent) {
                        Text(
                                text = "Station Name name namne namen mname naneme",
                                style = ((+MaterialTheme.typography()).h6).withOpacity(0.85f),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                        )
                    }
                    //Station address
                    Surface(color = Color.Transparent){
                        Text(
                                text = "Station Address, 0000 lon glon glong lomn glom gLocation",
                                style = ((+MaterialTheme.typography()).subtitle2).withOpacity(0.6f),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                //Distance and Details button column
                Column(modifier = Spacing(right = 4.dp) )
                {
                    //Station distance
                    Surface(color = Color.Transparent, modifier = Gravity.End wraps Expanded) {
                        Text(
                                text = "123000000000,3 km",
                                style = ((+MaterialTheme.typography()).caption)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                        ).withOpacity(0.6f)
                        )
                    }

                    //Details button
                    Row(modifier = Gravity.End wraps ExpandedHeight
                    ){
                        Column(modifier = Gravity.Center wraps ExpandedHeight) {
                            Surface(color = Color.Transparent,
                                    modifier = Gravity.End) {
                                Button(
                                        onClick = {},
                                        text = "DETAILS",
                                        style = TextButtonStyle()
                                )
                            }
                        }
                    }


                }

            }
            //Horizontal divider
            Divider(
                    modifier = Spacing(
                            left = 4.dp,
                            right = 4.dp),
                    color = Color.Black
            )

            Row{
                //Update since
                Column(modifier = Flexible(1f) wraps Expanded) {
                    Surface(
                            color = Color.Transparent,
                            modifier = Spacing(
                                    left = 4.dp
                            ) wraps Gravity.Start ) {
                        Text(
                                text = "9h 4m",
                                modifier = Gravity.Start,
                                paragraphStyle = ParagraphStyle(textAlign = TextAlign.Start),
                                style = ((+MaterialTheme.typography()).caption)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                        ).withOpacity(0.6f)
                        )
                    }
                }
                //Update timestamp
                Column(modifier = Flexible(1f) wraps Expanded){
                    Surface(
                            color = Color.Transparent,
                            modifier = Spacing(
                                    right = 4.dp
                            ) wraps Gravity.End) {
                        Text(
                                text = "2019-12-12 12:13:39",
                                modifier = Gravity.End,
                                paragraphStyle = ParagraphStyle(textAlign = TextAlign.End),
                                style = ((+MaterialTheme.typography()).caption)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                        ).withOpacity(0.6f)
                        )
                    }
                }
            }
            Row {
                //Kind icon
                Surface(shape = RoundedCornerShape(size = 4.dp),
                        modifier = Spacing(all = 4.dp) ,
                        color = Color.White.copy(alpha = 0.60f)
                ) {
                    DrawImageFitCenter(
                            image = imagekind,
                            modifier = Spacing(all = 4.dp),
                            containerWidth = 40.dp,
                            containerHeight = 40.dp
                    )
                }

                //Price text
                Surface(
                        color = Color.Transparent,
                        modifier = Spacing(all = 4.dp)
                ) {
                    Text(
                            text = "15,98",
                            style = ((+MaterialTheme.typography()).h4)
                                    .copy(fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Yellow,
                                            shadow = Shadow(
                                                    color = Color.Gray,
                                                    offset = Offset(
                                                            dx = 5f,
                                                            dy = 5f
                                                    ),
                                                    blurRadius = 2.px
                                            )
                                    ),
                            maxLines = 1
                    )
                }

                //Currency and quantity measurements
                Column(
                        modifier = Gravity.Center wraps Flexible(1f)
                ){
                    //Currency
                    Surface(color = Color.Transparent) {
                        Text(
                                text = "NOK",
                                style = ((+MaterialTheme.typography()).caption)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold
                                )
                        )
                    }

                    //Quantity measurements
                    Surface(color = Color.Transparent) {
                        Text(
                                text = "ltr",
                                style = ((+MaterialTheme.typography()).caption)
                                        .copy(
                                                fontFamily = FontFamily.Monospace,
                                                fontWeight = FontWeight.Bold
                                        )
                        )
                    }
                }

                //Update Button
                Column(modifier = Gravity.Center wraps Expanded) {
                    Surface(color = Color.Transparent,
                            modifier = Spacing(right = 4.dp) wraps Gravity.End) {
                        Button(
                                onClick = {},
                                style = ContainedButtonStyle()
                        ){
                            Row() {
                                VectorImage(id = R.drawable.ic_baseline_edit_24)
                                WidthSpacer(width = 16.dp)
                                Text(modifier = Gravity.Center,
                                        text = "UPDATE",
                                        style = ((+MaterialTheme.typography()).button))
                            }
                        }
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
    MaterialTheme {
        CardGravityTest()
    }
}