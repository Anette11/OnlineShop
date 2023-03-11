package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.DetailImageItem
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalGlideComposeApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun HugeImage(
    contentDescriptionImage: String,
    @DrawableRes icon: Int,
    contentDescriptionIcon: String,
    @DrawableRes iconMiddle: Int,
    contentDescriptionIconMiddle: String,
    @DrawableRes iconBottom: Int,
    contentDescriptionIconBottom: String,
    onBackClick: () -> Unit,
    onLikeClick: () -> Unit,
    onShareClick: (Int) -> Unit,
    list: List<DetailImageItem>,
    isLiked: Boolean
) {
    val pageState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen._279dp))
        ) {
            HorizontalPager(
                pageCount = list.size,
                state = pageState,
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen._7dp),
                        end = dimensionResource(id = R.dimen._52dp)
                    )
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = dimensionResource(id = R.dimen._9dp),
                            bottomEnd = dimensionResource(id = R.dimen._9dp)
                        )
                    )
            ) { page ->
                GlideImage(
                    model = list[page].image,
                    contentDescription = contentDescriptionImage,
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier
                    .clickable { onBackClick() }
                    .padding(
                        start = dimensionResource(id = R.dimen._16dp),
                        end = dimensionResource(id = R.dimen._16dp)
                    )
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescriptionIcon,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen._8dp))
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(
                        bottom = dimensionResource(id = R.dimen._28dp),
                        end = dimensionResource(id = R.dimen._12dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._14dp)))
                        .background(color = colorResource(id = R.color.gray_middle)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isLiked) R.drawable.ic_heart_large_selected
                            else R.drawable.ic_heart_large
                        ),
                        contentDescription = stringResource(id = R.string.empty),
                        tint = colorResource(
                            id = if (isLiked) R.color.red
                            else R.color.purple
                        ),
                        modifier = Modifier
                            .clickable { onLikeClick() }
                            .padding(dimensionResource(id = R.dimen._14dp))
                    )
                    Icon(
                        painter = painterResource(id = iconMiddle),
                        contentDescription = contentDescriptionIconMiddle,
                        tint = colorResource(id = R.color.purple)
                    )
                    Icon(
                        painter = painterResource(id = iconBottom),
                        contentDescription = contentDescriptionIconBottom,
                        tint = colorResource(id = R.color.purple),
                        modifier = Modifier
                            .clickable { onShareClick(pageState.currentPage) }
                            .padding(dimensionResource(id = R.dimen._14dp))
                    )
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._18dp)))
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._35dp)))
        DetailImagesRow(
            items = list,
            horizontalPadding = integerResource(id = R.integer._24),
            onSelect = { selectedPage ->
                scope.launch {
                    pageState.scrollToPage(selectedPage)
                }
            },
            currentPage = pageState.currentPage
        )
    }
}

@Composable
@Preview
fun HugeImagePreview() =
    HugeImage(
        contentDescriptionImage = stringResource(id = R.string.empty),
        icon = R.drawable.ic_arrow_back_small,
        contentDescriptionIcon = stringResource(id = R.string.empty),
        iconMiddle = R.drawable.ic_dash,
        contentDescriptionIconMiddle = stringResource(id = R.string.empty),
        iconBottom = R.drawable.ic_share,
        contentDescriptionIconBottom = stringResource(id = R.string.empty),
        onBackClick = {},
        onLikeClick = {},
        onShareClick = {},
        list = emptyList(),
        isLiked = false
    )