package gentle.hilt.cart.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import gentle.hilt.cart.CartScreenVM
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors
import org.koin.androidx.compose.getViewModel

@Composable
fun PayCartButton(
    price: Long?,
    modifier: Modifier,
    viewModel: CartScreenVM = getViewModel(),
    context: Context = LocalContext.current,
    payment:String = strings.payment
) {

    Button(
        onClick = {
            if (price != 0L) {
                Toast.makeText(context, payment, Toast.LENGTH_SHORT).show()
                viewModel.proceedPayment()
            }
        },
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.icons), modifier = modifier
    ) {
        Text(text = if (price != 0L) "${strings.pay} ${price}$" else strings.emptyCart, color = MaterialTheme.themeColors.contrastText)
    }
}