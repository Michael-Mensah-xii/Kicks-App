package com.example.trainersapp.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.model.LogoData
import com.example.trainersapp.model.LogoDataSource
import com.example.trainersapp.model.ShoeData
import com.example.trainersapp.model.ShoeDataSource
import com.example.trainersapp.ui.theme.App_divider_colour
import com.example.trainersapp.ui.theme.PoppinsTypography
import com.example.trainersapp.ui.theme.RatingYellow


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Box(modifier = Modifier)
    {
        Column(modifier = Modifier
            .fillMaxHeight()
            //.verticalScroll(rememberScrollState())
        ) {


        }
        ShoeGrid(navController = rememberNavController())

    }


}


@ExperimentalFoundationApi
@Composable
fun ShoeGrid(navController: NavHostController) {
    val destinations = ShoeDataSource().loadData()


    Column() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.brands),
                style = PoppinsTypography.h3,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.heightIn(16.dp))


        //logo row
        LogoRow(navController)

        Spacer(modifier = Modifier.heightIn(0.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .padding(bottom = 48.dp)
                .padding(horizontal = 8.dp)
        ) {
            itemsIndexed(destinations) { index, destination ->
                Row(Modifier.padding(8.dp)) {
                    GridItemLayout(destination, index, navController)
                }
            }
        }
    }
}


@Composable
fun GridItemLayout(
    destination: ShoeData,
    index: Int,
    navController: NavHostController,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .widthIn(185.dp)
            .clickable {
                navController.navigate("details/$index")
            }
    ) {
        Image(
            painter = painterResource(destination.id),
            contentDescription = stringResource(destination.name),
            modifier = Modifier
                .widthIn(185.dp)
                .heightIn(140.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.heightIn(10.dp))

        Row(modifier = Modifier
            .widthIn(185.dp),
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

        Text(
            text = stringResource(destination.price),
            color = Color.Black,
            style = PoppinsTypography.body1,
            fontSize = 7.sp,
        )
    }
}


@Composable
fun LogoRow(navController: NavHostController) {
    val destinations = LogoDataSource().loadData()

    Column(
        modifier = Modifier
            .heightIn(50.dp)
    ) {

        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(horizontal = 0.dp),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(50.dp)
        ) {
            itemsIndexed(destinations) { index, destination ->
                Row(Modifier
                    .padding(8.dp)
                ) {
                    LogoItem(destination,
                        index,
                        navController) // pass individual destination object
                }
            }

        }

        Divider(thickness = 0.5.dp, color = App_divider_colour,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        )
    }
}


//logo row item
@Composable
fun LogoItem(
    destination: LogoData,
    index: Int,
    navController: NavHostController,
) {
    Box(
        modifier = Modifier
            //   .size(width = 60.dp, height = 50.dp)
            .clickable {}
            .clip(RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp)
            .heightIn(40.dp)
    ) {
        Box {

            Image(
                painter = painterResource(id = destination.logo),
                contentDescription = "brand logo",
                //   modifier = Modifier.size(width = 56.dp, height = 28.dp),
                contentScale = ContentScale.Crop,

                )
        }

    }
}


//create rating system
@Composable
fun Rating(
    rating: Int, modifier: Modifier = Modifier,
) {
    Row(modifier.padding(horizontal = 0.dp)
    ) {
        for (i in 1..5) {
            if (i <= rating) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    tint = RatingYellow,
                    contentDescription = null,
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star_empty),
                    contentDescription = null,
                )
            }
        }
    }
}


@Preview
@Composable
fun GridItemLayoutPreview() {
    val navController = rememberNavController()
    val destination = ShoeData(
        id = R.drawable.yellow_adidas,
        name = R.string.yellow_adidas_string,
        description = R.string.Reviews,
        rating = 4,
        price = R.string.price_yellow_adidas
    )
    SimilarMatchLayout(destination, 0, navController)
}


@Preview(showBackground = true)
@Composable
fun PreviewLogoItem() {
    val navController = rememberNavController()
    val destination = LogoData(
        logo = R.drawable.vans_logo,
    )
    LogoItem(destination, 0, navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewLogoRow() {
    val navController = rememberNavController()
    LogoRow(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())

}