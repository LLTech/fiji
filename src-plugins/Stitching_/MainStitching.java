import static stitching.CommonFunctions.LIN_BLEND;
import static stitching.CommonFunctions.methodListCollection;

import java.io.File;

import ij.ImagePlus;
import ij.io.FileSaver;

public class MainStitching 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
		//Setting parameters
		File layoutPath = new File(args[0]);
		Stitch_Image_Collection object = new Stitch_Image_Collection();
		object.thresholdR = Float.parseFloat(args[1]);
		object.thresholdDisplacementRelative = Float.parseFloat(args[2]);
		object.thresholdDisplacementAbsolute = Float.parseFloat(args[3]);
		object.maxDeltaToExpectedCorrelation = Float.parseFloat(args[4]);
		String outputName = args[5];
		
		//Doing stitching
		ImagePlus img = object.work(layoutPath.getAbsolutePath(), false, true, methodListCollection[LIN_BLEND], null, true);

		//Saving image
		File tifPath = new File(layoutPath.getParentFile(), outputName+".tiff");
		new FileSaver(img).saveAsTiff(tifPath.getAbsolutePath());
	}

}
