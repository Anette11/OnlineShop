package com.example.effectivemobiletesttask.ui.screens.main_screens.home.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.data.remote.DispatchersProvider
import com.example.domain.data.remote.ProductDetails
import com.example.domain.use_cases.GetProductDetailsUseCase
import com.example.domain.util.ApiResponse
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.NavControllerType
import com.example.effectivemobiletesttask.navigation.NavigationAction
import com.example.effectivemobiletesttask.navigation.Screen
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.AddToCartItem
import com.example.effectivemobiletesttask.ui.screens.items.ColorItem
import com.example.effectivemobiletesttask.ui.screens.items.DetailImageItem
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val mapKeysCreator: MapKeysCreator,
    private val dispatchersProvider: DispatchersProvider,
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val clickActionTransmitter: ClickActionTransmitter,
    private val navigationActionTransmitter: NavigationActionTransmitter
) : ViewModel() {

    var screenItems = mutableStateListOf<ScreenItem>()
        private set

    var isLoading by mutableStateOf(false)
        private set

    var addToCartItem by mutableStateOf(
        AddToCartItem(
            quantity = 0,
            amountString = resourcesProvider.getString(R.string.empty),
            amountDouble = 0.0,
            price = 0.0,
            onIncreaseClick = { onIncreaseClick() },
            onDecreaseClick = { onDecreaseClick() },
            onAddToCardCardClick = {
                launch(dispatchersProvider.io) {
                    navigationActionTransmitter.flow.emit(
                        NavigationAction.NavigateToScreen(
                            route = Screen.Shopping.route,
                            navControllerType = NavControllerType.Main
                        )
                    )
                }
            }
        )
    )
        private set

    private fun onIncreaseClick() {
        val price = addToCartItem.price
        val newAmountDouble = addToCartItem.amountDouble + price
        val newQuantity = addToCartItem.quantity.plus(1)
        addToCartItem = addToCartItem.copy(
            quantity = newQuantity,
            amountString = "#$newAmountDouble",
            amountDouble = newAmountDouble
        )
    }

    private fun onDecreaseClick() {
        val price = addToCartItem.price
        val newAmountDouble = addToCartItem.amountDouble - price
        val newQuantity = addToCartItem.quantity.minus(1)
        if (newQuantity < 1 || newAmountDouble < 0) return
        addToCartItem = addToCartItem.copy(
            quantity = newQuantity,
            amountString = "#$newAmountDouble",
            amountDouble = newAmountDouble
        )
    }

    private var indexHugeImage = 0
    private var indexTextTextLarge = 0
    private var indexDetailDescription = 0
    private var indexReviews = 0
    private var indexColorsItem = 0

    private fun fillScreenItems() {
        val screenItems = sortedMapOf(mapKeysCreator.createMapKey() to
                ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._32)),
            mapKeysCreator.createMapKey().apply { indexHugeImage = this } to
                    ScreenItem.HugeImage(
                        contentDescriptionImage = resourcesProvider.getString(R.string.empty),
                        icon = R.drawable.ic_arrow_back_small,
                        contentDescriptionIcon = resourcesProvider.getString(R.string.empty),
                        iconMiddle = R.drawable.ic_dash,
                        contentDescriptionIconMiddle = resourcesProvider.getString(R.string.empty),
                        iconBottom = R.drawable.ic_share,
                        contentDescriptionIconBottom = resourcesProvider.getString(R.string.empty),
                        onBackClick = {
                            launch(dispatchersProvider.io) {
                                navigationActionTransmitter.flow.emit(
                                    NavigationAction.PopBackStack(
                                        navControllerType = NavControllerType.Main
                                    )
                                )
                            }
                        },
                        onLikeClick = { onLikeClick() },
                        onShareClick = { selectedImage ->
                            launch(dispatchersProvider.io) {
                                clickActionTransmitter.flow.emit(
                                    ClickAction.Share(
                                        image = (screenItems[indexHugeImage] as ScreenItem.HugeImage)
                                            .list[selectedImage]
                                            .image.toString()
                                    )
                                )
                            }
                        },
                        list = emptyList(),
                        isLiked = false
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._21)
            ),
            mapKeysCreator.createMapKey().apply { indexTextTextLarge = this } to
                    ScreenItem.TextTextLarge(
                        textStart = resourcesProvider.getString(R.string.empty),
                        textEnd = resourcesProvider.getString(R.string.empty),
                        horizontalPadding = resourcesProvider.getInteger(R.integer._24)
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._11)
            ),
            mapKeysCreator.createMapKey().apply { indexDetailDescription = this } to
                    ScreenItem.DetailDescription(
                        text = resourcesProvider.getString(R.string.empty),
                        horizontalPadding = resourcesProvider.getInteger(R.integer._24)
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._11)
            ),
            mapKeysCreator.createMapKey().apply { indexReviews = this } to
                    ScreenItem.Reviews(
                        rating = resourcesProvider.getString(R.string.empty),
                        reviews = resourcesProvider.getString(R.string.empty),
                        horizontalPadding = resourcesProvider.getInteger(R.integer._24)
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._13)
            ),
            mapKeysCreator.createMapKey().apply { indexColorsItem = this } to
                    ScreenItem.ColorsItem(
                        text = resourcesProvider.getString(R.string.color),
                        items = emptyList(),
                        horizontalPadding = resourcesProvider.getInteger(R.integer._24),
                        onSelect = { index -> onColorsItemSelected(indexSelected = index) }),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._100)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._32)
            )
        )
        this.screenItems.addAll(screenItems.values)
    }

    private fun getProductDetails() = launch(dispatchersProvider.io) {
        withContext(dispatchersProvider.main) { isLoading = true }
        val genericError = resourcesProvider.getString(R.string.error_occurred)
        getProductDetailsUseCase.invoke(genericError = genericError).collect { apiResponse ->
            when (apiResponse) {
                is ApiResponse.Error -> clickActionTransmitter.flow.emit(
                    ClickAction.ShowToast(message = apiResponse.message ?: genericError)
                )
                is ApiResponse.Success -> apiResponse.data?.let {
                    withContext(dispatchersProvider.main) {
                        onGetProductDetailsSuccess(data = apiResponse.data!!)
                    }
                }
            }
        }
        withContext(dispatchersProvider.main) { isLoading = false }
    }

    private fun onGetProductDetailsSuccess(
        data: ProductDetails
    ) {
        val defaultIndexSelected = 0
        screenItems[indexHugeImage] = (screenItems[indexHugeImage] as ScreenItem.HugeImage).copy(
            list = data.imageUrls.map { image ->
                DetailImageItem(
                    image = image,
                    contentDescription = resourcesProvider.getString(R.string.empty)
                )
            }
        )
        screenItems[indexTextTextLarge] =
            (screenItems[indexTextTextLarge] as ScreenItem.TextTextLarge).copy(
                textStart = if (data.name == null) resourcesProvider.getString(R.string.not_applicable)
                else "${data.name}",
                textEnd = if (data.price == null) resourcesProvider.getString(R.string.not_applicable)
                else "$ ${data.price}"
            )
        screenItems[indexDetailDescription] =
            (screenItems[indexDetailDescription] as ScreenItem.DetailDescription).copy(
                text = if (data.description == null) resourcesProvider.getString(R.string.not_applicable)
                else "${data.description}"
            )
        screenItems[indexReviews] = (screenItems[indexReviews] as ScreenItem.Reviews).copy(
            rating = if (data.rating == null) resourcesProvider.getString(R.string.not_applicable)
            else "${data.rating}",
            reviews = if (data.numberOfReviews == null) resourcesProvider.getString(R.string.not_applicable)
            else "(${data.numberOfReviews} reviews)"
        )
        screenItems[indexColorsItem] =
            (screenItems[indexColorsItem] as ScreenItem.ColorsItem)
                .copy(items = data.colors.mapIndexed { index, color ->
                    ColorItem(
                        color = color,
                        isSelected = index == defaultIndexSelected
                    )
                })
        addToCartItem = addToCartItem.copy(
            price = data.price ?: 0.0
        )
        onIncreaseClick()
    }

    private fun onColorsItemSelected(
        indexSelected: Int
    ) {
        screenItems[indexColorsItem] =
            (screenItems[indexColorsItem] as ScreenItem.ColorsItem)
                .copy(items = (screenItems[indexColorsItem] as ScreenItem.ColorsItem)
                    .items.mapIndexed { index, colorItem ->
                        colorItem.copy(
                            color = colorItem.color,
                            isSelected = index == indexSelected
                        )
                    })
    }

    private fun onLikeClick() {
        screenItems[indexHugeImage] = (screenItems[indexHugeImage] as ScreenItem.HugeImage).copy(
            isLiked = (screenItems[indexHugeImage] as ScreenItem.HugeImage).isLiked.not()
        )
    }

    init {
        fillScreenItems()
        getProductDetails()
    }
}