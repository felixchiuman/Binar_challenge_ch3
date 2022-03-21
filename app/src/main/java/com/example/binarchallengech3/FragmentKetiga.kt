package com.example.binarchallengech3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.binarchallengech3.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {

    private var _binding: FragmentKetigaBinding? = null
    private val binding get() = _binding!!

    companion object{
        val EXTA_NAME = "EXTRA_NAME"
    }

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
        val aAge = FragmentKetigaArgs.fromBundle(arguments as Bundle).age
        val aOddEven = FragmentKetigaArgs.fromBundle(arguments as Bundle).oddEven
        val aAddress = FragmentKetigaArgs.fromBundle(arguments as Bundle).address
        val aJob = FragmentKetigaArgs.fromBundle(arguments as Bundle).job

        binding.btnToFragment4.setOnClickListener {
            val mBundle = Bundle()
            val name = binding.tvName.text.toString()
            mBundle.putString(EXTA_NAME, name)
            it.findNavController().navigate(R.id.action_fragmentKetiga_to_fragmentKeempat, mBundle)
        }

        binding.tvName.text = "Nama Anda : $aName"
        if (aName == null){
        binding.tvName.text = "$bName"
        binding.tvUsia.text = "Usia Anda : $aAge"
        binding.tvGenapGanjil.text = "Bernilai : $aOddEven"
        binding.tvAlamat.text = "Alamat Anda : $aAddress"
        binding.tvPekerjaan.text = "Pekerjaan Anda : $aJob"}
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}