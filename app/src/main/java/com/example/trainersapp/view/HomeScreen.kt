package com.example.trainersapp.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.example.trainersapp.R
import com.example.trainersapp.model.ShoeData
import com.example.trainersapp.model.ShoeDataSource
import com.example.trainersapp.navigation.TabItem
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography
import com.example.trainersapp.ui.theme.RatingYellow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen( onItemClicked: (item: Int) -> Unit
) {
    //tabs
    val tabs = listOf(
        TabItem(
            title = "Nike",
            logo = R.drawable.nike_logo,
            screen = { TabScreen(content = { HomeContent(onItemClicked) }) }),

        TabItem(title = "Puma",
            logo = R.drawable.puma_logo,
            screen = { TabScreen(content = { PumaContent() }) }),

        TabItem(title = "Adidas",
            logo = R.drawable.adidas_logo,
            screen = { TabScreen(content = { AdidasContent() }) }),

        TabItem(title = "Vans",
            logo = R.drawable.vans_logo,
            screen = { TabScreen(content = { VansContent() }) })
    )


    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
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
        // Tab row
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth() .padding(horizontal = 16.dp),
            backgroundColor = MaterialTheme.colors.background,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.Black,
                    height = 2.dp,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            }) {
            tabs.forEachIndexed { index, tabItem ->
                Tab(
                    selected = pagerState.currentPage == index, onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }, modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
                ) {
                    Image(
                        painter = painterResource(tabItem.logo),
                        contentDescription = tabItem.title,
                        modifier = Modifier.heightIn(40.dp)
                    )
                }
            }
        }
        // Content
        HorizontalPager(
            count = tabs.size, state = pagerState
        ) { page ->
            tabs[page].screen()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(onItemClicked: (item: Int) -> Unit) {
    Box(modifier = Modifier) {
        ShoeGrid(onItemClicked)
    }
}

@Composable
fun PumaContent() {
    // Content for the Puma tab goes here
}

@Composable
fun AdidasContent() {
    // Content for the Adidas tab goes here
}

@Composable
fun VansContent() {
    // Content for the Vans tab goes here
}




@ExperimentalFoundationApi
@Composable
fun ShoeGrid(onItemClicked: (item: Int) -> Unit) {
    val destinations = ShoeDataSource().loadData()

    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(destinations) { item, destination ->
                GridItemLayout(destination, onItemClicked = { onItemClicked(item) })
        }
    }
}


@Composable
fun GridItemLayout(
    destination: ShoeData,
    onItemClicked: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { (onItemClicked()) }
    ) {
        Box {
            Image(
                painter = painterResource(destination.id),
                contentDescription = stringResource(destination.name),
                modifier = Modifier
                    .widthIn(185.dp)
                    .heightIn(130.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit,
            )
            Row(
                modifier = Modifier.widthIn(min = 175.dp), horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(App_purple_fade)
                        .padding(2.dp)
                ) {

                    Text(
                        String.format("GHS %.2f", destination.price), color = Color.Black,
                        style = PoppinsTypography.body1,
                        fontSize = 8.sp,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.heightIn(10.dp))

        Row(
            modifier = Modifier
                .widthIn(169.dp)
                .padding(start = 8.dp),
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


//create rating system
@Composable
fun Rating(
    rating: Int, modifier: Modifier = Modifier,
) {
    Row(
        modifier.padding(horizontal = 0.dp)
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
    val destination = ShoeData(
        id = R.drawable.yellow_adidas,
        name = R.string.yellow_adidas_string,
        description = R.string.Reviews,
        rating = 4,
        price = 200.00
    )
    SimilarMatchLayout(destination,  onItemClicked = {})
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onItemClicked = {})

}

