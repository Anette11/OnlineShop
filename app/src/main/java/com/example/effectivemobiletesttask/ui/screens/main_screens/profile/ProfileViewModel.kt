package com.example.effectivemobiletesttask.ui.screens.main_screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import com.example.effectivemobiletesttask.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private fun onClickActionShowToast(message: String) = launch {
        _clickAction.emit(ClickAction.ShowToast(message = message))
    }

    var showLogoutDialog by mutableStateOf(false)
        private set

    fun changeValueShowLogoutDialog() {
        showLogoutDialog = !showLogoutDialog
    }

    private var _screenItems = mutableStateListOf<ScreenItem>()
    val screenItems = _screenItems

    private fun fillScreenItems() {
        val screenItems = listOf(
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._36)),
            ScreenItem.ItemBack(
                icon = R.drawable.arrow_left,
                contentDescription = resourcesProvider.getString(R.string.back),
                text = resourcesProvider.getString(R.string.profile),
                onClick = { launch { _clickAction.emit(ClickAction.PopBackStack) } }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._19)),
            ScreenItem.ItemIcon(
                icon = R.drawable.image_default,
                contentDescription = resourcesProvider.getString(R.string.change_photo),
                size = resourcesProvider.getInteger(R.integer._61),
                borderWidth = resourcesProvider.getInteger(R.integer._2),
                color = R.color.gray_lighter
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._6)),
            ScreenItem.ItemAdditionalInfo(
                text = resourcesProvider.getString(R.string.change_photo),
                onClick = {}
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._17)),
            ScreenItem.TextSubtitle(
                text = resourcesProvider.getString(R.string.example_name)
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._36)),
            ScreenItem.LargeButtonIcon(
                text = resourcesProvider.getString(R.string.upload_item),
                onClick = {},
                icon = R.drawable.ic_upload,
                contentDescription = resourcesProvider.getString(R.string.upload_item)
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.trade_store),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.trade_store)) }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.payment_method),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.payment_method)) }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconTextText(
                icon = R.drawable.ic_credit_card,
                contentDescription = resourcesProvider.getString(R.string.icon),
                textCenter = resourcesProvider.getString(R.string.balance),
                textRight = resourcesProvider.getString(R.string.balance_value),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.balance)) }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.trade_history),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.trade_history)) }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.restore_purchase),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.restore_purchase)) }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconText(
                icon = R.drawable.ic_help,
                contentDescription = resourcesProvider.getString(R.string.icon),
                text = resourcesProvider.getString(R.string.help),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.help)) }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._25)),
            ScreenItem.IconText(
                icon = R.drawable.ic_log_out,
                contentDescription = resourcesProvider.getString(R.string.icon),
                text = resourcesProvider.getString(R.string.log_out),
                onClick = { showLogoutDialog = true }
            ),
            ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._36))
        )
        _screenItems.addAll(screenItems)
    }

    init {
        fillScreenItems()
    }
}