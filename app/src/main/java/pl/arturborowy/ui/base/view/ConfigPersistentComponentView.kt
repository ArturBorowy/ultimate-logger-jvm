package pl.arturborowy.ui.base.view

import android.content.Context
import android.os.Bundle
import androidx.collection.LongSparseArray
import pl.arturborowy.App
import pl.arturborowy.injection.component.ConfigPersistentComponent
import pl.arturborowy.injection.component.DaggerConfigPersistentComponent
import timber.log.Timber
import java.util.concurrent.atomic.AtomicLong

interface ConfigPersistentComponentView {

    companion object {
        private const val VIEW_ID_BUNDLE_KEY = "VIEW_ID_BUNDLE_KEY"

        private val configPersistentComponentsArray = LongSparseArray<ConfigPersistentComponent>()
        private val nextId = AtomicLong(0)
    }

    var viewId: Long

    fun getConfigPersistentComponent(context: Context?, savedInstanceState: Bundle?):
            ConfigPersistentComponent? {
        viewId = savedInstanceState?.getLong(VIEW_ID_BUNDLE_KEY) ?: nextId.getAndIncrement()

        val configPersistentComponent: ConfigPersistentComponent?

        if (configPersistentComponentsArray.get(viewId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", viewId)
            configPersistentComponent = buildConfigPersistentComponent(context)
            configPersistentComponentsArray.put(viewId, configPersistentComponent)
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", viewId)
            configPersistentComponent = configPersistentComponentsArray.get(viewId)
        }

        return configPersistentComponent
    }

    private fun buildConfigPersistentComponent(context: Context?) =
            DaggerConfigPersistentComponent.builder()
                    .appComponent((context?.applicationContext as App).component)
                    .build()

    fun removeConfigPersistentComponentIfNeedTo(isChangingConfigurations: Boolean) {
        if (!isChangingConfigurations) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", viewId)
            configPersistentComponentsArray.remove(viewId)
        }
    }

    fun saveViewId(bundle: Bundle) = bundle.putLong(VIEW_ID_BUNDLE_KEY, viewId)
}