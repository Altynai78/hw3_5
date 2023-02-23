package com.example.hw3_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class  MainFragment:Fragment() {

    private lateinit var binding: FragmentFirstBinding
    var itsWasTen: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.tv0.text = "0"
        itsWasTen = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            if (!itsWasTen) {
                binding.tv0.text = (binding.tv0.text.toString().toInt() + 1).toString()
                if (binding.tv0.text.toString().toInt() == 10) {
                    binding.btn1.text = "-1"
                    itsWasTen = true
                }
            } else {
                binding.tv0.text = (binding.tv0.text.toString()
                    .toInt() - 1).toString()
                if (binding.tv0.text.toString() == "0") {
                    val bundle = Bundle()
                    bundle.putString("Kay", binding.tv0.text.toString())
                    val secondFragment = SecondFragment()
                    secondFragment.arguments = bundle

                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.conteiner, secondFragment)?.addToBackStack(null)?.commit()
                }
            }
        }
    }
}






