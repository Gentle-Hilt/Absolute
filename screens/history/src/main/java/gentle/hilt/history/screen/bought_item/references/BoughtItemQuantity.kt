package gentle.hilt.history.screen.bought_item.references

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.themes.themeColors

@Composable
fun BoughtItemQuantity(quantity:Int, modifier: Modifier){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStartPercent = 20))
            .background(MaterialTheme.themeColors.background)
            .padding(bottom = 1.dp, end = 1.dp)
    ) {
        Text(
            text = if (quantity > 1) "x${quantity}" else "",
            modifier = Modifier
                .align(Alignment.Center),
            color = MaterialTheme.themeColors.text

        )
    }
}