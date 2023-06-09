package com.example.effectivemobiletesttask.ui.screens.main_screens.home.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.DispatchersProvider
import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest
import com.example.domain.use_cases.GetFlashSaleUseCase
import com.example.domain.use_cases.GetLatestUseCase
import com.example.domain.use_cases.GetUserByIsLoggedInFlow
import com.example.domain.use_cases.GetWordsUseCase
import com.example.domain.util.ApiResponse
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.NavControllerType
import com.example.effectivemobiletesttask.navigation.NavigationAction
import com.example.effectivemobiletesttask.navigation.Screen
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.*
import com.example.effectivemobiletesttask.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val getLatestUseCase: GetLatestUseCase,
    private val getFlashSaleUseCase: GetFlashSaleUseCase,
    private val mapKeysCreator: MapKeysCreator,
    private val getUserByIsLoggedInFlow: GetUserByIsLoggedInFlow,
    private val getWordsUseCase: GetWordsUseCase,
    private val dispatchersProvider: DispatchersProvider,
    private val clickActionTransmitter: ClickActionTransmitter,
    private val navigationActionTransmitter: NavigationActionTransmitter
) : ViewModel() {

    var screenItems = mutableStateListOf<ScreenItem>()
        private set

    var isLoading by mutableStateOf(false)
        private set

    private var getWordsJob: Job? = null

    private var indexPhoto = 0
    private var indexLatest = 0
    private var indexFlashSale = 0
    private var indexBrand = 0
    private var indexSearchRow = 0
    private var indexAutocompleteMenu = 0

    private fun fillScreenItems() {
        val screenItems = sortedMapOf(mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
            height = resourcesProvider.getInteger(
                R.integer._23
            )
        ),
            mapKeysCreator.createMapKey().apply { indexPhoto = this } to
                    ScreenItem.IconTextIconLarge(
                        iconLeft = R.drawable.ic_menu,
                        contentDescription = resourcesProvider.getString(R.string.menu),
                        textMain = resourcesProvider.getString(R.string.trade_by),
                        textAdditional = resourcesProvider.getString(R.string.bata),
                        iconRight = null,
                        contentDescriptionRight = resourcesProvider.getString(R.string.photo),
                        size = resourcesProvider.getInteger(R.integer._31),
                        borderWidth = resourcesProvider.getInteger(R.integer._2),
                        color = R.color.gray_lighter
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._7
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.LocationItem(
                text = resourcesProvider.getString(R.string.location),
                icon = R.drawable.ic_arrow_down,
                contentDescription = resourcesProvider.getString(R.string.expand)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._9
                )
            ),
            mapKeysCreator.createMapKey().apply { indexSearchRow = this } to
                    ScreenItem.SearchRow(
                        placeholder = resourcesProvider.getString(R.string.what_are_you_looking_for),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onSearchRowValueChange(newValue = newValue)
                            searchWords(word = newValue)
                        },
                        onClick = {}
                    ),
            mapKeysCreator.createMapKey().apply { indexAutocompleteMenu = this } to
                    ScreenItem.AutocompleteMenu(
                        words = emptyList(),
                        isExpanded = false,
                        onExpandedChange = {},
                        onClick = { word -> onWordSelected(word) },
                        onDismissRequest = { onDismissAutocompleteMenu() }
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._17
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.FilterRow(
                items = listOf(
                    FilterRowItem(
                        icon = R.drawable.ic_phone,
                        contentDescription = resourcesProvider.getString(R.string.phones),
                        hint = resourcesProvider.getString(R.string.phones)
                    ), FilterRowItem(
                        icon = R.drawable.ic_headphones,
                        contentDescription = resourcesProvider.getString(R.string.headphones),
                        hint = resourcesProvider.getString(R.string.headphones)
                    ), FilterRowItem(
                        icon = R.drawable.ic_joystick,
                        contentDescription = resourcesProvider.getString(R.string.games),
                        hint = resourcesProvider.getString(R.string.games)
                    ), FilterRowItem(
                        icon = R.drawable.ic_car,
                        contentDescription = resourcesProvider.getString(R.string.cars),
                        hint = resourcesProvider.getString(R.string.cars)
                    ), FilterRowItem(
                        icon = R.drawable.ic_bed,
                        contentDescription = resourcesProvider.getString(R.string.furniture),
                        hint = resourcesProvider.getString(R.string.furniture)
                    ), FilterRowItem(
                        icon = R.drawable.ic_robot,
                        contentDescription = resourcesProvider.getString(R.string.kids),
                        hint = resourcesProvider.getString(R.string.kids)
                    )
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._30
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.TextSpaceText(
                textStart = resourcesProvider.getString(R.string.latest_deals),
                textEnd = resourcesProvider.getString(R.string.view_all)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._8
                )
            ),
            mapKeysCreator.createMapKey().apply { indexLatest = this } to
                    ScreenItem.LatestItemsRow(
                        items = emptyList()
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._17
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.TextSpaceText(
                textStart = resourcesProvider.getString(R.string.flash_sale),
                textEnd = resourcesProvider.getString(R.string.view_all)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._8
                )
            ),
            mapKeysCreator.createMapKey().apply { indexFlashSale = this } to
                    ScreenItem.SaleItemsRow(items = emptyList()),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._17
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.TextSpaceText(
                textStart = resourcesProvider.getString(R.string.brands),
                textEnd = resourcesProvider.getString(R.string.view_all)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._8
                )
            ),
            mapKeysCreator.createMapKey().apply { indexBrand = this } to
                    ScreenItem.BrandRow(items = emptyList()),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._23
                )
            )
        )
        this.screenItems.addAll(screenItems.values)
    }

    private fun getTradeData() = viewModelScope.launch(Dispatchers.IO) {
        withContext(dispatchersProvider.main) { isLoading = true }
        val latestFlow =
            getLatestUseCase.invoke(genericError = resourcesProvider.getString(R.string.error_occurred))
        val flashSaleFlow =
            getFlashSaleUseCase.invoke(genericError = resourcesProvider.getString(R.string.error_occurred))
        latestFlow.zip(flashSaleFlow) { apiResponseLatest, apiResponseFlashSale ->
            if (apiResponseLatest is ApiResponse.Success && apiResponseFlashSale is ApiResponse.Success) {
                withContext(dispatchersProvider.main) {
                    updateLatest(list = apiResponseLatest.data)
                    updateFlashSale(list = apiResponseFlashSale.data)
                    updateBrands()
                }
            }
            if (apiResponseLatest is ApiResponse.Error) {
                clickActionTransmitter.flow.emit(
                    ClickAction.ShowToast(
                        message = apiResponseLatest.message
                            ?: resourcesProvider.getString(R.string.error_in_latest_deals)
                    )
                )
            }
            if (apiResponseFlashSale is ApiResponse.Error) {
                if (apiResponseLatest.message != apiResponseFlashSale.message) {
                    clickActionTransmitter.flow.emit(
                        ClickAction.ShowToast(
                            message = apiResponseFlashSale.message
                                ?: resourcesProvider.getString(R.string.error_in_flash_sale)
                        )
                    )
                }
            }
        }.collect()
        withContext(dispatchersProvider.main) { isLoading = false }
    }

    private fun updateLatest(list: List<Latest>?) {
        screenItems[indexLatest] =
            (screenItems[indexLatest] as ScreenItem.LatestItemsRow)
                .copy(
                    items = list?.map { latest ->
                        LatestItem(
                            image = latest.imageUrl,
                            contentDescriptionImage = resourcesProvider.getString(R.string.empty),
                            height = resourcesProvider.getInteger(R.integer._149),
                            width = resourcesProvider.getInteger(R.integer._114),
                            radiusImage = resourcesProvider.getInteger(R.integer._9),
                            icon = R.drawable.ic_add_small,
                            contentDescriptionIcon = resourcesProvider.getString(R.string.empty),
                            text = latest.category
                                ?: resourcesProvider.getString(R.string.not_applicable),
                            color = R.color.gray_half_transparent,
                            radiusItem = resourcesProvider.getInteger(R.integer._5),
                            fontSize = resourcesProvider.getInteger(R.integer._6),
                            name = latest.name
                                ?: resourcesProvider.getString(R.string.not_applicable),
                            price = if (latest.price != null) "$ ${latest.price}"
                            else resourcesProvider.getString(R.string.not_applicable)
                        )
                    } ?: emptyList())
    }

    private fun updateFlashSale(
        list: List<FlashSale>?
    ) {
        screenItems[indexFlashSale] = (screenItems[indexFlashSale] as ScreenItem.SaleItemsRow)
            .copy(items = list?.map { flashSale ->
                SaleItem(image = flashSale.imageUrl,
                    contentDescriptionImage = resourcesProvider.getString(R.string.empty),
                    height = resourcesProvider.getInteger(R.integer._221),
                    width = resourcesProvider.getInteger(R.integer._174),
                    radiusImage = resourcesProvider.getInteger(R.integer._11),
                    text = if (flashSale.category != null) "${flashSale.category}"
                    else resourcesProvider.getString(R.string.not_applicable),
                    color = R.color.gray_half_transparent,
                    radiusItem = resourcesProvider.getInteger(R.integer._8),
                    fontSize = resourcesProvider.getInteger(R.integer._9),
                    name = if (flashSale.name != null) "${flashSale.name}"
                    else resourcesProvider.getString(R.string.not_applicable),
                    price = if (flashSale.price != null) "$ ${flashSale.price}"
                    else resourcesProvider.getString(R.string.not_applicable),
                    iconSmall = R.drawable.ic_like_small,
                    contentDescriptionIconSmall = resourcesProvider.getString(R.string.empty),
                    iconLarge = R.drawable.ic_add_large,
                    contentDescriptionIconLarge = resourcesProvider.getString(R.string.empty),
                    imageTop = R.drawable.ic_person,
                    contentDescriptionIconTop = resourcesProvider.getString(R.string.empty),
                    discountText = if (flashSale.discount != null) "${flashSale.discount}% off"
                    else resourcesProvider.getString(R.string.not_applicable),
                    onItemClick = {
                        launch(dispatchersProvider.io) {
                            navigationActionTransmitter.flow.emit(
                                NavigationAction.NavigateToScreen(
                                    route = Screen.Details.route,
                                    navControllerType = NavControllerType.Main
                                )
                            )
                        }
                    })
            } ?: emptyList())
    }

    private fun getUserByIsLoggedInFlow() = launch(dispatchersProvider.io) {
        getUserByIsLoggedInFlow.invoke(isLoggedIn = true).collect { user ->
            user?.let {
                withContext(dispatchersProvider.main) {
                    screenItems[indexPhoto] =
                        (screenItems[indexPhoto] as ScreenItem.IconTextIconLarge).copy(
                            iconRight = if (user.imageUri != null) user.imageUri
                            else R.drawable.image_default
                        )
                }
            }
        }
    }

    private fun updateBrands() {
        val items = buildList {
            for (i in 0..4) {
                add(
                    BrandItem(
                        image = R.drawable.ic_huge,
                        text = resourcesProvider.getString(R.string.brand)
                    )
                )
            }
        }
        screenItems[indexBrand] = (screenItems[indexBrand] as ScreenItem.BrandRow).copy(
            items = items
        )
    }

    private fun onSearchRowValueChange(
        newValue: String
    ) {
        screenItems[indexSearchRow] =
            (screenItems[indexSearchRow] as ScreenItem.SearchRow).copy(value = newValue)
    }

    private fun searchWords(
        word: String
    ) {
        if (word.isBlank()) return
        getWordsJob?.cancel()
        getWordsJob = launch(dispatchersProvider.io) {
            delay(1000L)
            getWordsUseCase.invoke(genericError = resourcesProvider.getString(R.string.error_occurred))
                .collect { apiResponse ->
                    when (apiResponse) {
                        is ApiResponse.Error -> clickActionTransmitter.flow.emit(
                            ClickAction.ShowToast(
                                message = apiResponse.message
                                    ?: resourcesProvider.getString(R.string.error_occurred)
                            )
                        )
                        is ApiResponse.Success -> {
                            val filteredWords = apiResponse.data?.filter { foundWord ->
                                foundWord.contains(word, true)
                            } ?: emptyList()
                            withContext(dispatchersProvider.main) {
                                val textInSearchRow =
                                    (screenItems[indexSearchRow] as ScreenItem.SearchRow).value
                                screenItems[indexAutocompleteMenu] =
                                    (screenItems[indexAutocompleteMenu] as ScreenItem.AutocompleteMenu).copy(
                                        words = filteredWords,
                                        isExpanded = filteredWords.isNotEmpty() && textInSearchRow.isNotBlank()
                                    )
                            }
                        }
                    }
                }
        }
    }

    private fun onWordSelected(
        word: String
    ) {
        screenItems[indexAutocompleteMenu] =
            (screenItems[indexAutocompleteMenu] as ScreenItem.AutocompleteMenu).copy(
                words = emptyList(),
                isExpanded = false
            )
        screenItems[indexSearchRow] = (screenItems[indexSearchRow] as ScreenItem.SearchRow).copy(
            value = word
        )
        launch(dispatchersProvider.io) {
            clickActionTransmitter.flow.emit(ClickAction.ClearFocus)
        }
    }

    private fun onDismissAutocompleteMenu() {
        screenItems[indexAutocompleteMenu] =
            (screenItems[indexAutocompleteMenu] as ScreenItem.AutocompleteMenu).copy(
                words = emptyList(),
                isExpanded = false
            )
    }

    init {
        fillScreenItems()
        getUserByIsLoggedInFlow()
        getTradeData()
    }
}