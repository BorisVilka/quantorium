package com.example.myapplication_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Toast;

import com.example.myapplication_1.databinding.ActivityMainBinding;

import java.io.File;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ActivityMainBinding binding;
    private Thread play;
    private Thread playChB;
    private final int dx = 10;
    private MediaPlayer player;
    private boolean ended = true, paused = true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.scroll.setOnTouchListener(this);
        binding.chB1.setOnTouchListener(this);
        binding.chB2.setOnTouchListener(this);
        binding.chB3.setOnTouchListener(this);
        binding.chB4.setOnTouchListener(this);
        binding.chB5.setOnTouchListener(this);
        binding.chB6.setOnTouchListener(this);
        binding.chB7.setOnTouchListener(this);
        binding.chB8.setOnTouchListener(this);
        binding.chB9.setOnTouchListener(this);
        binding.chB10.setOnTouchListener(this);
        binding.chB11.setOnTouchListener(this);
        binding.chB12.setOnTouchListener(this);
        binding.chB13.setOnTouchListener(this);
        binding.scroll.requestDisallowInterceptTouchEvent(true);
        binding.Play.setOnClickListener(view -> {
            if(play!=null) {
                paused = false;
                player.start();
                return;
            }
            try {
                player = MediaPlayer.create(getApplicationContext(),uri);
                player.setOnCompletionListener(mediaPlayer -> {
                    ended = true;
                    binding.note.setVisibility(View.INVISIBLE);
                    try {
                        playChB.interrupt();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    playChB = null;
                    clear();
                });
                player.start();
                ended = false; paused = false;
                play = new Thread(() -> {
                    while(player.isPlaying()) {
                        while(binding.scroll.canScrollHorizontally(600) && !ended && player!=null && player.isPlaying()) {
                            if(paused) continue;
                            runOnUiThread(() -> binding.scroll.scrollBy(dx,0));
                            try {
                                Thread.sleep(20);           //время между скролами
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                clear();
                            }
                        }
                        runOnUiThread(() -> binding.scroll.scrollTo(200,0));
                    }
                    if(play!=null) play.interrupt();
                    play = null;
                });
                play.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        binding.training.setOnClickListener(view -> {
            binding.Play.performClick();
            if(play!=null && playChB==null) {
                try{
                    playChB = new Thread(()->{
                       while(player!=null && player.isPlaying()) {
                           runOnUiThread(() -> setLedActive(false, 0));
                           runOnUiThread(() -> setLedActive(false, 1));
                           runOnUiThread(() -> setLedActive(false, 2));
                           runOnUiThread(() -> setLedActive(false, 3));
                           runOnUiThread(() -> setLedActive(false, 4));
                           runOnUiThread(() -> setLedActive(false, 5));
                           runOnUiThread(() -> setLedActive(false, 6));
                           runOnUiThread(() -> setLedActive(false, 7));
                           runOnUiThread(() -> setLedActive(false, 8));
                           runOnUiThread(() -> setLedActive(false, 9));
                           runOnUiThread(() -> setLedActive(false, 10));
                           runOnUiThread(() -> setLedActive(false, 11));
                           runOnUiThread(() -> setLedActive(false, 12));
                           delay(1000);
                           runOnUiThread(() -> setLedActive(true, 0));  // 1
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 0));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 7)); // 5
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 7));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 5));  // 4
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 5));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 0));;  // 1
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 0));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 0));  // 1
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 0));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 0));  // 1
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 0));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 10));  // 6/7
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 10));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 7));  // 5
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 7));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 12));  // do ^
                           delay(1500);
                           runOnUiThread(() -> setLedActive(false, 12));
                           delay(1000);
                           runOnUiThread(() -> setLedActive(true, 12));  // do ^
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 12));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 2));  // 2
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 2));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 2));  // 2
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 2));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 10));  // 6/7
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 10));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 10));  // 6/7
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 10));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 7));  // 5
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 7));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 5));  // 4
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 5));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 5));  // 4
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 5));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 7));  // 5
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 7));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 9));  // 6
                           delay(500);
                           runOnUiThread(() -> setLedActive(false, 9));
                           delay(100);
                           runOnUiThread(() -> setLedActive(true, 5));  // 4
                           delay(1500);
                           runOnUiThread(() -> setLedActive(false, 5));
                       }
                    });
                }catch (Exception e) {
                    e.printStackTrace();
                    clear();
                    playChB = null;
                }
                playChB.start();
            }
        });
        binding.chooser.setOnClickListener(view -> showFileChooser());
        binding.stop.setOnClickListener(view -> {
            if(player!=null) {
                player.stop();
                player.release();
            }
            ended = true;
            if(play!=null) play.interrupt();
            play = null;
            player = null;
            if(playChB != null) {
                playChB.interrupt();
            }
            playChB = null;
        });
    }

    private static final int FILE_SELECT_CODE = 0;

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private Uri uri;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    uri = data.getData();
                    Log.d("TAG", "File Uri: " + uri.toString());
                    // Get the pat
                    // Get the file instance
                    // File file = new File(path);
                    // Initiate the upload
                }
                break;
        }
        binding.note.setVisibility(View.VISIBLE);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static String getPath(Context context, Uri uri) {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = { "_data" };
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
            }
        }
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public void setLedActive(boolean status, int pos) {
        if(ended || playChB==null) return;
        pos+=1;
        switch (pos) {
            case 1:
                binding.chB1.setChecked(status);
                break;
            case 2:
                binding.chB2.setChecked(status);
                break;
            case 3:
                binding.chB3.setChecked(status);
                break;
            case 4:
                binding.chB4.setChecked(status);
                break;
            case 5:
                binding.chB5.setChecked(status);
                break;
            case 6:
                binding.chB6.setChecked(status);
                break;
            case 7:
                binding.chB7.setChecked(status);
                break;
            case 8:
                binding.chB8.setChecked(status);
                break;
            case 9:
                binding.chB9.setChecked(status);
                break;
            case 10:
                binding.chB10.setChecked(status);
                break;
            case 11:
                binding.chB11.setChecked(status);
                break;
            case 12:
                binding.chB12.setChecked(status);
                break;
            case 13:
                binding.chB13.setChecked(status);
                break;
        }
    }

    public void delay(int millis){
        try {
            Thread.sleep(millis);           //время между скролами
        } catch (InterruptedException e) {
            e.printStackTrace();
            clear();
        }
    }
    public void clear() {
       runOnUiThread(() -> {
           binding.chB1.setChecked(false);
           binding.chB2.setChecked(false);
           binding.chB3.setChecked(false);
           binding.chB4.setChecked(false);
           binding.chB5.setChecked(false);
           binding.chB6.setChecked(false);
           binding.chB7.setChecked(false);
           binding.chB8.setChecked(false);
           binding.chB9.setChecked(false);
           binding.chB10.setChecked(false);
           binding.chB11.setChecked(false);
           binding.chB12.setChecked(false);
           binding.chB13.setChecked(false);
       });
    }
}