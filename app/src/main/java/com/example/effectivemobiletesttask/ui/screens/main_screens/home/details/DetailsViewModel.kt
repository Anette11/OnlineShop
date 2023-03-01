package com.example.effectivemobiletesttask.ui.screens.main_screens.home.details

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.ColorItem
import com.example.effectivemobiletesttask.ui.screens.items.DetailImageItem
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._32)),
        ScreenItem.HugeImage(
            image = R.drawable.ic_huge,
            contentDescriptionImage = resourcesProvider.getString(R.string.empty),
            icon = R.drawable.ic_arrow_back_small,
            contentDescriptionIcon = resourcesProvider.getString(R.string.empty),
            iconTop = R.drawable.ic_heart_large,
            contentDescriptionIconTop = resourcesProvider.getString(R.string.empty),
            iconMiddle = R.drawable.ic_dash,
            contentDescriptionIconMiddle = resourcesProvider.getString(R.string.empty),
            iconBottom = R.drawable.ic_share,
            contentDescriptionIconBottom = resourcesProvider.getString(R.string.empty),
            onBackClick = {},
            onLikeClick = {},
            onShareClick = {}
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
        ScreenItem.DetailImagesRow(
            items = listOf(
                DetailImageItem(
                    image = R.drawable.ic_huge,
                    contentDescription = resourcesProvider.getString(R.string.empty),
                    isSelected = false
                ),
                DetailImageItem(
                    image = R.drawable.ic_huge,
                    contentDescription = resourcesProvider.getString(R.string.empty),
                    isSelected = true
                ),
                DetailImageItem(
                    image = R.drawable.ic_huge,
                    contentDescription = resourcesProvider.getString(R.string.empty),
                    isSelected = false
                )
            )
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._21)),
        ScreenItem.TextTextLarge(
            textStart = resourcesProvider.getString(R.string.new_balance_sneakers),
            textEnd = resourcesProvider.getString(R.string.balance_value)
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._11)),
        ScreenItem.Reviews(
            rating = resourcesProvider.getString(R.string.rating),
            reviews = resourcesProvider.getString(R.string.reviews)
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._13)),
        ScreenItem.ColorsItem(
            text = resourcesProvider.getString(R.string.color),
            items = listOf(
                ColorItem(color = "#ffffff"),
                ColorItem(color = "#b5b5b5"),
                ColorItem(color = "#000000")
            )
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._20)),
        ScreenItem.AddToCart(
            amount = resourcesProvider.getString(R.string.balance_value)
        )
    )
}