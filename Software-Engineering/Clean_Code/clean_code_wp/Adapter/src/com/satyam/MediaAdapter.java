package com.satyam;

//Adapter
public class MediaAdapter implements MediaPlayer{

	private AdvancedMediaPlayer advancedMediaPlayer;
	
	public MediaAdapter() {
		advancedMediaPlayer = new AdvancedMediaPlayer();
	}
	
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("mp4"))
			advancedMediaPlayer.playMp4(fileName);
		else
			System.out.println("Format not supported by adapter: "+audioType);
	}

}
