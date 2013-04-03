ANDROID OMR
=============

The aim of this project is to allow someone to use the camera on an android device, say a tablet, and hover over physical sheet music, say Beethoven's fifth. The app should use the camera feed to create a set of monochrome bitmap images and feed them to a music notation neural network for analysis. The ANN should return a representation of the sheet music that can (and will) later be saved and viewed in a dynamic way. The motivation for this project comes from PDF music viewers being too rigid for practical music rehearsal. This is because music is restricted to the format that was originally intended for 8.5x11 inch paper (or something like that) and isn't always optimal for any size tablet screen. By encapsulating physical sheet music into a standard data structure like MusicXML or midi, music can be dynamically rendered on screen. That'd be pretty cool. 

OVERVIEW
============
STEP 1:
  - Detect Staves/Staffs
    - This is done by taking a y-projection of the bitmap, and finding groups of 5 peaks. These are staves. 
    - Note that this relies on the staves being perfectly orthogonal to the y-axis.
    - Users will likely not be able to take perfectly straight pictures, so we do a fast-fourier transform first
    - FFT finds rotation angle, and then we rotate the bitmap. 
    - this works for uniformly rotated images, but we still need to handle the case where the skew is only partial.

STEP 2:
  - Using information about how many staves there are, and where they are, try to find groups of symbols, ie treble cleft, sets of eighth notes, rests, etc.
  - This is done with an x-projection; we assume that the staves in the bitmap are already orthogonal to the y-axis at this point
  
STEP 3:  
  - partition those groups, and use a trained neural network to classify the smaller pieces
  
STEP 4:
  - that's it for now. 
  - look to improve this in many ways
  - maybe using ANNs isn't the best approach. consider KD-Nearest-Neighbor algorithms 


Merrrr. The amount of werk left on this is almost overwhelming. Help is appreciated.
