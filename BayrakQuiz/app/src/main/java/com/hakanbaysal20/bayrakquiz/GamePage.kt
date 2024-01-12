package com.hakanbaysal20.bayrakquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hakanbaysal20.bayrakquiz.databinding.FragmentGamePageBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class GamePage : Fragment() {
    private lateinit var binding:FragmentGamePageBinding
    private lateinit var questions:ArrayList<Bayraklar>
    private lateinit var incorrectOptions:ArrayList<String>
    private lateinit var correctOption:Bayraklar
    private lateinit var options:HashSet<String>
    private lateinit var vba:DatabaseAccess

    private var questioncounter = 0
    private var trueCounter = 0
    private var falseCounter = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamePageBinding.inflate(inflater,container,false)
        vba = DatabaseAccess(requireContext())
        questions = Bayraklardao().getFlagByLimit(vba)
        uploadQuestion()
        binding.optionA.setOnClickListener {
            if (correctOption.bayrak_ad == binding.optionA.text){
                trueCounter++
                binding.textTrue.text = "Doğru:$trueCounter"

            }else{
                falseCounter++
                binding.textFalse.text = "Yanlış:$falseCounter"
            }
            questionCounterControl(it)
        }
        binding.optionB.setOnClickListener {
            if (correctOption.bayrak_ad == binding.optionB.text){
                trueCounter++
                binding.textTrue.text = "Doğru:$trueCounter"
            }else{
                falseCounter++
                binding.textFalse.text = "Yanlış:$falseCounter"

            }
            questionCounterControl(it)
        }
        binding.optionC.setOnClickListener {
            if (correctOption.bayrak_ad == binding.optionC.text){
                trueCounter++
                binding.textTrue.text = "Doğru:$trueCounter"

            }else{
                falseCounter++
                binding.textFalse.text = "Yanlış:$falseCounter"

            }
            questionCounterControl(it)
        }
        binding.optionD.setOnClickListener {
            if (correctOption.bayrak_ad == binding.optionD.text){
                trueCounter++
                binding.textTrue.text = "Doğru:$trueCounter"

            }else{
                falseCounter++
                binding.textFalse.text = "Yanlış:$falseCounter"

            }
            questionCounterControl(it)
        }
        return binding.root
    }
    fun uploadQuestion() {
        binding.textView.text = "${questioncounter + 1}. Soru"
        correctOption = questions.get(questioncounter)
        binding.imageView.setImageResource(requireContext().resources.getIdentifier(correctOption.bayrak_resim,"drawable",requireContext().packageName))
        incorrectOptions = Bayraklardao().getRandomFlagName(vba,correctOption.bayrak_id)
        options = HashSet()
        options.add(correctOption.bayrak_ad)
        for (i in incorrectOptions){
            options.add(i)
        }
        binding.optionA.text = options.elementAt(0)
        binding.optionB.text = options.elementAt(1)
        binding.optionC.text = options.elementAt(2)
        binding.optionD.text = options.elementAt(3)
    }
    fun questionCounterControl(view: View) {
        questioncounter ++
        if (questioncounter != 5){
            uploadQuestion()
        }else{
            val nav = GamePageDirections.actionGamePageToResultPage(trueCounter,falseCounter)
            Navigation.findNavController(view).navigate(nav)

        }
    }


}