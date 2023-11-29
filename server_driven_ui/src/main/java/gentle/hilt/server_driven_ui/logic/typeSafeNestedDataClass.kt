package gentle.hilt.server_driven_ui.logic


inline fun <reified T : Any, reified L : Any> typeSafeNestedDataClass(
    receivedData: Any?,
    defaultData: T,
    nestedData: L
): T {
    val retrievedData = receivedData as? Map<*, *>
    return retrievedData?.let { data ->
        val dataClassConstructor = T::class.constructors.first()

        val constructorArguments = dataClassConstructor.parameters.map { parameter ->
            val retrievedValue = data[parameter.name]
            val defaultValue = getDefaultValue(defaultData, parameter.name)

         /*   Timber.d("retrieved ${retrievedValue}")*/
            /*Timber.d("default $defaultValue")*/

            val valueToUse = if (retrievedValue is List<*>) {
                val listValue = retrievedValue.mapNotNull { data ->
                    typeSafeDataClass(
                        receivedData = data,
                        defaultData = nestedData
                    )
                }
                listValue
            } else {
                if (retrievedValue != null && retrievedValue::class == parameter.type.classifier) {
                    retrievedValue
                } else {
                    defaultValue
                }
            }
            valueToUse
        }.toTypedArray()

        dataClassConstructor.call(*constructorArguments)
    } ?: defaultData
}


