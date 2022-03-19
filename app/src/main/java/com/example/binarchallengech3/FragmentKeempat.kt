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
        val aName = arguments?.getString(FragmentKetiga.EXTA_NAME)

        binding.tvName.text = "$aName"

        binding.btnBackFragment3.setOnClickListener {
            if (binding.etAddress.text.isNullOrEmpty() || binding.etAge.text.isNullOrEmpty() || binding.etJob.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Ada Kolom Yang Kosong",Toast.LENGTH_SHORT).show()
            }
            else{
                val actionToFragmentKetiga =
                    FragmentKeempatDirections.actionFragmentKeempatToFragmentKetiga(
                        binding.tvName.text.toString(),
                        binding.etAge.text.toString(),
                        binding.etAddress.text.toString(),
                        binding.etJob.text.toString())
                    it.findNavController().navigate(actionToFragmentKetiga)
            }
        }
    }
}