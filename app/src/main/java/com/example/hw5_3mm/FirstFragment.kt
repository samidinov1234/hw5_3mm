package com.example.hw5_3mm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw5_3mm.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding:FragmentFirstBinding
    private var counter = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIncrease.setOnClickListener {
            ++counter
            binding.tvResult.text = counter.toString()
            if (binding.tvResult.text.toString() == "10") {
               binding.btnDecrease.visibility = View.VISIBLE
                binding.tvResult.text = counter.toString()
                binding.btnIncrease.visibility = View.GONE
            }
        }

        binding.btnDecrease.setOnClickListener{
            --counter
            if(binding.tvResult.text.toString() == "0"){
            val bundle = Bundle()
                //bundle.putString(RESULT_KEY, binding.tvResult.text.toString())
                val secondFragment = SecondFragment()
               // secondFragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container , secondFragment).addToBackStack(null).commit()
            }
            binding.tvResult.text = counter.toString()
        }
    }
    companion object{
        const val RESULT_KEY = "result_key"
    }
}