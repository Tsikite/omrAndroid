package com.robertkcheung.muzapp;

import fft.FFT;
import imageprocessing.BitmapConvertor;
import imageprocessing.RotateImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import midi.MidiFile;
import openomr.omr_engine.DetectionProcessor;
import openomr.omr_engine.StaveDetection;
import openomr.omr_engine.StaveParameters;
import openomr.omr_engine.YProjection;

import org.joone.net.NeuralNet;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.example.cam.R;

public class RecognizeActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recognize);
		File directory = new File(Environment.getExternalStorageDirectory()+File.separator+"muzapptest");
		File[] images = directory.listFiles();
		if(images!=null){
			Arrays.sort(images);
			File lastimg = images[images.length-1];
			try {
				FileInputStream inStream = new FileInputStream(lastimg);
				TextView tv = (TextView) findViewById(R.id.results);
				
				/* TRY TO RECOGNIZE DIS STUFFZ*/
				Bitmap buffImage = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+File.separator+"muzapptest"+File.separator+lastimg.getName());
				//Bitmap buffImage;
				buffImage = buffImage.copy(Bitmap.Config.ARGB_8888, true);
				Bitmap bwimage =buffImage;//= new DoBlackandWhite(buffImage).getBW();
				BitmapConvertor bmc = new BitmapConvertor(this);
				bmc.convertBitmap(buffImage, "bw");
				FFT ftransform = new FFT(bwimage,bwimage.getWidth());
				ftransform.doFFT();
				float angle = ftransform.getRotationAngle();
				Bitmap finalimage = new RotateImage(bwimage,angle).tilt();
				
				YProjection yproj = new YProjection(finalimage);
				yproj.calcYProjection(0, buffImage.getHeight(), 0, finalimage.getWidth());
				//yproj.printYProjection();

				
				StaveParameters params = new StaveParameters(finalimage); 
				params.calcParameters();
				
				//params.printHistogram();
				
				StaveDetection staveDetection = new StaveDetection(yproj, params);
				staveDetection.setParameters(.75, .75);
				staveDetection.locateStaves();

				if (staveDetection.getNumStavesFound() > 0)
				{
				//calculate ditsance between notes
				staveDetection.calcNoteDistance();
				
				
				
				DetectionProcessor detection = new DetectionProcessor(finalimage, staveDetection, new NeuralNet());
				detection.processAll();

				}
				MidiFile midiFile = new MidiFile(staveDetection.getStaveList());
				midiFile.makeSong();
				
				
				
				tv.setText(lastimg.getName());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}

}
