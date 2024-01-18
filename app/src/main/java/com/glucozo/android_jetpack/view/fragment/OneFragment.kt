package com.glucozo.android_jetpack.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.glucozo.android_jetpack.databinding.FragmentDataBinding
import com.glucozo.android_jetpack.viewmodel.DataViewModel

class OneFragment : Fragment() {
    private lateinit var binding: FragmentDataBinding
//    private val viewModel : DataViewModel by viewModels() //fragment context
//    private val viewModel: DataViewModel by activityViewModels()
    private lateinit var viewModel: DataViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]
        viewModel.number.observe(viewLifecycleOwner) {
            binding.tvValue.text = it.toString()
        }
        binding.btn.setOnClickListener {
            viewModel.updateNumber()
        }


        return binding.root
    }
}