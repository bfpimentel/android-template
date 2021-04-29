package dev.pimentel.template.presentation.examples

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.pimentel.template.R
import dev.pimentel.template.databinding.ExamplesFragmentBinding
import dev.pimentel.template.presentation.examples.data.ExamplesIntention
import dev.pimentel.template.shared.extensions.watch
import dev.pimentel.template.shared.mvi.handleEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExamplesFragment : DialogFragment(R.layout.examples_fragment) {

    private lateinit var binding: ExamplesFragmentBinding
    private val viewModel: ExamplesContract.ViewModel by viewModels<ExamplesViewModel>()

    @Inject
    lateinit var adapterFactory: ExamplesAdapter.Factory
    private lateinit var examplesAdapter: ExamplesAdapter

    override fun getTheme(): Int = R.style.Theme_CountersExamples

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ExamplesFragmentBinding.bind(view)

        bindAdapter()
        bindOutputs()
        bindInputs()
    }

    private fun bindAdapter() {
        examplesAdapter = adapterFactory.create { name ->
            viewModel.publish(ExamplesIntention.SelectExample(name))
        }

        binding.examples.let { examples ->
            examples.adapter = examplesAdapter
            examples.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun bindOutputs() {
        watch(viewModel.state) { state ->
            state.examplesEvent.handleEvent(examplesAdapter::submitList)
        }
    }

    private fun bindInputs() {
        binding.toolbar.setNavigationOnClickListener { viewModel.publish(ExamplesIntention.Close) }

        viewModel.publish(ExamplesIntention.GetExamples)
    }
}
