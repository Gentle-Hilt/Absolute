package gentle.hilt.data.res.custom_composables

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.themes.themeColors


// Compose Changed AlertDialog, i just recreated what was in the first place without any additional ui construction.
@Composable
fun AlertDialog.Builder.CustomAlertDialog(
    positiveText: String = "",
    negativeText: String = "",
    title: String = "",
    message: String = "",
    onConfirm: () -> Unit,
    onCancel: () -> Unit = {},
) {

    setTitle(title)
    setMessage(message)

    setOnDismissListener { onCancel() }

    setPositiveButton(positiveText) { _, _ ->
        onConfirm()
    }
    setNegativeButton(negativeText) { _, _ ->
        onCancel()
    }

    val rectShapeDrawable = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = 60f
        setColor(MaterialTheme.themeColors.bottomNavigation.toArgb())
    }

    create().apply {
        show()
        val messageDialog = findViewById<TextView>(android.R.id.message)
        messageDialog.setTextColor(MaterialTheme.themeColors.text.toArgb())
        messageDialog.textSize = FontSizes.titlesFont.toFloat()

        val alertTitle = findViewById<TextView>(context.resources.getIdentifier("alertTitle", "id", "android"))
        alertTitle.setTextColor(MaterialTheme.themeColors.text.toArgb())

        window?.setBackgroundDrawable(ColorDrawable(MaterialTheme.themeColors.background.toArgb()))
        window?.setElevation(0f)
        window?.setBackgroundDrawable(rectShapeDrawable)

        getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(MaterialTheme.themeColors.text.toArgb())
        getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(MaterialTheme.themeColors.text.toArgb())
    }
}

