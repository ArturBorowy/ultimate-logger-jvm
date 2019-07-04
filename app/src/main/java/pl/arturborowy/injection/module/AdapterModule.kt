package pl.arturborowy.injection.module

import dagger.Module
import dagger.Provides
import pl.arturborowy.ui.main.adapter.FilmsAdapter
import pl.arturborowy.util.ViewInflater

@Module
class AdapterModule {

    @Provides
    internal fun provideFilmsAdapter(viewInflater: ViewInflater) =
            FilmsAdapter(viewInflater)
}