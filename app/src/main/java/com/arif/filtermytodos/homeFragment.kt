package com.arif.filtermytodos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.arif.filtermytodos.adapter.UserAdapter
import com.arif.filtermytodos.databinding.FragmentHomeBinding
import com.arif.filtermytodos.view_model.TodosFilterViewModel

class homeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private val quotesViewModel:TodosFilterViewModel by activityViewModels()
    val nameList = ArrayList<String>()
    val idList = ArrayList<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        quotesViewModel.fetchData()
        quotesViewModel.userLiveData.observe(viewLifecycleOwner){
            for ( i in 0 until it.size){
                nameList.add(it[i].name)
                idList.add(it[i].id)
            }
            userSpinner()

        }

        return binding.root
    }

    private fun userSpinner() {
        val usernameAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, nameList )
        binding.spinner.setAdapter(usernameAdapter)

        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                /*var t = p0?.getItemAtPosition(p2).toString()*/
                var namePosition = nameList[p2]
                var idPosition = idList[p2]
                todoList(idPosition)
              /*  Toast.makeText(requireActivity(), "$namePosition", Toast.LENGTH_SHORT).show()
                Log.d("nameP", "$namePosition")
                Log.d("nameP", "$idPosition")
*/
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun todoList(idPosition: Int) {
        quotesViewModel.fetch(idPosition)
        quotesViewModel.todoLiveData.observe(viewLifecycleOwner){
          /*  Log.d("idd", "todoList: $it")*/
            val adapter = UserAdapter()
            binding.userRV.layoutManager = GridLayoutManager(requireActivity(),1)
            binding.userRV.adapter = adapter
            adapter.submitList(it)

        }

    }


}