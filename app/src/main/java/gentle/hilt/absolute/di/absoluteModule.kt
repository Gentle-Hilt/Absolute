package gentle.hilt.absolute.di

import gentle.hilt.data.di.dataModule
import org.koin.dsl.module

val absoluteModule = module {
    includes(dataModule)
}
