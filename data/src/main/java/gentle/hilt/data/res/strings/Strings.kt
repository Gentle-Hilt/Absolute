package gentle.hilt.data.res.strings

import androidx.compose.runtime.staticCompositionLocalOf
import gentle.hilt.data.res.strings.english_strings.EnglishStrings

data class Strings(
    val appearance: String,
    val system:String,
    val themes: String,
    val signIn: String,
    val logOut: String,
    val balance:String,
    val defaultName:String,
    val points:String,
    val auto:String,
    val turnedOff:String,
    val turnedOn:String,
    val darkMode:String,
    val turnOn:String,
    val turnOff:String,
    val systemAuto:String,
    val cancel:String,
    val silentNotifications:String,
    val payment:String,
    val pay:String,
    val emptyCart:String,
    val clear:String,
    val yes:String,
    val warning:String,
    val clear_cart_question:String,
    val reorder:String,
    val added_to_the_cart:String,
    val orderFrom:String,
    val cost:String,
    val add_to_cart:String,
    val description_dismiss_dialog:String,
    val content_description_item_from_menu:String,
    val ok:String,
    val notifications_permissions_ask_message:String,
    val home:String,
    val history:String,
    val cart:String,
    val profile:String,
)

val LocalStrings = staticCompositionLocalOf { EnglishStrings }
