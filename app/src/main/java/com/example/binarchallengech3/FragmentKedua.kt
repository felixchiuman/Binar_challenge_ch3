package com.example.binarchallengech3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.binarchallengech3.databinding.FragmentKeduaBinding

class FragmentKedua : Fragment() {
    var _binding: FragmentKeduaBinding? = null
    val binding get() = _binding!!

    companion object{
        val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKeduaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToFragment3.setOnClickListener {
            if (binding.etName.text.isNotEmpty()){
            val mBundle = Bundle()
            val name = binding.etName.text.toString()
            mBundle.putString(EXTRA_NAME, name)
            it.findNavController().navigate(R.id.action_fragmentKedua_to_fragmentKetiga, mBundle)
            }else{
                Toast.makeText(requireContext(), "Ada Kolom Yang Kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}