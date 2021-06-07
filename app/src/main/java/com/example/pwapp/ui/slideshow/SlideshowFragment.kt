package com.example.pwapp.ui.slideshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.pwapp.R
import com.example.pwapp.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

  private lateinit var slideshowViewModel: SlideshowViewModel
private var _binding: FragmentSlideshowBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

    _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
    val root: View = binding.root

    //val textView: TextView = binding.textSlideshow
    slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
      //textView.text = it
    })
    binding.buttonSamurai.setOnClickListener { view ->
      view.findNavController().navigate(R.id.slideshow_to_samurai)
    }
    binding.buttonGoodbye.setOnClickListener { view ->
      view.findNavController().navigate(R.id.slideshow_to_goodbye)
    }
    binding.buttonStolen.setOnClickListener { view ->
      view.findNavController().navigate(R.id.slideshow_to_stolen)
    }
    return root
  }

  override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}