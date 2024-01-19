package com.glucozo.android_jetpack.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.glucozo.android_jetpack.databinding.FragmentDataBinding
import com.glucozo.android_jetpack.view.MainActivity
import com.glucozo.android_jetpack.viewmodel.DataViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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
        viewModel.startActivity.observe(viewLifecycleOwner) {
            if (it) {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }
        }

        viewModel.showToast.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireContext(), "toast context", Toast.LENGTH_LONG).show()
            }
        }
//        lifecycleScope.launch {
//            viewModel.toastChannel.collectLatest {
//                Toast.makeText(requireContext(), "toast context", Toast.LENGTH_LONG).show()
//            }
//        }

        binding.btn.setOnClickListener {
            viewModel.updateNumber()
        }

        binding.startActivty.setOnClickListener {
            viewModel.startActivity()
        }
        binding.btnToastShow.setOnClickListener {
            viewModel.showToast()
        }

        return binding.root
    }
}