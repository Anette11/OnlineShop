package com.example.effectivemobiletesttask.ui.screens.main_screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.MapKeysCreator
import com.example.effectivemobiletesttask.util.ResourcesProvider
import com.example.effectivemobiletesttask.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val mapKeysCreator: MapKeysCreator
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private fun onClickActionShowToast(message: String) = launch {
        _clickAction.emit(ClickAction.ShowToast(message = message))
    }

    private val _pickPhotoFromGallery: MutableSharedFlow<Unit> = MutableSharedFlow()
    val pickPhotoFromGallery: SharedFlow<Unit> = _pickPhotoFromGallery.asSharedFlow()

    var showLogoutDialog by mutableStateOf(false)
        private set

    fun changeValueShowLogoutDialog() {
        showLogoutDialog = !showLogoutDialog
    }

    private var indexPhoto = 0

    fun changePhotoUri(newPhotoUri: Any?) {
        val newPhotoItem =
            (_screenItems[indexPhoto] as ScreenItem.ItemIcon).copy(icon = newPhotoUri)
        _screenItems.removeAt(indexPhoto)
        _screenItems.add(indexPhoto, newPhotoItem)
    }

    private var _screenItems = mutableStateListOf<ScreenItem>()
    val screenItems = _screenItems

    private fun fillScreenItems() {
        val screenItems = sortedMapOf(
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._36
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.ItemBack(
                icon = R.drawable.arrow_left,
                contentDescription = resourcesProvider.getString(R.string.back),
                text = resourcesProvider.getString(R.string.profile),
                onClick = { launch { _clickAction.emit(ClickAction.PopBackStack) } }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._19
                )
            ),
            mapKeysCreator.createMapKey().apply { indexPhoto = this } to ScreenItem.ItemIcon(
                icon = R.drawable.image_default,
                contentDescription = resourcesProvider.getString(R.string.change_photo),
                size = resourcesProvider.getInteger(R.integer._61),
                borderWidth = resourcesProvider.getInteger(R.integer._2),
                color = R.color.gray_lighter
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._6
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.ItemAdditionalInfo(
                text = resourcesProvider.getString(R.string.change_photo),
                onClick = { launch { _pickPhotoFromGallery.emit(Unit) } }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._17
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.TextSubtitle(
                text = resourcesProvider.getString(R.string.example_name)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._36
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.LargeButtonIcon(
                text = resourcesProvider.getString(R.string.upload_item),
                onClick = {},
                icon = R.drawable.ic_upload,
                contentDescription = resourcesProvider.getString(R.string.upload_item)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.trade_store),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.trade_store)) }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.payment_method),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.payment_method)) }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextText(
                icon = R.drawable.ic_credit_card,
                contentDescription = resourcesProvider.getString(R.string.icon),
                textCenter = resourcesProvider.getString(R.string.balance),
                textRight = resourcesProvider.getString(R.string.balance_value),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.balance)) }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.trade_history),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.trade_history)) }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextIcon(
                iconLeft = R.drawable.ic_credit_card,
                iconRight = R.drawable.arrow_right,
                contentDescriptionLeft = resourcesProvider.getString(R.string.icon),
                contentDescriptionRight = resourcesProvider.getString(R.string.arrow_right),
                text = resourcesProvider.getString(R.string.restore_purchase),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.restore_purchase)) }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconText(
                icon = R.drawable.ic_help,
                contentDescription = resourcesProvider.getString(R.string.icon),
                text = resourcesProvider.getString(R.string.help),
                onClick = { onClickActionShowToast(message = resourcesProvider.getString(R.string.help)) }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._25
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconText(
                icon = R.drawable.ic_log_out,
                contentDescription = resourcesProvider.getString(R.string.icon),
                text = resourcesProvider.getString(R.string.log_out),
                onClick = { showLogoutDialog = true }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._36
                )
            )
        )
        _screenItems.addAll(screenItems.values)
    }

    init {
        fillScreenItems()
    }
}