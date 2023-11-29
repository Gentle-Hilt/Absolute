package gentle.hilt.server_driven_ui.logic

import kotlin.reflect.full.declaredMemberProperties

fun <T : Any> getDefaultValue(dataClass: T, propertyName: String?): Any? {
    val property = dataClass::class.declaredMemberProperties.find { property ->
        property.name == propertyName
    }
    return property?.getter?.call(dataClass)
}
