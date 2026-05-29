package dev.serge.skincare.main.tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.serge.skincare.R
import dev.serge.skincare.databinding.FragmentTrackerBinding
import java.time.LocalDate
import java.time.YearMonth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tracker.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tracker : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentTrackerBinding

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
        binding = FragmentTrackerBinding.inflate(layoutInflater)
        val root = binding.root
        return root
    }

//    private fun updateCalendar() {
//
//        binding.currentMonth.text =
//            getCurrentMonth(currentMonth)
//
//        adapter?.updateList(
//            getCalendarDays(currentMonth)
//        )
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tracker.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tracker().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getCalendarDays(currentMonth: YearMonth): MutableList<CalendarDay> {

        val items = mutableListOf<CalendarDay>()

        val firstDate = currentMonth.atDay(1)

        val daysInMonth =
            currentMonth.lengthOfMonth()

        val firstDayOfWeek =
            firstDate.dayOfWeek.value % 7

        repeat(firstDayOfWeek) {

            items.add(
                CalendarDay(null)
            )
        }

        for (date in 1..daysInMonth) {

            items.add(
                CalendarDay(
                    date = date,
                    isSelected = date == LocalDate.now().dayOfMonth
                )
            )
        }

        return items
    }

    fun getCurrentMonth(currentMonth: YearMonth): String {

        val month =
            currentMonth.month.name
                .lowercase()
                .replaceFirstChar {
                    it.uppercase()
                }

        return month
    }
}