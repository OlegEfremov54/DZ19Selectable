package com.example.dz19selectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dz19selectable.ui.theme.DZ19SelectableTheme

class QuestionsActivity :  ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DZ19SelectableTheme {


                val currentQuestionIndex = rememberSaveable {
                    mutableIntStateOf(0)
                }

                val countCorrectAnswers = rememberSaveable {
                    mutableIntStateOf(0)
                }

                val questionList = listOf(
                    QuestionModel(
                        text = "Какие полководцы жили в 13 веке? " +
                                "Выберите все подходящие варианты.",
                        answers =
                        AnswerModel(
                            listOf(
                                "Александр Невский",
                                "Субедей",
                                "Михаил Палеолог",
                                "Атила",
                                "Даниил Галицкий"
                            ),
                            listOf(0, 1, 4)
                        ),
                        onAnswerClickListener = {
                            if (it) countCorrectAnswers.intValue++
                            currentQuestionIndex.intValue++
                        }
                    ),

                    QuestionModel(
                        text = "Посмотрите на следующие изображения и выберите Тамплиера",
                        answers =
                        AnswerModel(
                            listOf(
                                painterResource(R.drawable.konung4),
                                painterResource(R.drawable.konung1),
                                painterResource(R.drawable.konung2),
                            ),
                            listOf(0),
                            answersDescriptionList = listOf(
                                "Рыцарь 1",
                                "Рыцарь 2",
                                "Рыцарь 3"
                            )
                        ),
                        onAnswerClickListener = {
                            if (it) countCorrectAnswers.intValue++
                            currentQuestionIndex.intValue++
                        }
                    ),

                    QuestionModel(
                        text = "Вспомните дату ледового побоища",
                        answers =
                        AnswerModel(
                            listOf(
                                "1240",
                                "1242",
                                "1223",
                                "1380"
                            ),
                            listOf(1)
                        ),
                        onAnswerClickListener = {
                            if (it) countCorrectAnswers.intValue++

                            val intent = Intent(this@QuestionsActivity, FinishActivity::class.java)
                            intent.putExtra("points", countCorrectAnswers.intValue)
                            startActivity(intent)
                            finish()
                        }
                    )
                )

                questionList[currentQuestionIndex.intValue].Question()

            }
        }
    }
}