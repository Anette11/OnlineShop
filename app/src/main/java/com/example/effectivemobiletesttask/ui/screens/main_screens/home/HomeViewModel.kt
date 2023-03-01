package com.example.effectivemobiletesttask.ui.screens.main_screens.home

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.FilterRowItem
import com.example.effectivemobiletesttask.ui.screens.items.LatestItem
import com.example.effectivemobiletesttask.ui.screens.items.SaleItem
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = 23),
        ScreenItem.IconTextIconLarge(
            iconLeft = R.drawable.ic_menu,
            contentDescription = resourcesProvider.getString(R.string.menu),
            textMain = resourcesProvider.getString(R.string.trade_by),
            textAdditional = resourcesProvider.getString(R.string.bata),
            iconRight = R.drawable.ic_launcher_foreground,
            contentDescriptionRight = resourcesProvider.getString(R.string.photo),
            size = 31,
            borderWidth = 2,
            color = R.color.gray_lighter
        ),
        ScreenItem.SpacerRow(height = 7),
        ScreenItem.LocationItem(
            text = resourcesProvider.getString(R.string.location),
            icon = R.drawable.ic_arrow_down,
            contentDescription = resourcesProvider.getString(R.string.expand)
        ),
        ScreenItem.SpacerRow(height = 9),
        ScreenItem.SearchRow(
            placeholder = resourcesProvider.getString(R.string.what_are_you_looking_for),
            value = resourcesProvider.getString(R.string.empty),
            onValueChange = {}
        ),
        ScreenItem.SpacerRow(height = 17),
        ScreenItem.FilterRow(
            items = listOf(
                FilterRowItem(
                    icon = R.drawable.ic_phone,
                    contentDescription = resourcesProvider.getString(R.string.phones),
                    hint = resourcesProvider.getString(R.string.phones)
                ),
                FilterRowItem(
                    icon = R.drawable.ic_headphones,
                    contentDescription = resourcesProvider.getString(R.string.headphones),
                    hint = resourcesProvider.getString(R.string.headphones)
                ),
                FilterRowItem(
                    icon = R.drawable.ic_joystick,
                    contentDescription = resourcesProvider.getString(R.string.games),
                    hint = resourcesProvider.getString(R.string.games)
                ),
                FilterRowItem(
                    icon = R.drawable.ic_car,
                    contentDescription = resourcesProvider.getString(R.string.cars),
                    hint = resourcesProvider.getString(R.string.cars)
                ),
                FilterRowItem(
                    icon = R.drawable.ic_bed,
                    contentDescription = resourcesProvider.getString(R.string.furniture),
                    hint = resourcesProvider.getString(R.string.furniture)
                ),
                FilterRowItem(
                    icon = R.drawable.ic_robot,
                    contentDescription = resourcesProvider.getString(R.string.kids),
                    hint = resourcesProvider.getString(R.string.kids)
                )
            )
        ),
        ScreenItem.SpacerRow(height = 30),
        ScreenItem.TextSpaceText(
            textStart = resourcesProvider.getString(R.string.latest_deals),
            textEnd = resourcesProvider.getString(R.string.view_all)
        ),
        ScreenItem.SpacerRow(height = 8),
        ScreenItem.LatestItemsRow(
            items = buildList {
                for (i in 0..10) {
                    add(
                        LatestItem(
                            image = R.drawable.ic_rectangle,
                            contentDescriptionImage = resourcesProvider.getString(R.string.empty),
                            height = 149,
                            width = 114,
                            radiusImage = 9,
                            icon = R.drawable.ic_add_small,
                            contentDescriptionIcon = resourcesProvider.getString(R.string.empty),
                            text = resourcesProvider.getString(R.string.phones),
                            color = R.color.gray_half_transparent,
                            radiusItem = 5,
                            fontSize = 6,
                            name = resourcesProvider.getString(R.string.play_station_5_console)
                                .plus("\n"),
                            price = resourcesProvider.getString(R.string.price_test)
                        )
                    )
                }
            }
        ),
        ScreenItem.SpacerRow(height = 17),
        ScreenItem.TextSpaceText(
            textStart = resourcesProvider.getString(R.string.flash_sale),
            textEnd = resourcesProvider.getString(R.string.view_all)
        ),
        ScreenItem.SpacerRow(height = 8),
        ScreenItem.SaleItemsRow(
            items = buildList {
                for (i in 0..10) {
                    add(
                        SaleItem(
                            image = R.drawable.ic_snickers,
                            contentDescriptionImage = resourcesProvider.getString(R.string.empty),
                            height = 221,
                            width = 174,
                            radiusImage = 11,
                            text = resourcesProvider.getString(R.string.kids),
                            color = R.color.gray_half_transparent,
                            radiusItem = 8,
                            fontSize = 9,
                            name = resourcesProvider.getString(R.string.new_balance_sneakers),
                            price = resourcesProvider.getString(R.string.price_test),
                            iconSmall = R.drawable.ic_like_small,
                            contentDescriptionIconSmall = resourcesProvider.getString(R.string.empty),
                            iconLarge = R.drawable.ic_add_large,
                            contentDescriptionIconLarge = resourcesProvider.getString(R.string.empty),
                            imageTop = R.drawable.ic_person,
                            contentDescriptionIconTop = resourcesProvider.getString(R.string.empty),
                            discountText = resourcesProvider.getString(R.string.discount_text)
                        )
                    )
                }
            }
        ),
        ScreenItem.SpacerRow(height = 17),
        ScreenItem.TextSpaceText(
            textStart = resourcesProvider.getString(R.string.brands),
            textEnd = resourcesProvider.getString(R.string.view_all)
        ),
        ScreenItem.SpacerRow(height = 8)
    )
}