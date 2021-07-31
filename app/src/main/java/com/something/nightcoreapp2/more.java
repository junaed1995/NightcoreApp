package com.something.nightcoreapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.lang.String;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class more extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        final Button z=findViewById(R.id.shareapp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref =database.getReference("AppURL");
      //  final DatabaseReference myRef1 = database.getReference("value_new");
            final DatabaseReference[] ref=new DatabaseReference[25];
            for(int i=7;i<=27;i++)
            {
                String s= "value";
               String x=s.concat(String.valueOf(i));
                ref[i-7]=database.getReference(x);
            }
            /*
            ref[0]= database.getReference("value7");
            ref[1]= database.getReference("value8");
            ref[2]=database.getReference("value9");*/

       // final DatabaseReference myRef1 = database.getReference("value_new");
       // YouTubePlayerView youTubePlayerView1=findViewById(R.id.youtube_player_view);
        YouTubePlayerView[] youTubePlayerViews=new YouTubePlayerView[25];


       /* for(int i=0;i<4;i++)
        {
            youTubePlayerViews[i]=findViewById(R.id.youtube_player_viewi)
        }*/

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                //redirect user to latest app link;
                z.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent viewIntent= new Intent(Intent.ACTION_VIEW, Uri.parse(dataSnapshot.getValue(String.class)));
                        startActivity(viewIntent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        youTubePlayerViews[0]=findViewById(R.id.youtube_player_view);
        youTubePlayerViews[1]=findViewById(R.id.youtube_player_view1);
        youTubePlayerViews[2]=findViewById(R.id.youtube_player_view2);
        youTubePlayerViews[3]=findViewById(R.id.youtube_player_view3);
        youTubePlayerViews[4]=findViewById(R.id.youtube_player_view4);  //jheUWxpG0HI   _8vMAfVE3IU
        youTubePlayerViews[5]=findViewById(R.id.youtube_player_view5);
        youTubePlayerViews[6]=findViewById(R.id.youtube_player_view6);
        youTubePlayerViews[7]=findViewById(R.id.youtube_player_view7);
        youTubePlayerViews[8]=findViewById(R.id.youtube_player_view8);
        youTubePlayerViews[9]=findViewById(R.id.youtube_player_view9);
        youTubePlayerViews[10]=findViewById(R.id.youtube_player_view10);
        youTubePlayerViews[11]=findViewById(R.id.youtube_player_view11);
        youTubePlayerViews[12]=findViewById(R.id.youtube_player_view12);
        youTubePlayerViews[13]=findViewById(R.id.youtube_player_view13);
        youTubePlayerViews[14]=findViewById(R.id.youtube_player_view14);
        youTubePlayerViews[15]=findViewById(R.id.youtube_player_view15);
        youTubePlayerViews[16]=findViewById(R.id.youtube_player_view16);
        youTubePlayerViews[17]=findViewById(R.id.youtube_player_view17);  //jheUWxpG0HI   _8vMAfVE3IU
        youTubePlayerViews[18]=findViewById(R.id.youtube_player_view18);
        youTubePlayerViews[19]=findViewById(R.id.youtube_player_view19);
        youTubePlayerViews[20]=findViewById(R.id.youtube_player_view20);

      //  YouTubePlayerView youTubePlayerView2=findViewById(R.id.youtube_player_view1);


            for( int i=0;i<=20;i++) {
                final int finalI = i;
                youTubePlayerViews[i].addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(final YouTubePlayer youTubePlayer) {
                        // super.onReady(youTubePlayer);
                       // final i;
                        ref[finalI].addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String s = dataSnapshot.getValue(String.class);
                                youTubePlayer.cueVideo(s, 0);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });
            }

        Button btn1=findViewById(R.id.morevid);
        Button btn2=findViewById(R.id.about);
        // Button btn3=findViewById(R.id.shareapp);

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 morevidact();
             }
         });
         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openaboutactivity();
             }
         });





    }
    public void openaboutactivity(){
        Intent it=new Intent(this,About_me.class);
        startActivity(it);
    }
    public void morevidact()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}