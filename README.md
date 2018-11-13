# Amnesia Video Tool


AVT is a small Java utility used to generate files which make it easier to render a series of images in the HPL2 game engine, the engine for Amnesia - The Dark Descent made by Frictional Games.

## Features

AVT allows you to do the following:
* Generate material (\*.mat) and entity (\*.ent) files for each image frame.
* Generate mesh placeholder files which the images will be applied to.
* Generate a script file, either minified or documented, which can be copied into the level to render the animation.

It does not:
* Separate videos into image frames. This you will have to do on your own.
* Make sure your frames use a pow^2 resolution.

## Usage

See the Youtube video on how to use it [here](https://www.youtube.com/watch?v=cIxWc7TIlIw) or read the fine print below.


To start off, you need to acquire a sequence of images that will make up your
video. There are tools for extracting videos and gifs into separate images.
Adobe Photoshop can do this, and probably other free tools like Gimp.

Once you have your sequence, use the app to generate the required files for
Amnesia:

### File setup
* Name prefix
        - Whatever your sequence is named (for example frame_00.png,
          frame_01.png, frame_02.png etc), this is the prefix. In this case
          "frame_".
* Number progression
        - x+ will number things normally. The others will use a certain amount
          of leading zeros. The appropriate setting for the above example is
          "xx". Remember that numbering starts at 0.
* File extension
        - The extension matching your image files.

### Animation
* Number of frames
        - The total number of frames in your animation. If you have 100 frames
          input 100. The total is the number of your last frame + 1 (because
          it starts at 0).

### Export options
* Material files
        - The .mat files needed. Required.
* Entity files
        - The .ent files needed. Also required.
* Level script
        - The script which animates the frames in the game. Optional if you
          want to make your own script, but I highly recommend this one. You
          can also edit it if you want to.
    -- Minimalized
        - If you don't plan on editing or reading the script, you can use this
          setting which will make the script highly compact and spread across
          a single line. Useful if you want it to take as little space in your
          .hps file as possible.
* Video placeholder files
        - You need 1 set of these files for the animation to work. Keep them in
          the same folder as your frames.


Once you're done, hit "Generate files" and choose the folder for your frames.

### In your project
Copy the exported script into your <Level>.hps file. The script gives you the
following functions:

```cpp
void PreloadAnimation(string asName, string asArea, int frameAmount);
void StartImageAnimation(string asName, string asArea, string asFromArea, int
    frameAmount, int fps, bool abLoop);
void StopImageAnimation(string asName, bool abRemove);
```

You MUST call PreloadAnimation before you play start the animation. This will
load all your frames into the game at a specified area (place them outside your
level somewhere hidden for best effect).

After the animation is loaded, you can play and stop it using the other two
scripts. The `asFromArea` refers to the area used in the preload function.

Remember that `asName` here must be the same as the prefix you put into the app.
E.G. "frame_".
