package gui;

import java.awt.GridBagConstraints;

public class GUIUtilities {
	/**
	 * method to easy set a GridBagConstraints values
	 */
	public static void setGridBagConstraint(GridBagConstraints g,int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty)
	{
		g.gridx = gridx;
		g.gridy = gridy;
		g.gridwidth = gridwidth;
		g.gridheight = gridheight;
		g.weightx = weightx;
		g.weighty = weighty;
	}
}
