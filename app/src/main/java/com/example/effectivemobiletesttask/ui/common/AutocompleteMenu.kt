package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AutocompleteMenu(
    words: List<String>,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onClick: (String) -> Unit,
    onDismissRequest: () -> Unit
) = ExposedDropdownMenuBox(
    expanded = isExpanded,
    onExpandedChange = onExpandedChange,
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = dimensionResource(id = R.dimen._40dp))
        .background(color = colorResource(id = R.color.white_dark))
        .shadow(elevation = dimensionResource(id = R.dimen._2dp))
) {
    ExposedDropdownMenu(
        expanded = isExpanded,
        onDismissRequest = onDismissRequest
    ) {
        words.forEach { word ->
            DropdownMenuItem(
                onClick = { onClick(word) }
            ) {
                Text(
                    text = word,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontSize = dimensionResource(id = R.dimen._11sp).value.sp
                )
            }
        }
    }
}

@Composable
@Preview
fun AutocompleteMenuPreview() =
    AutocompleteMenu(
        words = listOf(
            stringResource(id = R.string.new_balance_sneakers),
            stringResource(id = R.string.new_balance_sneakers),
            stringResource(id = R.string.new_balance_sneakers)
        ),
        isExpanded = true,
        onExpandedChange = {},
        onClick = {},
        onDismissRequest = {}
    )