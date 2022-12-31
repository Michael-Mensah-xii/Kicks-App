package com.example.trainersapp.model

import androidx.annotation.DrawableRes

data class LogoData(
    @DrawableRes val logo: Int,

    )


/*
@ExperimentalFoundationApi
@Composable
fun ShoeGrid(navController: NavHostController) {
    val destinations = ShoeDataSource().loadData()


    Column() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                //.padding(top = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.brands),
                style = PoppinsTypography.h3,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.heightIn(16.dp))

        //LogoRow
        LogoRow(navController)

        Spacer(modifier = Modifier.heightIn(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues( 8.dp),
            modifier = Modifier.padding(bottom = 48.dp)
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
            .widthIn(max = 185.dp)
            .heightIn(max = 140.dp)
            .clickable {
                navController.navigate("details/$index")
            }
    ) {
        Image(
            painter = painterResource(destination.id),
            contentDescription = stringResource(destination.name),
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.heightIn(10.dp))

        Row(modifier = Modifier
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

        Text(
            text = stringResource(destination.price),
            color = Color.Black,
            style = PoppinsTypography.body1,
            fontSize = 7.sp,
        )
    }
}
*/
