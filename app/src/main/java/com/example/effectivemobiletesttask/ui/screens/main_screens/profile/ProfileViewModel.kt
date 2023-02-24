package com.example.effectivemobiletesttask.ui.screens.main_screens.profile

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = 36),
        ScreenItem.ItemBack(
            icon = R.drawable.arrow_left,
            contentDescription = resourcesProvider.getString(R.string.back),
            text = resourcesProvider.getString(R.string.profile)
        ),
        ScreenItem.SpacerRow(height = 19),
        ScreenItem.ItemIcon(
            icon = R.drawable.ic_launcher_foreground,
            contentDescription = resourcesProvider.getString(R.string.change_photo),
            size = 61,
            borderWidth = 2,
            color = R.color.gray_lighter
        ),
        ScreenItem.SpacerRow(height = 6),
        ScreenItem.ItemAdditionalInfo(
            text = resourcesProvider.getString(R.string.change_photo)
        ),
        ScreenItem.SpacerRow(height = 17),
        ScreenItem.TextSubtitle(
            text = resourcesProvider.getString(R.string.example_name)
        ),
        ScreenItem.SpacerRow(height = 36),
        ScreenItem.LargeButtonIcon(
            text = resourcesProvider.getString(R.string.upload_item),
            onClick = {},
            icon = R.drawable.ic_share,
            contentDescription = resourcesProvider.getString(R.string.upload_item)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconTextIcon(
            iconLeft = R.drawable.ic_credit_card,
            iconRight = R.drawable.arrow_right,
            contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
            contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
            text = resourcesProvider.getString(R.string.trade_store)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconTextIcon(
            iconLeft = R.drawable.ic_credit_card,
            iconRight = R.drawable.arrow_right,
            contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
            contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
            text = resourcesProvider.getString(R.string.payment_method)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconTextText(
            icon = R.drawable.ic_credit_card,
            contentDescription = resourcesProvider.getString(R.string.icon),
            textCenter = resourcesProvider.getString(R.string.balance),
            textRight = resourcesProvider.getString(R.string.balance_value)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconTextIcon(
            iconLeft = R.drawable.ic_credit_card,
            iconRight = R.drawable.arrow_right,
            contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
            contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
            text = resourcesProvider.getString(R.string.trade_history)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconTextIcon(
            iconLeft = R.drawable.ic_credit_card,
            iconRight = R.drawable.arrow_right,
            contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
            contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
            text = resourcesProvider.getString(R.string.restore_purchase)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconText(
            icon = R.drawable.ic_help,
            contentDescription = resourcesProvider.getString(R.string.icon),
            text = resourcesProvider.getString(R.string.help)
        ),
        ScreenItem.SpacerRow(height = 25),
        ScreenItem.IconText(
            icon = R.drawable.ic_log_out,
            contentDescription = resourcesProvider.getString(R.string.icon),
            text = resourcesProvider.getString(R.string.log_out)
        ),
        ScreenItem.SpacerRow(height = 36)
    )
}