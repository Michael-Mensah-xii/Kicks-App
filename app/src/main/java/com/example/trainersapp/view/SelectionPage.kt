package com.example.trainersapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainersapp.R
import com.example.trainersapp.model.ShoeData
import com.example.trainersapp.model.ShoeDataSource
import com.example.trainersapp.model.ShoeViewModel
import com.example.trainersapp.ui.theme.App_light_grey
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun ShoeViewPage(
    shoeViewModel: ShoeViewModel,
    onBackPress: () -> Unit,
    onItemClicked: (item: Int) -> Unit,
) {

    Box(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .heightIn(43.dp)
                    .fillMaxWidth()
                    .background(App_light_grey)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .size(35.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(App_purple_fade)
                        .padding(4.dp)
                        .clickable {
                            onBackPress()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier =
                        Modifier
                            .size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.backpressed),
                        contentDescription = null,
                        tint = App_purple
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .size(35.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(App_purple_fade)
                        .padding(4.dp)
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier =
                        Modifier
                            .size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.favourite),
                        contentDescription = null,
                        tint = App_purple
                    )
                }

            }
            Image(
                painter = painterResource(id = shoeViewModel.image),
                contentDescription = stringResource(id = shoeViewModel.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))


            //price and name
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = stringResource(id = shoeViewModel.name),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )

                    Row {
                        Text(
                            text = String.format("GHS %.2f", shoeViewModel.quantity.value),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                        )

                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            //Box with sizes
            Box(
                modifier = Modifier
                    .height(87.dp)
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .alpha(1f)
                    .padding(top = 0.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                // Retain the selectedItem state across compositions using the remember function
                val selectedItem = remember { mutableStateOf(-1) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.size_btn),
                        style = PoppinsTypography.h3,
                        fontSize = 15.sp,
                        modifier = Modifier
                    )

                    val dateList = listOf("37", "38", "39", "40", "41")
                    LazyRow(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        contentPadding = PaddingValues(bottom = 0.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        items(dateList.size) { item ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        // Set the background color based on the selected item
                                        color = if (item == selectedItem.value) App_purple else App_purple_fade
                                    )
                                    .size(53.dp, 49.dp)
                                    // Use a lambda to update the selected item when the Box is clicked
                                    .clickable { selectedItem.value = item }
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(
                                            start = 15.dp,
                                            end = 12.dp,
                                            top = 12.dp,
                                            bottom = 8.dp
                                        )
                                        .padding(horizontal = 2.dp),
                                    fontSize = 18.sp,
                                    text = dateList[item],
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            //Reviews
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.Reviews),
                        style = PoppinsTypography.h3,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(top = 0.dp)

                    )
                    Rating(
                        rating = shoeViewModel.rating,
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )

                }

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = stringResource(id = shoeViewModel.description),
                    modifier = Modifier,
                    style = PoppinsTypography.body1,
                    fontSize = 13.sp,
                    overflow = TextOverflow.Clip
                )

                Spacer(modifier = Modifier.heightIn(8.dp))
            }
            Spacer(modifier = Modifier.heightIn(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.similar),
                    style = PoppinsTypography.h3,
                    fontSize = 14.sp,

                    )

            }
            SimilarMatchRow(onItemClicked)

            Spacer(modifier = Modifier.heightIn(32.dp))


            Column(
                modifier = Modifier
                    .padding(top = 0.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(34.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    //  CartItemButton()
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .size(25.dp)
                                .background(App_purple_fade)
                                .padding(4.dp)
                                .clickable {
                                    shoeViewModel.decrementQuantity()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier =
                                Modifier
                                    .size(25.dp),
                                painter = painterResource(id = R.drawable.minimize),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }

                        Text(
                            text = "${shoeViewModel.cartItemQuantity.value}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                        )


                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(App_purple_fade)
                                .size(25.dp)
                                .padding(4.dp)
                                .clickable {
                                    shoeViewModel.incrementQuantity()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                imageVector = Icons.Default.Add,
                                contentDescription = stringResource(R.string.text_add_icon),
                                tint = Color.Black
                            )
                        }
                    }

                    Button(
                        modifier = Modifier
                            .heightIn(58.dp)
                            .widthIn(256.dp),
                        shape = RoundedCornerShape(32.dp),
                        colors = (ButtonDefaults.buttonColors(App_purple)),
                        onClick = { /*TODO*/ },
                    ) {
                        Text(
                            stringResource(R.string.add_to_cart),
                            style = PoppinsTypography.button,
                            color = Color.Black,
                            fontSize = 18.sp,
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.heightIn(32.dp))


        }
    }

}


@Composable
fun SimilarMatchRow(onItemClicked: (item: Int) -> Unit) {
    val destinations = ShoeDataSource().loadData()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
    ) {
        itemsIndexed(destinations) { item, destination ->
            SimilarMatchLayout(destination, onItemClicked = { onItemClicked(item) })
        }
    }

}


@Composable
fun SimilarMatchLayout(
    destination: ShoeData,
    onItemClicked: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .widthIn(112.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { (onItemClicked()) }
    ) {
        Box {
            Image(
                painter = painterResource(destination.id),
                contentDescription = stringResource(destination.name),
                modifier = Modifier
                    .widthIn(112.dp)
                    .heightIn(78.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(App_purple_fade)
                    .align(Alignment.TopEnd)
                    .padding(2.dp)
            ) {
                Text(
                    text = String.format("GHS %.2f", destination.price),
                    color = Color.Black,
                    style = PoppinsTypography.body1,
                    fontSize = 7.sp,
                )
            }
        }


        Spacer(modifier = Modifier.heightIn(10.dp))

        Row(
            modifier = Modifier
                .widthIn(112.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(destination.name),
                color = Color.Black,
                fontSize = 9.sp,
                style = PoppinsTypography.body1,
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.widthIn(16.dp))
            Rating(rating = destination.rating)
        }

    }

}


@Composable
fun ShoeViewPagePreview() {
    val shoeViewModel = ShoeViewModel("0")
    ShoeViewPage(shoeViewModel, onBackPress = {}, onItemClicked = {})
}


@Preview(showBackground = true)
@Composable
fun PreviewShoeViewPage() {
    ShoeViewPagePreview()
}


@Preview(showBackground = true)
@Composable
fun SimilarMatchPreview() {
    val destination = ShoeData(
        id = R.drawable.yellow_adidas,
        name = R.string.yellow_adidas_string,
        description = R.string.Reviews,
        rating = 4,
        price = 300.20
    )
    SimilarMatchLayout(destination, onItemClicked = {})
}


