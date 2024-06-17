package com.task.calculadoradeimc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.task.calculadoradeimc.databinding.FragmentFormIMCBinding
import com.task.calculadoradeimc.databinding.FragmentInformationsBinding


class InformationsFragment : Fragment() {

    private var _binding: FragmentInformationsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel:SharedViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentInformationsBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showInformations()

    }

    @SuppressLint("DefaultLocale")
    private fun showInformations(){

        sharedViewModel.dataInformations.observe(viewLifecycleOwner) { data ->
            binding.nome.text = data.nome
            binding.idade.text = data.idade
            binding.altura.text = data.altura
            binding.peso.text = data.peso
            binding.resultImc.text = imcInformation(data.imc)


            val formattedImc = String.format("%.2f", data.imc)

            binding.resultImcNumber.text = formattedImc

        }
    }

    private fun imcInformation(imc: Double) : String{
        val result = imc


        return when{

            result <= 18.5 -> "Muito Magro"
            result <= 24.9 -> "Normal"
            result <= 29.9 -> "Sobrepeso"
            result <= 34.9 -> "Obeso Grau 1"
            result <= 39.9 -> "Obeso Grau 2"
            else -> "Obeso Grau 3 ou Mórbido"
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}