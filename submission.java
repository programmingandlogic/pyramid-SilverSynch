/*
 * File: Pyramid.java
 * ------------------
 * This program is a stub for the Pyramid problem, which draws
 * a brick pyramid.
 */

import acm.program.*;
import acm.graphics.*;

import java.util.ArrayList;

public class Pyramid extends GraphicsProgram
{
	
	// Our standard sizes for our bricks.
	int brick_x = 30;
	int brick_y = 12;
	int brick_base = 14;
	
	public void run()
	{
		
		// We need to keep this for later calculations, due to brick_base
		// being modified while running.
		int keep_count = brick_base;
		
		// This program doesn't update it's visuals based on the window
		// resizing. Sorry.
		while (brick_base > 0)
		{
			
			// Essentially, we clear the list this way. The code relies
			// on the idea that we're only dealing with one row at a time.
			ArrayList<GRect> list = new ArrayList();
			
			// We repopulate our list with the rectangles we need.
			for(int i = 0; i < brick_base; i++)
			{
				list.add(make_rect());
			}
			
			// Then we add them at co-ordinates to the canvas
			// via the most arcane section of code here.
			for (int i = 0; i < list.size(); i ++)
			{
				add(list.get(i), (getWidth()) - (brick_x * (keep_count - brick_base + i)) - ((brick_x * brick_base) / 2), getHeight() - (brick_y * (keep_count - brick_base)));
			}
			
			// Then, we iterate.
			brick_base--;
		}
		
	}
	
	// To avoid filling up hilarious amounts of memory making every single rectangle
	// and copying them into the list, we make a temporary rectangle instead.
	public GRect make_rect()
	{
		
		GRect z = new GRect(brick_x, brick_y);
		
		return z;
		
	}

}
