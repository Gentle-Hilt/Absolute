package gentle.hilt.server_driven_ui.logic



inline fun <reified T : Any> typeSafeDataClass(receivedData: Any?, defaultData: T): T {
    val retrievedData = receivedData as? Map<*, *>
    return retrievedData?.let { data ->
        val dataClassConstructor = T::class.constructors.first()

        val constructorArguments = dataClassConstructor.parameters.map { parameter ->
            val retrievedValue = data[parameter.name]
            val defaultValue = getDefaultValue(defaultData, parameter.name)

            val valueToUse = if (retrievedValue != null) {
                when {
                    retrievedValue is Long && parameter.type.classifier == Int::class -> {
                        retrievedValue.toInt()
                    }
                    retrievedValue::class == parameter.type.classifier -> retrievedValue
                    else -> defaultValue
                }
            } else {
                defaultValue
            }

            valueToUse
        }.toTypedArray()

        dataClassConstructor.call(*constructorArguments)
    } ?: defaultData
}