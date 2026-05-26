package dev.serge.skincare.authentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
import dev.serge.skincare.R
import dev.serge.skincare.databinding.FragmentRegisterBinding
import androidx.core.graphics.toColorInt
import dev.serge.skincare.account_setup.AccountSetup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Register.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentRegisterBinding

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
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        val root = binding.root

        val text = "By creating an account, you agree to our Terms and Conditions and Privacy Notice."
        val spannable = SpannableString(text)
        val pink = "#F2B7C0".toColorInt()

        spannable.setSpan(
            ForegroundColorSpan(pink),
            text.indexOf("Terms"),
            text.indexOf("and Conditions") - 1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannable.setSpan(
            ForegroundColorSpan(pink),
            text.indexOf("Privacy"),
            text.length - 1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.termsText.text = spannable
        binding.signInButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.authenticationFragment,
                    Login()
                )
                .addToBackStack(null)
                .commit()
        }
        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.registerButton.setOnClickListener {
            startActivity(Intent(requireContext(), AccountSetup::class.java))
        }
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Register.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Register().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}