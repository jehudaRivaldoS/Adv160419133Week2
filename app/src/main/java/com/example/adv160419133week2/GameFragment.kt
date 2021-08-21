package com.example.adv160419133week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*


class GameFragment : Fragment() {
    var answer = 0
    var point = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null)
        {
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
            val randomNumber1 = (0..999).random()
            val randomNumber2 = (0..999).random()
            txtQuestion.text = "${randomNumber1.toString()} + ${randomNumber2.toString()}"
            answer = randomNumber1.toInt() + randomNumber2.toInt()
        }
        btnAnswer.setOnClickListener {
            val answerUser = txtAnswer.text.toString()
            if(answer.equals(answerUser.toInt()))
            {
                point = point + 1
                txtPoin.text = "Poin: ${point.toString()}"
                val randomNumber1 = (0..999).random()
                val randomNumber2 = (0..999).random()
                txtQuestion.text = "${randomNumber1.toString()} + ${randomNumber2.toString()}"
                answer = randomNumber1.toInt() + randomNumber2.toInt()
                txtAnswer.setText("")
            }
            else
            {
                val action = GameFragmentDirections.actionResultFragment(point.toInt())
                Navigation.findNavController(it).navigate(action)
                txtAnswer.setText("")
            }
        }

    }

    }