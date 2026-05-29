package dev.serge.skincare.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.serge.skincare.R
import dev.serge.skincare.databinding.FragmentHomeMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeMain.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeMain : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMainBinding.inflate(layoutInflater)
        val root = binding.root
        val dates = listOf(
            Calendar("Sat","7"),
            Calendar("Sun","8"),
            Calendar("Mon","9"),
            Calendar("Tue","10"),
            Calendar("Wed","11"),
            Calendar("Thu","12"),
            Calendar("Fri","13"),
            Calendar("Sat","14")
        )

        binding.dateRecyclerView.layoutManager =
            LinearLayoutManager(
                requireContext(),
                RecyclerView.HORIZONTAL,
                false
            )

        val dateAdapter = CalendarAdapter(dates)
        binding.dateRecyclerView.adapter = dateAdapter

        val skin = listOf(
            SkinCondition("Acne",85,"High"),
            SkinCondition("Oily",70,"Low"),
            SkinCondition("Wrinkles",90,"High"),
            SkinCondition("Dry",65,"High")
        )

        val skinAdapter = SkinConditionAdapter(skin)
        binding.skinConditionRecycler.layoutManager =
            GridLayoutManager(requireContext(),2)
        binding.skinConditionRecycler.adapter = skinAdapter

        val dailyRoutineList = listOf(
            DailyRoutine(R.drawable.hand_soap,"Moisturizer","Sunon skin",100),
            DailyRoutine(R.drawable.hand_soap,"Lotion","Sunscreen",80),
            DailyRoutine(R.drawable.hand_soap,"Moisturizer","Skin moisturizer",45)
        )
        val dailyRoutineAdapter = DailyRoutineAdapter(dailyRoutineList)
        binding.dailyRoutineRecycler.layoutManager =
            GridLayoutManager(requireContext(),1)
        binding.dailyRoutineRecycler.adapter = dailyRoutineAdapter
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeMain.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeMain().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}