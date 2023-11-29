package gentle.hilt.menu.screen.menu_item_dialog.references

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors

@Composable
fun ConfirmButtonDialog(onConfirm: () -> Unit, modifier: Modifier) {
    val context = LocalContext.current
    val addedToTheCart = strings.added_to_the_cart

    Button(
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.icons),
        onClick = {
            onConfirm()
            Toast.makeText(context, addedToTheCart, Toast.LENGTH_SHORT).show()
        },
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = strings.add_to_cart,
            textAlign = TextAlign.Center,
            color = MaterialTheme.themeColors.contrastText,
            fontSize = 20.sp
        )
    }
}