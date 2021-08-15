package com.ddmeng.howhiltworks

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentA : Fragment() {
    private val sharedViewModel: ExampleViewModel by activityViewModels()
    private val viewModel: ExampleViewModel by viewModels()
}
