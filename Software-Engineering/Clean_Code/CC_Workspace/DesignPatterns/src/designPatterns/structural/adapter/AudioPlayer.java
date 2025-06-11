package designPatterns.structural.adapter;

public class AudioPlayer implements MediaPlayer{

	private MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else {
            mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, fileName);
        }
	}
}
