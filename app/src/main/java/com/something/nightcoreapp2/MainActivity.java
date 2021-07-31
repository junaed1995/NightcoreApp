package com.something.nightcoreapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.about);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref =database.getReference("AppURL");
        final DatabaseReference myRef1 = database.getReference("value1");
       final DatabaseReference  myRef2=database.getReference("value2");
        final DatabaseReference  myRef3=database.getReference("value3");
        final DatabaseReference  myRef4=database.getReference("value4");
        final DatabaseReference  myRef5=database.getReference("value5");
        final DatabaseReference  myRef6=database.getReference("value6");

        final YouTubePlayerView youTubePlayerView=findViewById(R.id.youtube_player_view);
        YouTubePlayerView youTubePlayerView1=findViewById(R.id.youtube_player_view1);
       YouTubePlayerView youTubePlayerView2=findViewById(R.id.youtube_player_view2);
        YouTubePlayerView youTubePlayerView3=findViewById(R.id.youtube_player_view3);
        YouTubePlayerView youTubePlayerView4=findViewById(R.id.youtube_player_view4);
        YouTubePlayerView youTubePlayerView5=findViewById(R.id.youtube_player_view5);
        /*
         app:videoId="Extj24k0gGM"
         app:videoId="mZc96GN9eg8"
          app:videoId="w6oMgyMl-RY"
         */
        //getLifecycle().addObserver(youTubePlayerView);

        final Button x=findViewById(R.id.shareapp);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(final YouTubePlayer youTubePlayer) {
              //  super.onReady(youTubePlayer);

                myref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                        //redirect user to latest app link;
                        x.setOnClickListener(new View.OnClickListener() {
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



                myRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value0= dataSnapshot.getValue(String.class);
                        youTubePlayer.loadVideo(value0,0); //Rvf56VTb780
                      //  Log.d("Kuno","Value is "+value0);

                        // String X=value0;
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w("tag","Failed to read");
                    }
                });
                //String Vid= "Rvf56VTb780";          //Rvf56VTb780


            }
        });

       youTubePlayerView1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(final YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value0= dataSnapshot.getValue(String.class);
                      //  Log.d("Kuno","Value is "+value0);
                        youTubePlayer.cueVideo(value0,0);    //qqoGuuqrJVE
                        // String X=value0;
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w("tag","Failed to read");
                    }
                });


            }
        });
            youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(final YouTubePlayer youTubePlayer) {
                    super.onReady(youTubePlayer);
                    myRef3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String value0= dataSnapshot.getValue(String.class);
                            Log.d("Kuno","Value is "+value0);
                            youTubePlayer.cueVideo(value0,0);    //qqoGuuqrJVE
                            // String X=value0;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.w("tag","Failed to read");
                        }
                    });

                }
            });

            youTubePlayerView3.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(final YouTubePlayer youTubePlayer) {
                   // super.onReady(youTubePlayer);
                    myRef4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String value0= dataSnapshot.getValue(String.class);
                           // Log.d("Kuno","Value is "+value0);
                            youTubePlayer.cueVideo(value0,0);    //R1-9FURlBSQ
                            // String X=value0;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.w("tag","Failed to read");
                        }
                    });

                }
            });

            youTubePlayerView4.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(final YouTubePlayer youTubePlayer) {
                   // super.onReady(youTubePlayer);
                    myRef5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String value0= dataSnapshot.getValue(String.class);
                            // Log.d("Kuno","Value is "+value0);
                            youTubePlayer.cueVideo(value0,0);    //9SVTA_hKXhM
                            // String X=value0;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.w("tag","Failed to read");
                        }
                    });

                }
            });
            youTubePlayerView5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(final YouTubePlayer youTubePlayer) {
                 //   super.onReady(youTubePlayer);
                    myRef6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String value0= dataSnapshot.getValue(String.class);
                           // Log.d("Kuno","Value is "+value0);
                            youTubePlayer.cueVideo(value0,0);
                            // String X=value0;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.w("tag","Failed to read");
                        }
                    });

                }
            });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openaboutactivity();
            }
        });
        Button b1=findViewById(R.id.morevid);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                morevidact();
            }
        });


    }
    public void openaboutactivity(){
        Intent it=new Intent(this,About_me.class);
        startActivity(it);
    }
        public void morevidact()
        {
            Intent intent=new Intent(this,more.class);
            startActivity(intent);
        }
}
