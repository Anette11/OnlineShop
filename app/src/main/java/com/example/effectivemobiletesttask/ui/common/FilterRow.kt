package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.FilterRowItem

@Composable
fun FilterRow(
    items: List<FilterRowItem>
) = LazyRow(modifier = Modifier.fillMaxWidth()) {
    itemsIndexed(items = items) { index, item ->
        IconInCircleWithHint(
            icon = item.icon,
            contentDescription = item.contentDescription,
            hint = item.hint
        )
        if (index != items.size - 1) {
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._20dp)))
        }
    }
}

@Composable
@Preview
fun FilterRowPreview() =
    FilterRow(
        items = listOf(
            FilterRowItem(
                icon = R.drawable.ic_phone,
                contentDescription = stringResource(id = R.string.phones),
                hint = stringResource(id = R.string.phones)
            ),
            FilterRowItem(
                icon = R.drawable.ic_headphones,
                contentDescription = stringResource(id = R.string.headphones),
                hint = stringResource(id = R.string.headphones)
            ),
            FilterRowItem(
                icon = R.drawable.ic_joystick,
                contentDescription = stringResource(id = R.string.games),
                hint = stringResource(id = R.string.games)
            ),
            FilterRowItem(
                icon = R.drawable.ic_car,
                contentDescription = stringResource(id = R.string.cars),
                hint = stringResource(id = R.string.cars)
            ),
            FilterRowItem(
                icon = R.drawable.ic_bed,
                contentDescription = stringResource(id = R.string.furniture),
                hint = stringResource(id = R.string.furniture)
            ),
            FilterRowItem(
                icon = R.drawable.ic_robot,
                contentDescription = stringResource(id = R.string.kids),
                hint = stringResource(id = R.string.kids)
            )
        )
    )