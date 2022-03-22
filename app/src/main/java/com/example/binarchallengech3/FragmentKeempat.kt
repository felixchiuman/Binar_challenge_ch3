package com.example.binarchallengech3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.binarchallengech3.databinding.FragmentKeempatBinding


class FragmentKeempat : Fragment() {
    private var _binding : FragmentKeempatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeempatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackFragment3.setOnClickListener {
            if (binding.etLength.text.isNullOrEmpty() || binding.etWidth.text.isNullOrEmpty() || binding.etHeight.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Ada Kolom Yang Kosong",Toast.LENGTH_SHORT).show()
            }
            else{
                val length = binding.etLength.text.toString().toDouble()
                val width = binding.etWidth.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()

                binding.tvVol.text = (length*width*height).toString()

                val actionToFragmentKetiga =
                    FragmentKeempatDirections.actionFragmentKeempatToFragmentKetiga(
                        binding.tvName.text.toString(),
                        binding.etLength.text.toString(),
                        binding.etWidth.text.toString(),
                        binding.etHeight.text.toString(),
                        binding.tvVol.text.toString())
                    it.findNavController().navigate(actionToFragmentKetiga)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

