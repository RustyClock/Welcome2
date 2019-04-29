package com.rustyclock.welcome2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cards = mutableListOf<Card>()
    var previousCards = arrayOf(0, 1, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parseCards()
        cards.shuffle()

        displayNextCards()

        btn_next.setOnClickListener { displayNextCards() }
        btn_shuffle.setOnClickListener {
            cards.shuffle()
            previousCards = arrayOf(0, 1, 2)
            displayNextCards()
        }
    }

    private fun displayNextCards() {

        if (previousCards[2] == cards.size - 1) {
            Toast.makeText(this, "No cards.", Toast.LENGTH_SHORT).show()
            return
        }

        iv_card1.setImageResource(cards[previousCards[0]].getIcon())
        iv_card2.setImageResource(cards[previousCards[1]].getIcon())
        iv_card3.setImageResource(cards[previousCards[2]].getIcon())

        previousCards[0] += 3
        previousCards[1] += 3
        previousCards[2] += 3

        tv_card1.text = cards[previousCards[0]].value.toString()
        tv_card2.text = cards[previousCards[1]].value.toString()
        tv_card3.text = cards[previousCards[2]].value.toString()
    }

    private fun parseCards() {
        val cardsString = getString(R.string.cards)

        val rows = cardsString.trim().split("\n")

        for (row in rows) {
            val data = row.split(",")
            cards.add(Card(data[0].trim().toInt(), data[1].trim()))
        }
    }
}
