package com.example.chingdui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.abc)
        val edname = findViewById<EditText> (R.id.ed_name)
        val tvtext = findViewById<TextView> (R.id.tv_text)
        val tvname = findViewById<TextView> (R.id.tv_name)
        val tvwinner = findViewById<TextView> (R.id.tv_winner)
        val tvmmora = findViewById<TextView> (R.id.tv_mmora)
        val tvcmora = findViewById<TextView> (R.id.tv_cmora)
        val btnscissor = findViewById<RadioButton> (R.id.btn_scissor)
        val btnstone = findViewById<RadioButton> (R.id.btn_stone)
        val btnpaper = findViewById<RadioButton> (R.id.btn_paper)
        val btnmora = findViewById<Button> (R.id.btn_mora)
        btnmora.setOnClickListener {
            if (edname.length() < 1)
                tvtext.text="請輸入玩家姓名";
                else {
                    //顯示使用者姓名、出拳
                    val name1 = edname.text.toString()
                    tvname.text="名字\n$name1";
                    if (btnscissor.isChecked)
                        {
                            tvmmora.text="我方出拳\n剪刀";
                        }
                    else if (btnstone.isChecked)
                        {
                            tvmmora.text="我方出拳\n石頭";
                        }
                    else
                        tvmmora.text="我方出拳\n布";
                    val computer = (Math.random() * 3).toInt();
                    if (computer == 0)
                        {
                            tvcmora.text="電腦出拳\n剪刀";
                        }
                    else if (computer == 1)
                        {
                            tvcmora.text="電腦出拳\n石頭";
                        }
                    else
                        tvcmora.text="電腦出拳\n布";
                    if (btnscissor.isChecked && computer == 2 || btnstone.isChecked && computer == 0 ||
                        btnpaper.isChecked && computer == 1) {
                        val name2 = edname.text.toString()
                        tvwinner.text="勝利者\n$name2";
                        tvtext.text = "恭喜你獲勝了！！！";
                    } else if (btnscissor.isChecked && computer == 1 || btnstone.isChecked && computer == 2 ||
                        btnpaper.isChecked && computer == 0) {
                        tvwinner.text = "勝利者\n電腦";
                        tvtext.text = "可惜，電腦獲勝了！";
                    } else
                        {
                        tvwinner.text = "勝利者\n平手";
                        tvtext.text = "平局，請再試一次！";
                        }
                    }
        }
    }
}