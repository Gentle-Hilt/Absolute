package gentle.hilt.cart.screen

import android.app.AlertDialog
import android.content.Context
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import gentle.hilt.cart.CartScreenVM
import gentle.hilt.data.res.custom_composables.CustomAlertDialog
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors
import org.koin.androidx.compose.getViewModel

@Composable
fun ClearCartButton(
    modifier: Modifier,
    viewModel: CartScreenVM = getViewModel(),
) {
    val context: Context = LocalContext.current
    var openDialog by remember { mutableStateOf(false) }

    Button(
        onClick = {
            openDialog = true
        },
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.icons),
        modifier = modifier

    ) {
        Text(text = strings.clear, color = MaterialTheme.themeColors.contrastText)
    }

    if (openDialog) {
        AlertDialog.Builder(context).CustomAlertDialog(
            positiveText = strings.yes,
            negativeText = strings.cancel,
            title = strings.warning,
            message = strings.clear_cart_question,
            onConfirm = {
                viewModel.clearCart()
                openDialog = false
            },
            onCancel = {
                openDialog = false
            },
        )
    }
}


