# Adapter Pattern

The Adapter Pattern is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.

Here, AdvancedMediaPlayer method(plays mp4) is incompatible with our MediaPlayer(plays mp3).
So, a MediaAdapter is written to adapt AdvancedMediaPlayer with MediaPlayer.

## Structure

- Target: The interface your code expects.

- Adaptee: The existing class with a different interface.

- Adapter: A class that translates calls from the target to the adaptee.

- Client: Uses the Target interface.

## Benefits

- Makes existing code work with new interfaces.

- Promotes reuse of legacy or third-party code.

- Reduces the need for modifying existing classes.