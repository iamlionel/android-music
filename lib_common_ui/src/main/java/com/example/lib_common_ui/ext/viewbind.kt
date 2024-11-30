package com.example.lib_common_ui.ext

import android.view.LayoutInflater
import android.view.View
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <VB : ViewBinding> ComponentActivity.binding(inflater: (LayoutInflater) -> VB) = lazy {
    inflater(layoutInflater).also { binding ->
        setContentView(binding.root)
    }
}

fun <VB : ViewBinding> Fragment.binding(bind: (View) -> VB) = FragmentBindingDelegate(bind)

class FragmentBindingDelegate<VB : ViewBinding>(
    private val bind: (View) -> VB
) : ReadOnlyProperty<Fragment, VB> {
    private var binding: VB? = null
    private var lifecycleObserverAdded = false

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB {
        binding?.let { return it }

        binding = bind(thisRef.requireView())

        if (!lifecycleObserverAdded) {
            thisRef.viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    binding = null
                }
            })
            lifecycleObserverAdded = true
        }
        return binding!!
    }
}