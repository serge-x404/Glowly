@file:JvmName("OnBoardingKt")

package dev.serge.skincare.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.serge.skincare.R
import dev.serge.skincare.databinding.ActivitySplashBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: ActivitySplashBinding

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
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val root = binding.root

        val onBoardingPagerData = listOf(
            OnBoardingDataClass(
                R.drawable.onboarding1,
                "Your skin loves consistency—time for your morning routine!",
                "Next"
            ),
            OnBoardingDataClass(
                R.drawable.onboarding2,
                "Skin reset time! Wash off makeup and apply your night serum",
                "Next"
            ),
            OnBoardingDataClass(
                R.drawable.onboarding3,
                "“Routine streak active! Don’t break it—your skin’s loving this",
                "Continue"
            )
        )

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OnBoarding1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}