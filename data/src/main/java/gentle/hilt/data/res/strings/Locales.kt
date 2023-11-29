package gentle.hilt.data.res.strings

import gentle.hilt.data.res.strings.english_strings.EnglishStrings
import gentle.hilt.data.res.strings.russian_strings.RussianStrings


// The languageTag must be an IETF BCP47(https://en.wikipedia.org/wiki/IETF_language_tag)
// compliant language tag (https://developer.android.com/guide/topics/resources/providing-resources#LocaleQualifier).
object Locales {
    const val EN = "en"
    const val RU = "ru"
}


val allLocales = mapOf(
    Locales.EN to EnglishStrings,
    Locales.RU to RussianStrings
)