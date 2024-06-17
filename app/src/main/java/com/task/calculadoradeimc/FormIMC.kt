package com.task.calculadoradeimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.task.calculadoradeimc.databinding.FragmentFormIMCBinding



class FormIMC : Fragment() {

    private var _binding: FragmentFormIMCBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,

    ): View {

        _binding = FragmentFormIMCBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

    }

    private fun initListeners(){
        binding.btnSave.setOnClickListener{
            informations()

        }
    }

    private fun informations(){

        val nome = binding.edtNome.text.toString().trim()
        val idade = binding.edtIdade.text.toString()
        val altura = binding.edtAltura.text.toString()
        val peso = binding.edtPeso.text.toString()


        if (nome.isNotEmpty()){
            if (idade.isNotEmpty()){
                if (altura.isNotEmpty()){
                    if (peso.isNotEmpty()){


                        val imc =  calculo_Imc(altura,peso)

                        // Armazenar dados no ViewModel compartilhado
                        val dataInformations = Data_Informations(nome,idade,altura,peso,imc)
                        sharedViewModel.setDataInformations(dataInformations)


                        findNavController().navigate(R.id.action_formIMC_to_informationsFragment)

                    }else{
                        Toast.makeText(requireContext(), "Por favor digite seu peso", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(requireContext(), "Por favor digite sua altura", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(), "Por favor Digite sua idade", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Por favor Digite seu nome", Toast.LENGTH_SHORT).show()
        }


    }


    private fun calculo_Imc(altura:String, peso:String) : Double {

        val altura1 = altura.toDouble()
        val peso1 = peso.toDouble()
        val imc = peso1 / (altura1*altura1)

       return imc


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}