package com.example.terms.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.di.Dependencies
import com.example.provider.Provider
import com.example.terms.list.databinding.ListFragmentBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListTermsFragment : Fragment(R.layout.list_fragment) {

    private val dependencies: Dependencies?
        get() = (activity as? Provider<Dependencies>)?.value

    private val listTermsUseCase: ListTermsUseCase?
        get() = dependencies?.listTermsUseCase as? ListTermsUseCase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ListFragmentBinding.bind(view).apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            listTermsUseCase?.invoke()
                ?.onEach { list -> recyclerView.adapter = TermsAdapter(list.map { it.value }) }
                ?.launchIn(lifecycleScope)
        }
    }
}
