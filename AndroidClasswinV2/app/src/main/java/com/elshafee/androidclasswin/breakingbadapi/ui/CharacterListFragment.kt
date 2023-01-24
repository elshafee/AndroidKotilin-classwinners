package com.elshafee.androidclasswin.breakingbadapi.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.elshafee.androidclasswin.R
import com.elshafee.androidclasswin.breakingbadapi.BreakingBadApllication
import com.elshafee.androidclasswin.breakingbadapi.ui.utils.CharacterListAdapter

class CharacterListFragment : Fragment() {
    private val characterListViewModel: CharacterListViewModel by viewModels {
        CharacterListViewModelFactory((requireActivity().application as BreakingBadApllication).characterRepository)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_character_list_fragment,container,false)
    }
@Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rvCharacterList = requireActivity().findViewById<RecyclerView>(R.id.rvCharacterList)
        val adapter = CharacterListAdapter{bbcharacter ->
            if(bbcharacter.img != null ){
              CharacterListFragmentDirections.showCharacterImageFragment(
                  bbcharacter.img
              )
            }
        }
        rvCharacterList.adapter = adapter
        characterListViewModel.characterList.observe(viewLifecycleOwner,{breakingbadCharacter ->
            adapter.submitList(breakingbadCharacter)
        })

        val refreshLayout =requireActivity().findViewById<SwipeRefreshLayout>(R.id.refreshLayout)

        refreshLayout.setOnRefreshListener {
            characterListViewModel.refreshDataFromREpository()
            Toast.makeText(requireContext(), "Data Updated", Toast.LENGTH_SHORT).show()
            refreshLayout.isRefreshing = false
        }
    }


}