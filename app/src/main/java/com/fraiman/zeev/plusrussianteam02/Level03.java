package com.fraiman.zeev.plusrussianteam02;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Level03 extends AppCompatActivity implements View.OnClickListener {

    TextView tv3;
    VideoView vv3;
    char[] letters={'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П',
            'Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
    int[] zvuk={R.raw.bukva_1a,R.raw.bukva_2a,R.raw.bukva_3a,R.raw.bukva_4a,R.raw.bukva_5a,R.raw.bukva_6a,
            R.raw.bukva_7a,R.raw.bukva_8a,R.raw.bukva_9a,R.raw.bukva_10a,R.raw.bukva_11a,R.raw.bukva_12a,
            R.raw.bukva_13a,R.raw.bukva_14a,R.raw.bukva_15a,R.raw.bukva_16a,R.raw.bukva_17a,R.raw.bukva_18a,
            R.raw.bukva_19a,R.raw.bukva_20a,R.raw.bukva_21a,R.raw.bukva_22a,R.raw.bukva_23a,R.raw.bukva_24a,
            R.raw.bukva_25a,R.raw.bukva_26a,R.raw.bukva_27a,R.raw.bukva_28a,R.raw.bukva_29a,R.raw.bukva_30a,R.raw.bukva_31a,
            R.raw.bukva_32a,R.raw.bukva_33a};
    int[] clr={1,2,2,2,2,1,1,2,2,1,1,2,2,2,2,1,2,2,2,2,1,2,2,2,2,2,2,3,1,3,1,1,1};
    int[] c=new int[16];
    char letter;
    ArrayList<Character> now;
    GridLayout GL3;
    Button[] btns=new Button[16];
    Button bGo3;
    String st;
    int countAll=0, countOk=0;
    String s, golos, what="1";
    int path=-1;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level03);

        Intent takeit=getIntent();
        what=takeit.getStringExtra("what");

        vv3=findViewById(R.id.vv3);
        bGo3=findViewById(R.id.bGo3);
        tv3=findViewById(R.id.tv3);
        GL3=findViewById(R.id.GL3);
        for (int i = 0; i < 16; i++) {
            btns[i]=new Button(this);
            btns[i].setText("X");
            btns[i].setTextSize(20);
            btns[i].setOnClickListener(this);
            btns[i].setId(i);
            GL3.addView(btns[i], 160, 160);
        }
        goBuild();
    }

    private void goBuild() {
        if (what.equals("1"))
            path++;
        else
            path=(int)((letters.length-1)*Math.random());
        golos="android.resource://"+getPackageName()+"/"+zvuk[path];
        vv3.setVideoURI(Uri.parse(golos));
        vv3.start();
        //tv1.setText("Path="+path+"  "+letters[path]+"       "+z[path]);
        s=""+letters[path];
        s=s.toUpperCase();
        letter=s.charAt(0);
        now=new ArrayList<>();
        now.add(letter);
        int i=1;
        while (i < 16) {
            int k=(int)((letters.length-1)*Math.random());
            char t=letters[k];
            boolean flag=false;
            for (int j = 0; j <now.size() ; j++) {
                if (t==now.get(j))
                    flag=true;
            }
            if (flag==false)  {
                now.add(t);
                i++;
            }
        }
        Collections.shuffle(now);
        st="";
        for (int k = 0; k < now.size(); k++) {
            btns[k].setText(""+now.get(k));
            st+=now.get(k);
        }
        st+="\n";
        for (int j = 0; j < st.length(); j++) {
            char t=st.charAt(j);
            for (int k = 0; k < letters.length; k++) {
                if (t==letters[k]) {
                    c[j]=clr[k];
                    st+=c[j];
                }
            }
        }
        for (int j = 0; j < btns.length; j++) {
            if (c[j]==1)
                btns[j].setTextColor(Color.BLUE);
            if (c[j]==2)
                btns[j].setTextColor(Color.RED);
            if (c[j]==3)
                btns[j].setTextColor(Color.WHITE);
        }
    }


    @Override
    public void onClick(View v) {
        countAll++;
        Button b=(Button)v;
        tv3.setText(b.getText().toString());
        if (s.equals(b.getText().toString())) {
            countOk++;
            ImageView iv=new ImageView(this);
            iv.setImageResource(R.drawable.good);
            Toast t=new Toast(this);
            t.makeText(this, "Ok", Toast.LENGTH_SHORT);
            t.setView(iv);
            t.show();
            //mp=MediaPlayer.create(this, R.raw.applaus);
            //mp.start();
            tv3.setText("Doğru cevapların sayısı="+countOk+"\nyapılan toplam deneme="+countAll);
        }
        else {
            ImageView iv=new ImageView(this);
            iv.setImageResource(R.drawable.bad);
            Toast t=new Toast(this);
            t.makeText(this, "Ok", Toast.LENGTH_SHORT);
            t.setView(iv);
            t.show();
            //mp=MediaPlayer.create(this, R.raw.neverny_otvet);
            //mp.start();
            tv3.setText("Doğru cevapların sayısı="+countOk+"\nyapılan toplam deneme="+countAll);
        }
    }

    public void goNext03(View view) {
        goBuild();
    }

}
