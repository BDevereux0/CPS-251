package com.ebookfrenzy.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.navigationproject.databinding.FragmentDisplayImgBinding
import java.net.URI

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayImgFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayImgFragment : Fragment() {
    private var _binding: FragmentDisplayImgBinding? = null
    private val binding get () = _binding!!


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    interface OnFragmentInteractionListener{
        fun onFragmentInteraction(uri: URI)
    }

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
        // Inflate the layout for this fragment
        _binding = FragmentDisplayImgBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        arguments?.let{
            val args = DisplayImgFragmentArgs.fromBundle(it)
            binding.outputTextView.text = args.imageNumberActionArgument

            if (args.imageNumberActionArgument.contains("Image 1")) {
                binding.outputImageView.setImageResource(R.drawable.android_image_1)
            }else if (args.imageNumberActionArgument.contains("Image 2")){
                binding.outputImageView.setImageResource(R.drawable.android_image_2)
            }else
                binding.outputImageView.setImageResource(R.drawable.android_image_3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DisplayImgFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DisplayImgFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}