package com.glucozo.android_jetpack.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.glucozo.android_jetpack.databinding.FragmentDataBinding
import com.glucozo.android_jetpack.viewmodel.DataViewModel

class TwoFragment : Fragment() {
    private lateinit var binding: FragmentDataBinding
    private lateinit var viewModel: DataViewModel // instance

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]
        viewModel.number.observe(viewLifecycleOwner){
            binding.tvValue.text = it.toString()
        }
        binding.btn.setOnClickListener {
            viewModel.updateNumber()
        }

        return binding.root


    }
}