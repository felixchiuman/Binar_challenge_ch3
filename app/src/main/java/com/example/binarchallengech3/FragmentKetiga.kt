package com.example.binarchallengech3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.binarchallengech3.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {

    private var _binding: FragmentKetigaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKetigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aName = arguments?.getString(FragmentKedua.EXTRA_NAME)
        val bName = FragmentKetigaArgs.fromBundle(arguments as Bundle).name
        val aLength = FragmentKetigaArgs.fromBundle(arguments as Bundle).length
        val aWidth = FragmentKetigaArgs.fromBundle(arguments as Bundle).width
        val aHeight = FragmentKetigaArgs.fromBundle(arguments as Bundle).height
        val aVol = FragmentKetigaArgs.fromBundle(arguments as Bundle).vol

        binding.btnToFragment4.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentKetiga_to_fragmentKeempat)
        }

        if (aName != null){
            binding.tvName.text = "Nama Anda : $aName"
        }
        else {
            binding.tvName.text = "$bName"
            binding.tvLength.text = "Panjang : $aLength"
            binding.tvWidth.text = "Lebar : $aWidth"
            binding.tvHeight.text = "Tinggi : $aHeight"
            binding.tvVol.text = "Volume : $aVol"
            binding.btnToFragment4.visibility = View.GONE}
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}