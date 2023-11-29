package gentle.hilt.history.screen.history_item

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import gentle.hilt.data.history.BoughtItem
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors

import gentle.hilt.history.HistoryScreenVM
import gentle.hilt.history.screen.BoughtItemsGrid
import gentle.hilt.history.screen.history_item.calculate_grid_height.calculateGridHeight
import gentle.hilt.history.screen.history_item.references.HistoryItemButtonReorder
import gentle.hilt.history.screen.history_item.references.HistoryItemDate
import gentle.hilt.history.screen.history_item.references.HistoryItemPrice
import org.koin.androidx.compose.getViewModel

@Composable
fun HistoryItem(
    history: BoughtItem
) {
    val gridHeight = calculateGridHeight(history.items)
    val viewModel: HistoryScreenVM = getViewModel()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.themeColors.background)
            .border(1.dp, MaterialTheme.themeColors.text)
    ) {
        val (list, price, date, reorder) = createRefs()

        HistoryItemButtonReorder(
            history = history.items,
            viewModel = viewModel,
            modifier = Modifier.constrainAs(reorder) {
                top.linkTo(parent.top)
                end.linkTo(parent.end, margin = 5.dp)
            },
        )

        HistoryItemDate(
            text = "${strings.orderFrom} ${history.date}",
            modifier = Modifier.constrainAs(date) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 5.dp)
            })

        HistoryItemPrice(
            text = "${strings.cost} ${history.price}$",
            modifier = Modifier.constrainAs(price) {
                top.linkTo(date.bottom)
                start.linkTo(parent.start, margin = 5.dp)
            })


        BoughtItemsGrid(
            boughtItems = history.items,
            modifier = Modifier.constrainAs(list) {
                top.linkTo(price.bottom)
                centerHorizontallyTo(parent)
                bottom.linkTo(parent.bottom)

                height = Dimension.value(gridHeight)
                width = Dimension.fillToConstraints
            })

    }
}